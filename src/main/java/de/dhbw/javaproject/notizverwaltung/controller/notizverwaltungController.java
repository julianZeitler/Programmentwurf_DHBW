package de.dhbw.javaproject.notizverwaltung.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.dhbw.javaproject.notizverwaltung.model.Notiz;

@RestController
public class notizverwaltungController 
{
	static List<Notiz> notizListe;

	/*
	@RequestMapping("/add")
	public boolean addPersons() {
		if (personList == null)
			personList = new ArrayList<Person>();
		personList.add(new Person("Peter", 26));
		personList.add(new Person("Monika", 42));
		return true;
	}

	@RequestMapping(value = "/addPersonMitPfad/{name}/{alter}", method = RequestMethod.GET)
	public @ResponseBody boolean addPersonMitPfad(@PathVariable("name") String name,
			@PathVariable("alter") String alter) {
		if (personList == null)
			personList = new ArrayList<Person>();
		personList.add(new Person(name, Integer.parseInt(alter)));
		return true;
	}

	@GetMapping("/addPersonMitGETQuery")
	public @ResponseBody boolean addPersonMitGETQuery(@RequestParam String name, @RequestParam String alter) {
		if (personList == null)
			personList = new ArrayList<Person>();
		personList.add(new Person(name, Integer.parseInt(alter)));
		return true;
	}

	// Tut leider nicht, wegen CSRF-Sicherheitseinstellungen, es sei denn man 
	// modifiziert die Sicherheitseinstellungen (siehe Klasse: WebSecurityConfig)
	@PostMapping("/addPersonMitPOSTQuery")
	public boolean addPersonMitPOSTQuery(@RequestParam String name, @RequestParam String alter) {
		if (personList == null)
			personList = new ArrayList<Person>();
		personList.add(new Person(name, Integer.parseInt(alter)));
		return true;
	}
	

	@RequestMapping("/list")
	public List<Person> getPersons() {
		if (personList == null)
			personList = new ArrayList<Person>();
		return personList;
	}

	@RequestMapping("/count")
	public int count() {
		if (personList == null)
			return (0);
		else
			return (personList.size());
	}
*/
	@RequestMapping("/")
	public String home() {
		
		String str = "<html>Hallo Rolf, hier ist die Welt<br>\n" 
				+ "Notizen:<br>\n" 
				+ "<table>"
				+ "	<tr>"
				+ "		<th>ID</th>"
				+ "		<th>Notiz</th>"
				+ "	</tr> " ;
		
		for( Notiz n : notizListe) {
			str = str + "<tr><td> " + n.getID() + " </td> <td> " + n.getInhalt() + " </td></tr>";
		}
		
		str = str + "</table> </html>";
		
		return (str);

	}
	
}