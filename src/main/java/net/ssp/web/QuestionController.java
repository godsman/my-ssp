package net.ssp.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.ssp.domain.Question;
import net.ssp.domain.QuestionRepository;
import net.ssp.domain.User;

@Controller
@RequestMapping("/questions")
public class QuestionController
{
	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("/form")
	public String form(HttpSession session) {
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "/users/loginForm";
		}
		return "/qna/form";
	}
	
	@PostMapping("")
	public String create(String title, String contents, HttpSession session) {
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "/users/loginForm";
		}
		
		User sessionedUser = HttpSessionUtils.getUserFromSession(session);
		Question newQuestion = new Question(sessionedUser.getUserId(), title, contents);
		
		questionRepository.save(newQuestion);
		
		return "redirect:/";
	}
}
