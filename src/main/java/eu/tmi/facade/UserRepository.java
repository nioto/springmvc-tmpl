package eu.tmi.facade;

import org.springframework.stereotype.Repository;

import eu.tmi.model.User;

@Repository
public class UserRepository extends AbstractFacade<User>{

  public UserRepository() {
    super(User.class);
  }
}
