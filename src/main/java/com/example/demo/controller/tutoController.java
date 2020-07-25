package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		p.setNombre("aber");
		p.setIdPersona(3);
		repo.save(p);
		
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("personas", repo.findAll());
		return "greeting";
	}
	
    @RequestMapping("/")
    public String getIndex(Model model){
        model.addAttribute("page","index");
        return "index";
    }
    
    @RequestMapping("/skatteberegning")
    public String getSkatteberegning(Model model){
        model.addAttribute("page","skatteberegning");
        return "index";
    }

    @RequestMapping("/minside")
    public String getMinside(Model model){
        model.addAttribute("page","minside");
        return "index";
    }
    
    @GetMapping("/bootstrapxd")
    public String getHeader(Model model){

		model.addAttribute("personas", repo.findAll());
        //model.addAttribute("header","header");
        return "bootstrapxd";
    }
}
