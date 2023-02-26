package apptestweb.it.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class WelcomeController {
	//Con l'annotazione @ResponseBody utilizziamo il valore restituito dal controller, in questo caso una stringa
	//e la visualizziamo nel corpo del HTTP.
	@ResponseBody
	@RequestMapping("/")
	public String welcome() {
		return "Benveuto Michele";
	}
	
	@ResponseBody
	@GetMapping("/saluto")
	public String saluto(HttpServletRequest request) {
		if(request.getParameter("name") != null && !request.getParameter("name").trim().equals(""))
		return "Ciao " + request.getParameter("name");
		
		return "Ciao, non ti conosco";
	}
	
	@ResponseBody
	@GetMapping("/saluto2")
	public String saluto2(HttpSession session) {
		if(session.getAttribute("name") == null)
			session.setAttribute("name", "Michele");
		
		return "Ciao " + session.getAttribute("name").toString();
	}
	
	@ResponseBody
	@GetMapping("/saluto3")
	public String saluto3(@RequestParam("name") String nome) {
		return "Ciao " + nome;
	}
	
	@ResponseBody
	@GetMapping("/saluto4")
	public String saluto4(@RequestHeader("User-Agent") String userAgent, @CookieValue("JSESSIONID") String lang_id) {
		return "Ciao, tu sei con il browser " + userAgent + "------E la cookie jsession id è " + lang_id;
	}
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	//Con la redirect possiamo cambiare il path e anche l'utente vede il cambio path
	@GetMapping("/redirect")
	public String goToNewPage() {
		return "redirect:/hello";
	}
	
	//Con il forward il cambio avviene in maniera nascosta, il path resta lo stesso ma internamente usa un altro path
	@GetMapping("/forward")
	public String forwardToNewPage() {
		return "forward:/hello";
	}

}
