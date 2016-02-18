package eu.tmi.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import eu.tmi.model.Role;
import eu.tmi.model.User;

public class MyUserDetails extends org.springframework.security.core.userdetails.User {

  private static final long serialVersionUID = -3649751133216967723L;
  public MyUserDetails(User user) {
    super( user.getLogin(), user.getPassword(), convert( user.getRoles() ) );
  }
  
  
  
  private final static Collection<? extends GrantedAuthority> convert( Set<Role> roles){
    return roles.stream().map( r -> new SimpleGrantedAuthority(r.name())).collect( Collectors.toList());
  }
  
}
