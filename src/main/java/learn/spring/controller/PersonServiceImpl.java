package learn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.spring.model.Person;

@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	IPersonDao personDao;
	
	public void savePerson(Person p) {
		personDao.savePerson(p);
	}

	public List<Person> listPersons() {
		return personDao.listPersons();
	}

}
