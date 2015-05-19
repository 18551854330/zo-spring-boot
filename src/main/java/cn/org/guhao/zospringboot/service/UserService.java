package cn.org.guhao.zospringboot.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.org.guhao.zospringboot.domain.User;
import cn.org.guhao.zospringboot.repository.UserRepository;

@Service
public class UserService{

	@Autowired
	private UserRepository repo;
	
	public User findByUsername(String username) {
		List<User> users = repo.findByUsername(username);
		if(CollectionUtils.isNotEmpty(users) && users.size()>0){
			return users.get(0);
		}
		return null;
	}
	
	/**
	 * authorization
	 */
	public boolean auth(String username, String password) {
		User user = findByUsername(username);
		if(user != null && password.equals(user.getPassword())){
			return true;
		}
		return false;
	}

}
