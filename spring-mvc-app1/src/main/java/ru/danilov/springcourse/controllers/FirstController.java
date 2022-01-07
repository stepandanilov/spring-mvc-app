package ru.danilov.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

	@GetMapping("/hello")
	public String helloPage(@RequestParam(value = "name", required = false) String name, 
							@RequestParam(value = "surname", required = false) String surname, 
							Model model) {
		
		// System.out.println("Hello, " + name + " " + surname);
		model.addAttribute("message", "Hello, " + name + " " + surname);
		
		
		return "first/hello";
	}
	
	@GetMapping("/goodbye")
	public String goodbyePage() {
		return "first/goodbye";
	}
	
	@GetMapping("/calculator")
	public String calculatorPage(@RequestParam("a") int a, 
								@RequestParam("b") int b,
								@RequestParam("action") String action,
								Model model) {
		
		float answer;
		String operation;
		switch(action) {
			case "addition":
				answer = a + b;
				operation = "+";
				break;
			case "subtraction":
				answer = a - b;
				operation = "-";
				break;
			case "multiplication":
				answer = a * b;
				operation = "*";
				break;
			case "division":
				answer = a / b;
				operation = "/";
				break;
			default:
				answer = 0;
				operation = "null";
		}
		
		model.addAttribute("answer", a + operation + b + " = " + answer);
		return "first/calculator";
	}
}
