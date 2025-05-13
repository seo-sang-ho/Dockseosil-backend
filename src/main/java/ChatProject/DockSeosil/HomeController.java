package ChatProject.DockSeosil;

import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;

@RestController
@RequestMapping("/api")
public class HomeController {

	@GetMapping("/hello")
	public String home(){
		return "index";
	}
}
