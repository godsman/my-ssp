package net.ssp.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.ssp.domain.User;
import net.ssp.domain.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController
{
	private List<User> users = new ArrayList<User>();
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/loginForm")
	public String loginForm() {
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String login(String userId, String password, HttpSession session) {
		User user = userRepository.findByUserId(userId);
		if(user == null) {
			System.out.println("Login-user Failed!");
			return "redirect:/users/loginForm";
		}
		
		if (!password.equals(user.getPassword())) {
			System.out.println("Login-password Failed!");
			return "redirect:/users/loginForm";
		}

		System.out.println("Login Success!");
		session.setAttribute("sessionedUser",  user);
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("sessionedUser");
		return "redirect:/";
	}
	
	@GetMapping("/form")
	public String form() {
		return "/user/form";
	}
	
	@PostMapping("") // 새로운 사용자 추가
	public String create(User user) {
		System.out.println("User " + user);
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("") //목록을 의미함
	public String list(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "/user/list";
	}
	
	@GetMapping("/{id}/form")
	public String updateForm(@PathVariable Long id, Model model, HttpSession session) {
		Object tempUser = session.getAttribute(HttpSessionUtils.USER_SESSION_KEY);
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "redirect:/users/loginForm";
		}
		
		User sessionedUser = HttpSessionUtils.getUserFromSession(session);
		if (!sessionedUser.matchId(id)) {
			throw new IllegalStateException("자신의 정보만 수정할 수 있습니다.");
		}
		
		User user = userRepository.findOne(id);
		model.addAttribute("user", user);
		return "/user/updateForm";
	}

	@PutMapping("/{id}") //<input type="hidden" name="_method" value="put"/>
	public String update(@PathVariable Long id, User updatedUser, HttpSession session) {
		Object tempUser = session.getAttribute(HttpSessionUtils.USER_SESSION_KEY);
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "redirect:/users/loginForm";
		}

		User sessionedUser = HttpSessionUtils.getUserFromSession(session);
		if (!sessionedUser.matchId(id)) {
			throw new IllegalStateException("자신의 정보만 수정할 수 있습니다.");
		}

		User user = userRepository.findOne(id);
		user.update(updatedUser);
		userRepository.save(user);
		return "redirect:/users";
	}
}
