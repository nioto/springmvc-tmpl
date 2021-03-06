/**
 * 
 */
package eu.tmi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author tonio
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class User extends BaseEntity {

  private static final long serialVersionUID = 3939839238361182149L;

<<<<<<< HEAD
  @Column(unique=true, nullable=false)
=======
  @UniqueConstraint
>>>>>>> dc3c0d5cffe0d91618c1e054faae919a607526db
  @Size( min=4, max=16)
  String login;
  String password;

  @ElementCollection(targetClass = Role.class, fetch= FetchType.EAGER) 
  @CollectionTable(name = "tbl_roles", joinColumns = @JoinColumn(name = "user_id"))
  @Column(name = "role_id")
  Set<Role> roles = new HashSet<Role >();
}