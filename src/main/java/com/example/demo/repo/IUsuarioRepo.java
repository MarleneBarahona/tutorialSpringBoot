package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Persona;
import com.example.demo.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {

	
	
}
