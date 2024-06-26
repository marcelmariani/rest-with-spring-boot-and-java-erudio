package br.com.marcelmariani.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcelmariani.exceptions.ResouceNotFoundExceptions;
import br.com.marcelmariani.model.Person;
import br.com.marcelmariani.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<Person> findAll() {

		logger.info("Finding All Person!");

		return repository.findAll();
	}

	public Person findById(Long id) {

		logger.info("Finding one Person!");

		Person person = new Person();
		// person.setId(counter.incrementAndGet());
		person.setFisrtName("Marcel");
		person.setLastName("Mariani");
		person.setAddress("SL");
		person.setGender("M");

		return repository.findById(id).orElseThrow(() -> new ResouceNotFoundExceptions("No records found for this ID"));
	}

	public Person create(Person person) {

		logger.info("Creating one Person!");

		return repository.save(person);

	}

	public Person update(Person person) {

		logger.info("Creating one Person!");

		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResouceNotFoundExceptions("No records found for this ID"));

		entity.setFisrtName(person.getFisrtName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repository.save(person);

	}

	public void delete(Long id) {

		logger.info("Deleting one Person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResouceNotFoundExceptions("No records found for this ID"));
		
		repository.delete(entity);

	}

}
