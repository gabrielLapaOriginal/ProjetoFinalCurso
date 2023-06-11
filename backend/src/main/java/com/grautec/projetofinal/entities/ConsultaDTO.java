package com.grautec.projetofinal.entities;

import java.util.List;

public class ConsultaDTO {

	private List<Consulta> consultas;
	private List<Medico> medicos;
	
	public ConsultaDTO() {}

	public ConsultaDTO(List<Consulta> consultas, List<Medico> medicos) {
		super();
		this.consultas = consultas;
		this.medicos = medicos;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	
	
	
}
