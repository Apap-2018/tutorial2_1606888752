package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name", required = false, defaultValue = "kiki") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping("/challenge/{name}")
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent() ) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required = false, defaultValue = "0" ) int a,@RequestParam(value = "b", required=false, defaultValue="0") int b, Model model) {
		String value = "";
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		
		if (a== 0 && b==0) {
			value = "hm";
		} else {
			if (a == 0) {
				a=1;
			}
			String count1 = "h";
			String count2 ="";
			for(int i = 0;i<a;i++) {
				count1+= "m";
			}
			for(int i = 0;i<b;i++) {
				count2 += count1+ " ";
			}
			value =count2;
		}
		model.addAttribute("value", value);
		return "generator";
	}
}
