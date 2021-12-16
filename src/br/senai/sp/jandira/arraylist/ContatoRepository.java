package br.senai.sp.jandira.arraylist;

import java.util.ArrayList;

public class ContatoRepository {

	ArrayList<Contato> contatos = new ArrayList<Contato>();
	Contato contato = new Contato();
	
	public void cadastrarContato(Contato c) {
		contatos.add(c);
	}
	
	public ArrayList<Contato> listarContatos() {
		return contatos;
	}
	
	
	public int contarContatos() {
		return contatos.size();
	}
	

}
