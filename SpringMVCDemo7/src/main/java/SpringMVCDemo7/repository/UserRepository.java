package SpringMVCDemo7.repository;

import java.util.List;

import SpringMVCDemo7.pojos.User;

public interface UserRepository {
	boolean addUser(User user);
	List<User> getUsers(String username);
	User getUserById(int userId);
}
