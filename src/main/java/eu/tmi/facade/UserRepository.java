package eu.tmi.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.tmi.model.User;

@Repository
public class UserRepository extends AbstractFacade<User>{

  
  @Autowired PasswordEncoder passwordEncoder;
  
  public UserRepository() {
    super(User.class);
  }

  public User findByUserName(String username) {
    return getEntityManager().createQuery( "from User where login = :login", User.class)
            .setParameter("login", username)
            .getSingleResult();
  }
  
  @Transactional
  @Override
  public void edit(User entity) {
    entity.setPassword( passwordEncoder.encode( entity.getPassword() ));
    super.edit(entity);
  }

  @Transactional
  @Override
  public void create(User entity) {
    entity.setPassword( passwordEncoder.encode( entity.getPassword() ));
    super.create(entity);
  }
}
