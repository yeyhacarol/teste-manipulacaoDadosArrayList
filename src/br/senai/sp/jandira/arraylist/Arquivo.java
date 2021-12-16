package br.senai.sp.jandira.arraylist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {

	private String texto;
	private String caminho;

	public ContatoRepository objContatoRepo = new ContatoRepository();

	// cria��o de um m�todo para cria��o(quando n�o existir o arquivo) e grava��o de
	// dados no mesmo

	public boolean escrever(String caminho, String texto) {

		// estrutura utilizada para fazer tratamento na ocorr�ncia de erros
		try {

			/*
			 * precisamos de dois objetos, um para representar o aquivo e outro para
			 * representar a manipula��o(escrita) dos dados
			 */

			FileWriter arquivo = new FileWriter(caminho);

			PrintWriter escreverArq = new PrintWriter(arquivo);

			// append permite a escritura, no final, no nosso aquivo
			escreverArq.append(texto);

			escreverArq.close();

			return true;

		} catch (IOException e) {

			System.out.println("ERRO: " + e.getMessage());

			return false;

		}

	}

	public ContatoRepository ler(String caminho) {

		try {

			// representa o arquivo em modo de leitura
			FileReader arquivo = new FileReader(caminho);

			// representa o dado de leitura na mem�ria principal do programa
			// o bufferedreader reserva um espa�o de mem�ria para a grava��o/leitura do
			// arquivo
			BufferedReader lerArq = new BufferedReader(arquivo);

			String linha = "";

			linha = lerArq.readLine();

			// com o while o arquivo ser� lido linha por linha at� que n�o hajam mais linhas

			while (linha != null) {
				
				//solu��o para que os textos n�o sejam sobrescritos e sim se adicionem
				
				//o split � utilizado para fazer a separa��o entre os textos atrav�s do caractere ";"
				String[] dadosLinha = linha.split(";");
				
				Contato objContato = new Contato();
				objContato.setNome(dadosLinha[0]);
				objContato.setEmail(dadosLinha[1]);
				objContato.setTelefone(dadosLinha[2]);
				objContato.setCidade(dadosLinha[3]);
				
				objContatoRepo.cadastrarContato(objContato);

				linha = lerArq.readLine();
			}

			arquivo.close();

			// retorna o conte�do carregado com as linhas
			return objContatoRepo;

		} catch (IOException e) {

			System.out.println("ERRO: " + e.getMessage());

			return objContatoRepo;
		}

	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
