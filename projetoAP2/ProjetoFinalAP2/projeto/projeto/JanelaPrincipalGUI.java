import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

public class JanelaPrincipalGUI {

	private JFrame frame;
	
	private CadastroContaGUI cadastroConta;
	private CadastroFuncionarioGUI cadastroFuncionario;
	private CadastroPessoaFisicaGUI cadastroFisica;
	private CadastroPessoaJuridicaGUI cadastroJuridica;
	
	private static List<Conta> contas = new ArrayList<Conta>();
	private static List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipalGUI window = new JanelaPrincipalGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Coloca os componentes no frame
	public JanelaPrincipalGUI() {
		//Código para deixar a aparencia semelhante ao SO usado
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		criaLayout();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void criaLayout() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 252);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelNomeBanco = new JLabel("BANCO FODA-SE");
		labelNomeBanco.setBounds(0, 0, 434, 22);
		labelNomeBanco.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelNomeBanco.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(labelNomeBanco);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 33, 434, 29);
		frame.getContentPane().add(panel);
		
		JLabel labelOpcoes = new JLabel("Olá! Selecione uma das opções abaixo:");
		labelOpcoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelOpcoes.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelOpcoes);
		
		JLabel labelCadastro = new JLabel("Novo cadastro:");
		labelCadastro.setBounds(22, 73, 79, 14);
		frame.getContentPane().add(labelCadastro);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 93, 414, 29);
		frame.getContentPane().add(panel_1);
		
		
		/*
		 * Botões para cadastro
		 */
		JButton buttonCadastroConta = new JButton("Conta");
		buttonCadastroConta.setPreferredSize(new Dimension(65, 23));
		panel_1.add(buttonCadastroConta);
		buttonCadastroConta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//verifica se há clientes cadastrados
				if(pessoas.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Não é possível cadastrar uma conta sem haver clientes cadastrados.");
					
				} else {
					cadastroConta = new CadastroContaGUI();
				}
				
				
			}
		});
		
		JButton ButtonCadastroPessoaFisica = new JButton("Pessoa Física");
		panel_1.add(ButtonCadastroPessoaFisica);
		ButtonCadastroPessoaFisica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastroFisica = new CadastroPessoaFisicaGUI();
				
				
			}
		});
		
		JButton buttoncadastrioPessoaJuridica = new JButton("Pessoa Jurídica");
		panel_1.add(buttoncadastrioPessoaJuridica);
		buttoncadastrioPessoaJuridica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastroJuridica = new CadastroPessoaJuridicaGUI();
			}
		});
		
		JButton buttonCadastroFuncionario = new JButton("Funcionário");
		panel_1.add(buttonCadastroFuncionario);
		buttonCadastroFuncionario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastroFuncionario = new CadastroFuncionarioGUI();
				
			}
		});
		
		JLabel labelTransacao = new JLabel("Nova transação:");
		labelTransacao.setBounds(22, 133, 86, 14);
		frame.getContentPane().add(labelTransacao);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 155, 170, 36);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton buttonCaixaEletronico = new JButton("Caixa Eletrônico");
		buttonCaixaEletronico.setBounds(22, 5, 109, 23);
		buttonCaixaEletronico.setHorizontalTextPosition(SwingConstants.LEFT);
		panel_2.add(buttonCaixaEletronico);
	}
	
	public static void addPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	
	public static void addConta(Conta conta) {
		contas.add(conta);
	}
	
	public static void addFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}

	
	
	//Métodos get
	public static List<Conta> getContas() {
		return contas;
	}

	public static List<Pessoa> getPessoas() {
		return pessoas;
	}

	public static List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	
}
