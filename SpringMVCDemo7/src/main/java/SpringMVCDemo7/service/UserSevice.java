package SpringMVCDemo7.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import SpringMVCDemo7.pojos.User;

public interface UserSevice extends UserDetailsService{
	boolean addUser(User user);
	List<User> getUsers(String username);
	User getUserById(int userId);
}
