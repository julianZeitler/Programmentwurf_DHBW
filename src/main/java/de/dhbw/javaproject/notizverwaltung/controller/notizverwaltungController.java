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
	
	@RequestMapping("/new")
	public @ResponseBody String save(@RequestParam String inhalt) throws Exception {
		db.addNotiz(inhalt);
		return "Added successfuly! <br> <a href=\"/\">Return to home</a>";
	}
	
	@RequestMapping("/save")
	public @ResponseBody String save(@RequestParam int id, @RequestParam String inhalt) throws Exception {
		db.updateNotiz(id, inhalt);
		return "Save successful! <br> <a href=\"/\">Return to home</a>";
	}
	
	@RequestMapping("/")
	public String home() throws Exception {
		
		this.notizListe = db.getNotizen();
		
		String str = "<html>"
				+ "<h1>Notizbuch</h1>\n" 
				+ "<h2>Notizen</h2>\n" 
				+ "<table>"
				+ "	<tr>"
				+ "		<th>ID</th>"
				+ "		<th>Notiz</th>"
				+ "		<th> </th>"
				+ "	</tr> " ;
		
		for( Notiz n : notizListe) {
			str = str + "<tr>"
					+ "<form action=\"/save\" Method=\"GET\">"
					+ "<td> <input name=\"id\" type=\"text\" value=\"" + n.getID() + "\" /></td> "
					+ "<td> <input name=\"inhalt\" type=\"input\" value=\"" + n.getInhalt() + "\" /> </td>"
					+ "<td> <input name=\"speichern\" type=\"submit\"/></td> </form> </tr>";
		}
		
		str = str + "</table>"
				+ "<h2>Neue Notiz</h2>"
				+ "<form action=\"/new\" Method=\"GET\">"
				+ "<input name=\"inhalt\" type=\"input\" />"
				+ "<input name=\"speichern\" type=\"submit\"/> "
				+ "</form>"
				+ "</html>";
		
		return (str);

	}
	
}