package apptestweb.it.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


//L'annotation @EnableWebMvc viene utilizzata in concomitanza con l'annotation @Configuration 
//e abilita la funzionalità di Spring MVC nell'applicazione. 
//@Configuration viene utilizzata per utilizzare la classe come classe di configurazione per l'app.
//@ComponentScan individua e registra su un determinato package i beans 

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "apptestweb.it.test.controller")
public class WebConfig {

}
