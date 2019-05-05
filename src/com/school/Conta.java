package com.school;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name = "Conta")
@Table(name = "Conta")
public class Conta implements java.io.Serializable {
	
	@Id
	@Column(length = 50, nullable = false)
	private String username;
	
	@Column(length = 50, nullable = false)
	private String password;
	
	@Column(length = 355, nullable = false, unique = true)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "criado_em", nullable = false)
	private Date criadoEm;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ultimo_login", nullable = true)
	private Date ultimoLogin;
	

	public Conta() {
	}

	public Conta(String username, String password, String email, Date criadoEm) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.criadoEm = criadoEm;
	}

	public Conta(String username, String password, String email, Date criadoEm, Date ultimoLogin) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.criadoEm = criadoEm;
		this.ultimoLogin = ultimoLogin;

	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCriadoEm() {
		return this.criadoEm;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public Date getUltimoLogin() {
		return this.ultimoLogin;
	}

	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}
}
