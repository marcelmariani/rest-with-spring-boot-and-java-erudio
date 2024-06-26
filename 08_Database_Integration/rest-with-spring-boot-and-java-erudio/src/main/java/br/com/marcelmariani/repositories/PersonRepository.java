package br.com.marcelmariani.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.marcelmariani.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
