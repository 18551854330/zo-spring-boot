package cn.org.guhao.zospringboot.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.org.guhao.zospringboot.domain.Example;
import cn.org.guhao.zospringboot.domain.User;

public interface UserRepository extends PagingAndSortingRepository<Example, Long> {

	public List<User> findByUsername(String username);
	
}
