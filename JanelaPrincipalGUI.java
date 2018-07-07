package projeto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class JanelaPrincipalGUI {

	private JFrame frame;
	private static JFrame invFrame;
	private CadastroContaGUI cadastroConta;
	private CadastroFuncionarioGUI cadastroFuncionario;
	private CadastroPessoaFisicaGUI cadastroFisica;
	private CadastroPessoaJuridicaGUI cadastroJuridica;
	private CaixaEletronicoGUI caixaEletronico;
	private SelecionaContaGUI selecionarConta;
	private Calendar c1 = Calendar.getInstance();
	private JLabel labelHorario;
	private ImageIcon icone = new ImageIcon(getClass().getResource("bancoLS.png"));
	private  JTextField  caixaInvisivel;
	private JOptionPane janela;
	private static List<Conta> contas = new ArrayList<Conta>();
	private static List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private String admin;
	private int hora7=7,hora10=10,hora14=14,hora21=21;
	private JTextField textField;
	
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

	//
	private void criaLayout() {
		

		//Timer responsável por atualizar o horário constantemente
				Timer atualizaHorario = new Timer(10000, new ActionListener() {
							
					@Override
						public void actionPerformed(ActionEvent e) {
							Calendar horario = Calendar.getInstance();
							String horas = "";
							horas = (Integer.toString(horario.get(Calendar.HOUR_OF_DAY)) + "h" + Integer.toString(horario.get(Calendar.MINUTE)) + "min");
							labelHorario.setText(horas);
							
								
							}
						});
						atualizaHorario.setInitialDelay(100);
						atualizaHorario.start();
						
						
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 252);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		JLabel labelNomeBanco = new JLabel("Banco Los Santos");
		labelNomeBanco.setBounds(0, 7, 434, 22);
		labelNomeBanco.setFont(new Font("pricedown bl", Font.BOLD, 26));
		labelNomeBanco.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(labelNomeBanco);
		frame.setIconImage(icone.getImage());
		JPanel panel = new JPanel();
		panel.setBounds(0, 33, 434, 29);
		frame.getContentPane().add(panel);
		frame.setTitle("Banco Los Santos");
		JLabel labelOpcoes = new JLabel("Olá! Selecione uma das opções abaixo:");
		labelOpcoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelOpcoes.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelOpcoes);
		
		JLabel labelCadastro = new JLabel("Novo cadastro:");
		labelCadastro.setBounds(22, 73, 100, 14);
		frame.getContentPane().add(labelCadastro);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 93, 384, 33);
		frame.getContentPane().add(panel_1);
		panel_1.setBackground(Color.LIGHT_GRAY);
		
		
		//cria modo admin para liberar horario
		
		
		caixaInvisivel = new JTextField(20);
		caixaInvisivel.grabFocus();
		caixaInvisivel.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					admin = caixaInvisivel.getText();
					if(admin.equals("admin")){
						hora7 =0;
						hora21 = 24;
						hora10=0;
						hora14=24;
						JOptionPane.showMessageDialog(null, "modo admin ativado");
					}
				}
				
			}
		});
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 10, 1, 1);
		panel_3.add(caixaInvisivel);
		
		frame.getContentPane().add(panel_3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * Botões para cadastro
		 */
		JButton buttonCadastroConta = new JButton("Conta");
		buttonCadastroConta.setPreferredSize(new Dimension(65, 23));
		panel_1.add(buttonCadastroConta);
		buttonCadastroConta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(c1.get(Calendar.HOUR_OF_DAY) < hora10 || c1.get(Calendar.HOUR_OF_DAY)> hora14){
					JOptionPane.showMessageDialog(null, "O cadastro de contas só é possível das 10 às 15h");
				}
				else
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
		labelTransacao.setBounds(22, 133, 100, 14);
		frame.getContentPane().add(labelTransacao);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 155, 329, 36);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton buttonCaixaEletronico = new JButton("Caixa Eletrônico");
		buttonCaixaEletronico.setBounds(22, 5, 150, 23);
		buttonCaixaEletronico.setHorizontalTextPosition(SwingConstants.LEFT);
		panel_2.add(buttonCaixaEletronico);
		buttonCaixaEletronico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
					
					if(c1.get(Calendar.HOUR_OF_DAY)< hora7 || c1.get(Calendar.HOUR_OF_DAY)>hora21){
						JOptionPane.showMessageDialog(null, "Só é possivel realizar transações das 7h às 22h");
					}
					else
						if(contas.isEmpty()){
							JOptionPane.showMessageDialog(null, "Não é possivel realizar operações sem contas cadastradas");
						}
						else{
							selecionarConta = new SelecionaContaGUI();
						}
						
			}
		});
		
		labelHorario = new JLabel("Horário");
		labelHorario.setBounds(356, 188, 60, 14);
		frame.getContentPane().add(labelHorario);
		
		
		
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
