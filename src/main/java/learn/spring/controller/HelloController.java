package learn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import learn.spring.model.Person;

@Controller
public class HelloController {
	
	@Autowired
	IPersonService personService;
	
	@RequestMapping(path = "/insertPerson", method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
		Person person = new Person(name, age);
		personService.savePerson(person);
		model.addAttribute("msg", "Person saved successfully");
        return "person";
    }
	
	@RequestMapping(path = "/listPersons", method = RequestMethod.GET)
    public String hello2(Model model) {
		List<Person> listPersons = personService.listPersons();
        model.addAttribute("listPersons", listPersons);
        return "listPersons";
    }

}
