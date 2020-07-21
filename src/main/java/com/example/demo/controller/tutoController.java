package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Persona;
import com.example.demo.repo.IPersonaRepo;

@Controller
public class tutoController {

	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		Persona p = new Persona();
		p.setNombre("aiuda");
		p.setIdPersona(1);
		repo.save(p);
		
		model.addAttribute("name", name);
		return "greeting";
	}
}
