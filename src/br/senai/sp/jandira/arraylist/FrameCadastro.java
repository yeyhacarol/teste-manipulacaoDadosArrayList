package br.senai.sp.jandira.arraylist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrameCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtCidade;

	Contato objContato = null;
	ContatoRepository objDadosContato = null;
	Arquivo objArquivo = null;
	String texto = "";

	public FrameCadastro() {

		objContato = new Contato();
		objDadosContato = new ContatoRepository();
		objArquivo = new Arquivo();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("CADRASTRO DE CONTATOS:");
		lblTitulo.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblTitulo.setBounds(20, 11, 246, 27);
		contentPane.add(lblTitulo);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		lblNome.setBounds(20, 50, 82, 27);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		txtNome.setColumns(10);
		txtNome.setBounds(95, 50, 280, 27);
		contentPane.add(txtNome);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		lblEmail.setBounds(20, 101, 82, 27);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(95, 100, 280, 27);
		contentPane.add(txtEmail);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		lblTelefone.setBounds(10, 153, 82, 27);
		contentPane.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(95, 150, 280, 27);
		contentPane.add(txtTelefone);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidade.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		lblCidade.setBounds(20, 200, 82, 27);
		contentPane.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		txtCidade.setColumns(10);
		txtCidade.setBounds(95, 200, 280, 27);
		contentPane.add(txtCidade);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// captura dos dados
				objContato.setNome(txtNome.getText());
				objContato.setEmail(txtEmail.getText());
				objContato.setTelefone(txtTelefone.getText());
				objContato.setCidade(txtCidade.getText());

				// formatação da saída no arquivo txt
				/*
				 * String texto = objContato.getNome() + ";" + objContato.getEmail() + ";" +
				 * objContato.getTelefone() + ";" + objContato.getCidade() + "\n";
				 */

				// gravação dos dados no arquivo
				String caminho = "C:\\Users\\21276093\\Desktop\\contato\\contatos.txt";

				// teste leitura de arquivo txt
				objDadosContato = objArquivo.ler(caminho);
				ArrayList<Contato> contatos = objDadosContato.listarContatos();

				// gravação dos dados
				objDadosContato.cadastrarContato(objContato);

				contatos.forEach(contato -> {
					/*
					 * System.out.printf("Nome: %s\nE-mail: %s\nTelefone: %s\nCidade: %s\n\n",
					 * contato.getNome(), contato.getEmail(), contato.getTelefone(),
					 * contato.getCidade());
					 */

					texto += contato.getNome() + ";" + contato.getEmail() + ";" + contato.getTelefone() + ";"
							+ contato.getCidade() + "\n";
					
				});

				// System.out.println(texto);

				objArquivo.escrever(caminho, texto);

				txtNome.setText("");
				txtEmail.setText("");
				txtTelefone.setText("");
				txtCidade.setText("");
				

			}
		});

		btnCadastrar.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		btnCadastrar.setBounds(151, 257, 115, 35);
		contentPane.add(btnCadastrar);
	}
}
