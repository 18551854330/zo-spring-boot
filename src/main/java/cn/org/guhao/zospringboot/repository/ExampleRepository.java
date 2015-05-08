package cn.org.guhao.zospringboot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.org.guhao.zospringboot.domain.Example;

public interface ExampleRepository extends PagingAndSortingRepository<Example, Long> {

}
