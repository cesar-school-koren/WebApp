package com.school;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Parameter;;



@Entity
public class Postagem implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Conta conta;
	
	@Column(length = 50, nullable = false)
	private String titulo;
	
	@Column(length = 800, nullable = false)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "criado_em", nullable = false)
	private Date criadoEm;
	
	@Column(name = "tags", columnDefinition="text[]")
	@Type(type = "com.karakays.hibernate.array.EnumArrayType",
    parameters = { @Parameter(name="enumClass", value="com.school.Postagem$Tag") })
	private List<Tag> tags;
	
	public enum Tag {
		SAUDE, SETE_A_DEZ, TRES_A_SEIS, ATE_DOIS, EDUCACAO;
	}

	public Postagem() {
	}


	public Postagem(int id, Conta conta, String titulo, String texto, Date criadoEm, List<Tag> tags) {
		this.id = id;
		this.conta = conta;
		this.titulo = titulo;
		this.texto = texto;
		this.criadoEm = criadoEm;
		this.tags = tags;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Conta getConta() {
		return this.conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getCriadoEm() {
		return this.criadoEm;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public List<Tag> getTags() {
		return this.tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}


}
