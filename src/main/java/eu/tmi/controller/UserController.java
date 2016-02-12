package eu.tmi.controller;

import java.util.EnumSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import eu.tmi.facade.UserRepository;
import eu.tmi.model.Role;
import eu.tmi.model.User;

@Controller
public class UserController {


  @Autowired UserRepository repository;
  
  
  @RequestMapping(path="/users")
  public String list(Model model) {
    System.out.println( repository );
    List<User> users = repository.findAll();
    
    model.addAttribute("users", users );
    return "users/list";
  }
  
  @RequestMapping(path="/users/add")
  public void add() {
    System.out.println( repository );
    User u = new User();
    u.setLogin("user1");
    u.setPassword("pwd1");
    u.setRoles(EnumSet.of( Role.ADMIN, Role.USER));
    repository.create( u );
    u = new User();
    u.setLogin("user2");
    u.setPassword("pwd2");
    u.setRoles(EnumSet.of( Role.USER));
    repository.create( u );
  }
}
