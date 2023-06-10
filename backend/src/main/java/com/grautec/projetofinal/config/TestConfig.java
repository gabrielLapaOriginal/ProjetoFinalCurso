package com.grautec.projetofinal.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.grautec.projetofinal.entities.Medico;
import com.grautec.projetofinal.repositories.MedicoRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	
	@Autowired
	MedicoRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Medico m1 = new Medico(null, "Marcelo Krause", "Ortopedista");
		Medico m2 = new Medico(null, "Jaime da Fonte", "Cardiologista");
		Medico m3 = new Medico(null, "Inês Constante", "Ginecologista");
		Medico m4 = new Medico(null, "Suzi Furacão", "Urologista");
		Medico m5 = new Medico(null, "Hugo Ricardo", "Oftamologista");
		Medico m6 = new Medico(null, "Mariana Amorim", "Endócrinologista");
		Medico m7 = new Medico(null, "Ester Tigresa", "Fisioterapeuta");
		Medico m8 = new Medico(null, "Violeta Samara", "Dermatologista");
		Medico m9 = new Medico(null, "Clóvis Basílio", "Otorrinolaringologista");
		Medico m10 = new Medico(null, "Ed Júnior", "Gastroenterologista");
		Medico m11 = new Medico(null, "Elisa Sanches", "Hematologista");
		Medico m12 = new Medico(null, "Jordi El Niño", "Clínico Geral");
		Medico m13 = new Medico(null, "Jonny Sins", "Neurologista");
		
		
		repository.saveAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13));
	}

}
