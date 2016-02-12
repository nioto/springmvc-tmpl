package eu.tmi.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
public abstract class AbstractFacade<T> {

  @PersistenceContext(unitName = "entityManager")
  private EntityManager entityManager;

  private Class<T> entityClass;

  public AbstractFacade(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  public AbstractFacade() {
  }

  protected EntityManager getEntityManager() {
    return this.entityManager;
  }

  @Transactional
  public void create(T entity) {
    this.entityManager.persist(entity);
  }

  @Transactional
  public void edit(T entity) {
    this.entityManager.merge(entity);
  }

  @Transactional
  public void remove(T entity) {
    this.entityManager.remove(this.entityManager.merge(entity));
  }

  public T find(Long primaryKey) {
    return this.entityManager.find(entityClass, primaryKey);
  }

  @SuppressWarnings("rawtypes")
  public List<T> findAll() {
    CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
    cq.select(cq.from(entityClass));
    return this.entityManager.createQuery(cq).getResultList();
  }
}