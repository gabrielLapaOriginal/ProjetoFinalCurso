package com.grautec.projetofinal.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_medicos")
public class Medico implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedico;
	private String nome;
	private String especialidade;
	
	@JsonIgnore
	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas = new ArrayList<>();
	
	public Medico() {}

	public Medico(Integer idMedico, String nome, String especialidade) {
		super();
		this.idMedico = idMedico;
		this.nome = nome;
		this.especialidade = especialidade;
	}

	public Integer getId_medico() {
		return idMedico;
	}

	public void setId_medico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	
	
	public List<Consulta> getConsultas() {
		return consultas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMedico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		return Objects.equals(idMedico, other.idMedico);
	}
	
	
}
