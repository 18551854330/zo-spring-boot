package cn.org.guhao.zospringboot.service;

import cn.org.guhao.zospringboot.domain.User;

public interface UserService {
	
	public boolean auth(String username, String password);

	public User findByUsername(String username);
	
}
