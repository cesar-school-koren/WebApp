package com.school;


import java.util.Date;
import java.util.HashSet;
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


@Entity
public class Comentario implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Comentario comentario;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Conta conta;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Postagem postagem;
	
	@Column(length = 800, nullable = false)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "criado_em", nullable = false)
	private Date criadoEm;

	public Comentario() {
	}

	public Comentario(int id, Comentario comentario, Conta conta, Postagem postagem, String texto, Date criadoEm) {
		this.id = id;
		this.comentario = comentario;
		this.conta = conta;
		this.postagem = postagem;
		this.texto = texto;
		this.criadoEm = criadoEm;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Comentario getComentario() {
		return this.comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public Conta getConta() {
		return this.conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Postagem getPostagem() {
		return this.postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
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
}
