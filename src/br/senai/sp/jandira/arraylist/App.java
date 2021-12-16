package br.senai.sp.jandira.arraylist;

public class App {

	public static void main(String[] args) {

		/*ContatoRepository objDadosContato = new ContatoRepository();
		Arquivo objArquivo = new Arquivo();

		String caminho = "C:\\Users\\21276093\\Desktop\\contato\\contatos.txt";

		Contato contato1 = new Contato("Luiza", "luiza@live.com", "1234-5678", "Jandira - SP");
		Contato contato2 = new Contato("Romário", "romario123@gmail.com", "8765-4321", "Osasco - SP");
		Contato contato3 = new Contato("Túlio", "tulio@hotmail.com", "1256-0965", "Carapicuíba - SP");
		Contato contato4 = new Contato("Bianca", "bia@outlook.com", "3478-6521", "Itapevi - SP");

		objDadosContato.cadastrarContato(contato1);
		objDadosContato.cadastrarContato(contato2);
		objDadosContato.cadastrarContato(contato3);
		objDadosContato.cadastrarContato(contato4);

		// para percorrer o arraylist e gravar os dados no arquivo txt
		// primeiro exemplo!
		/*
		 * ArrayList<Contato> listagem = objDadosContato.listarContatos(); for (Contato
		 * contato : listagem) {
		 * System.out.printf("Nome:%s,\nE-mail:%s,\nTelefone:%s,\nCidade:%s\n\n",
		 * contato.getNome(), contato.getEmail(), contato.getTelefone(),
		 * contato.getCidade()); }
		 

		// segundo exemplo!
		String texto = "";

		for (Contato contato : objDadosContato.listarContatos()) {
			/*
			 * System.out.printf("Nome:%s,\nE-mail:%s,\nTelefone:%s,\nCidade:%s\n\n",
			 * contato.getNome(), contato.getEmail(), contato.getTelefone(),
			 * contato.getCidade());
			 

			texto += contato.getNome() + ";" + contato.getEmail() + ";" + contato.getTelefone() + ";"
					+ contato.getCidade() + "\n";
		}

		System.out.println(texto);

		objArquivo.escrever(caminho, texto);

		System.out.println("CONTATOS: " + objDadosContato.contarContatos());*/
		
		FrameCadastro tela = new FrameCadastro();
		tela.setVisible(true);

	}

}
