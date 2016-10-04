package net.ssp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Ctrl + Shift + o
public class WelcomeController
{
	@GetMapping("/helloworld")
	public String welcome(String name, int age, Model model) {
		System.out.println("name : " + name + "age : " + age);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "welcome"; //welcome.html
	}
}
