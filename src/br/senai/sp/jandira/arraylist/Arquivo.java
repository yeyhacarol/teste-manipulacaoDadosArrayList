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

	// criação de um método para criação(quando não existir o arquivo) e gravação de
	// dados no mesmo

	public boolean escrever(String caminho, String texto) {

		// estrutura utilizada para fazer tratamento na ocorrência de erros
		try {

			/*
			 * precisamos de dois objetos, um para representar o aquivo e outro para
			 * representar a manipulação(escrita) dos dados
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

			// representa o dado de leitura na memória principal do programa
			// o bufferedreader reserva um espaço de memória para a gravação/leitura do
			// arquivo
			BufferedReader lerArq = new BufferedReader(arquivo);

			String linha = "";

			linha = lerArq.readLine();

			// com o while o arquivo será lido linha por linha até que não hajam mais linhas

			while (linha != null) {
				
				//solução para que os textos não sejam sobrescritos e sim se adicionem
				
				//o split é utilizado para fazer a separação entre os textos através do caractere ";"
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

			// retorna o conteúdo carregado com as linhas
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
