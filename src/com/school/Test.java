package com.school;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.school.Postagem.Tag;

public class Test {

	public static void main(String[] args) {
		ContaHome contaHome = new ContaHome();
		Date agora = new Date();
		Conta conta = new Conta();
		Postagem post = new Postagem();
		PostagemHome postHome = new PostagemHome();
		conta.setUsername("Reiso");
		conta.setPassword("040594");
		conta.setEmail("reiso@cesar.school");
		conta.setCriadoEm(agora);
		contaHome.persist(conta);
		
		List<Tag> tags = new ArrayList<Tag>();
		tags.add(Tag.SAUDE);
		tags.add(Tag.SETE_A_DEZ);
		System.out.println("Iniciando Postagem");
		post.setTitulo("Teste!");
		post.setTexto("Mostrando pros caras");
		post.setTags(tags);
		post.setCriadoEm(agora);
		post.setConta(conta);
		postHome.persist(post);
		contaHome.terminate();
		postHome.terminate();
	}

}
