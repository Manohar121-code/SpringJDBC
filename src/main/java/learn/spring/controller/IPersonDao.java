package learn.spring.controller;

import java.util.List;

import learn.spring.model.Person;

public interface IPersonDao {

	public void savePerson(Person p);

	public List<Person> listPersons();
}
