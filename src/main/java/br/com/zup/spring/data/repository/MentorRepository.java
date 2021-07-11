package br.com.zup.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.spring.data.orm.Mentor;

public interface MentorRepository extends CrudRepository<Mentor, Long>{

}
