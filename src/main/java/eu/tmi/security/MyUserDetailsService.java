package eu.tmi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import eu.tmi.facade.UserRepository;
import eu.tmi.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  UserRepository userRepository;
  
  public MyUserDetailsService() {
    // TODO Auto-generated constructor stub
    super();
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println( ">>>>" + userRepository );
    User user = userRepository.findByUserName( username );
    return new MyUserDetails(user);
  }

}
