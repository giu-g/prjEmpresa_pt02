package com.giuliag.PrjEmpresa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name= "tb_departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long depCodigo;
	
	@NotNull
	@NotBlank
	private String depNome;

	public Long getDepCodigo() {
		return depCodigo;
	}

	public void setDepCodigo(Long depCodigo) {
		this.depCodigo = depCodigo;
	}

	public String getDepNome() {
		return depNome;
	}

	public void setDepNome(String depNome) {
		this.depNome = depNome;
	}
}
