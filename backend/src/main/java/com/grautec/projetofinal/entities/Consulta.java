package com.grautec.projetofinal.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_consultas")
public class Consulta implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsulta;
	private String dataDaConsulta;
	private String horaDaConsulta;
	
	private Integer medicoId;
	
	private Integer clienteId;
	
	public Consulta() {}

	public Consulta(Integer idConsulta, String dataDaConsulta, String horaDaConsulta, Integer medicoId,
			Integer clienteId) {
		super();
		this.idConsulta = idConsulta;
		this.dataDaConsulta = dataDaConsulta;
		this.horaDaConsulta = horaDaConsulta;
		this.medicoId = medicoId;
		this.clienteId = clienteId;
	}

	

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public String getDataDaConsulta() {
		return dataDaConsulta;
	}

	public void setDataDaConsulta(String dataDaConsulta) {
		this.dataDaConsulta = dataDaConsulta;
	}

	public String getHoraDaConsulta() {
		return horaDaConsulta;
	}

	public void setHoraDaConsulta(String horaDaConsulta) {
		this.horaDaConsulta = horaDaConsulta;
	}

	public Integer getMedicoId() {
		return medicoId;
	}

	public void setMedicoId(Integer medicoId) {
		this.medicoId = medicoId;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}


	
	
	
}
