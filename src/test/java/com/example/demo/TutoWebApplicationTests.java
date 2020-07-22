package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.model.Usuario;
import com.example.demo.repo.IUsuarioRepo;

@SpringBootTest
class TutoWebApplicationTests {

	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void crearUsuarioTest() {
		Usuario us = new Usuario();
		us.setId(2);
		us.setNombre("ahya");
		us.setClave(encoder.encode("123"));
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}

}
