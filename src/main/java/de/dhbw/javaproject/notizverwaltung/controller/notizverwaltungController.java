package de.dhbw.javaproject.notizverwaltung.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.dialect.DB2390Dialect;
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
import de.dhbw.javaproject.notizverwaltung.DBAccess;

@RestController
public class notizverwaltungController 
{
	private List<Notiz> notizListe;
	
	DBAccess db = new DBAccess();

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
	
	@RequestMapping("/save")
	public @ResponseBody boolean save(@RequestParam int id, @RequestParam String inhalt) {
		
		
		return true;
	}
	
	@RequestMapping("/")
	public String home() throws Exception {
		
		this.notizListe = db.getNotizen();
		
		String str = "<html>Hallo Rolf, hier ist die Welt<br>\n" 
				+ "Notizen:<br>\n" 
				+ "<table>"
				+ "	<tr>"
				+ "		<th>ID</th>"
				+ "		<th>Notiz</th>"
				+ "	</tr> " ;
		
		for( Notiz n : notizListe) {
			str = str + "<tr>"
					+ "<form action=\"/save\" Method=\"GET\">"
					+ "<td> <input name=\"id\" type=\"input\" value=\"" + n.getID() + "\" /> </td> <td> "
					+ "<input name=\"inhalt\" type=\"input\" value=\"" + n.getInhalt() + "\" /> </td>"
					+ "<input name=\"speichern\" type=\"submit\"/> </form> </tr>";
		}
		
		str = str + "</table> "
				+ "<form action=\"/save\" Method=\"GET\">\n\"\n"
				+ "Name: <input name=\"name\" type=\"input\"/><br>\n\" \n"
				+ "Alter: <input name=\"alter\" type=\"input\"/><br>\n\"\n"
				+ "<input name=\"speichern\" type=\"submit\"/><br>\n\" \n"
				+ "</form>\\n\""
				+ "</html>";
		
		return (str);

	}
	
}