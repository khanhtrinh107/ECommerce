package SpringMVCDemo7.service.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import SpringMVCDemo7.pojos.User;
import SpringMVCDemo7.repository.UserRepository;
import SpringMVCDemo7.service.UserSevice;
@Service("userDetailsService")
public class UserServiceImpl implements UserSevice{
	@Autowired
	private UserRepository userRepository;
	@Override
	public boolean addUser(User user) {
		user.setUserRole(User.USER);
		return userRepository.addUser(user);
	}
	@Override
	public List<User> getUsers(String username) {
		return userRepository.getUsers(username);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> users = userRepository.getUsers(username);
		if (users.isEmpty())
			throw new UsernameNotFoundException("Not Found");
		User u = users.get(0);
		Set<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(u.getUserRole()));
		return new org.springframework.security.core.userdetails.User(u.getUsername(),u.getPassword(),authorities);
	}

	@Override
	public User getUserById(int userId) {
		return this.userRepository.getUserById(userId);
	}

}
