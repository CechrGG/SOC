package springTest.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class springController {
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
