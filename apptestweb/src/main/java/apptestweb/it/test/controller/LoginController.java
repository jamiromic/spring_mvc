package apptestweb.it.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
   
	@ResponseBody
	@RequestMapping(path = {"/login","/login1"})   //Possiamo inserire un array di Path
	public String login() {
		return "Ciao io sono il login";
	}
}
