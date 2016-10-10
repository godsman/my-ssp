package net.ssp.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Ctrl + Shift + o
public class WelcomeController
{
	@GetMapping("/helloworld")
	public String welcome(Model model) {
//		List<MyModel> repo = new ArrayList<MyModel>();
		List<MyModel> repo = Arrays.asList(new MyModel("javajigi"), new MyModel("hub"), new MyModel("rip"));
		
		model.addAttribute("repo", repo);
		return "welcome"; //welcome.html
	}
}
