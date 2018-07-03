import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;

public class CadastroPessoaFisicaGUI {

	private JFrame frameCadastroPF;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	
	
	//Variaveis relacionadas à pessoa física, para guardar dados do cadastro
	private String nome;
	private String cpf;
	private Endereço end;
	protected PessoaFisica pessoaFisica;
	private CadastroEnderecoGUI enderecoCadastrado;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPessoaFisicaGUI window = new CadastroPessoaFisicaGUI();
					window.frameCadastroPF.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public CadastroPessoaFisicaGUI() {
		
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
		frameCadastroPF = new JFrame();
		frameCadastroPF.setTitle("Pessoa Física");
		frameCadastroPF.setBounds(100, 100, 335, 233);
		frameCadastroPF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCadastroPF.getContentPane().setLayout(null);
		
		
		//Panel para o label principal
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBounds(0, 0, 242, 24);
		frameCadastroPF.getContentPane().add(panelCadastro);
		
		
		//Label principal, abaixo do título da janela
		JLabel labelCadastro = new JLabel("Cadastro de Pessoa Física:");
		panelCadastro.add(labelCadastro);
		
		
		//JPanel para agrupar todos os labels relacionados às entradas do cadastro
		JPanel panelLabelsDados = new JPanel();
		panelLabelsDados.setBounds(0, 24, 67, 126);
		frameCadastroPF.getContentPane().add(panelLabelsDados);
		panelLabelsDados.setLayout(new GridLayout(3, 1));
		
		/*
		 * Todos os labels relacionados ao cadastro
		 */
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabelsDados.add(labelNome);
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabelsDados.add(labelCPF);
		
		JLabel labelEndereco = new JLabel("Endereço:");
		labelEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabelsDados.add(labelEndereco);
		
		
		
		
		//JPanel para agrupar os textFields (e botão) relacionado ao cadastro
		JPanel panelTextFieldCadastro = new JPanel();
		panelTextFieldCadastro.setBounds(71, 24, 248, 126);
		frameCadastroPF.getContentPane().add(panelTextFieldCadastro);
		panelTextFieldCadastro.setLayout(null);
		
		
		
		/*
		 * TExtFields e Button para entrada de dados
		 */
		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 11, 228, 23);
		panelTextFieldCadastro.add(textFieldNome);
		textFieldNome.setColumns(20);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(20);
		textFieldCpf.setBounds(10, 48, 228, 23);
		panelTextFieldCadastro.add(textFieldCpf);
		
		JButton buttonCadastroEndereco = new JButton("Adic. Endereço...");
		buttonCadastroEndereco.setBounds(110, 90, 128, 23);
		panelTextFieldCadastro.add(buttonCadastroEndereco);
		
		//Evento de clique do botão de novo endereço
		buttonCadastroEndereco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				enderecoCadastrado = new CadastroEnderecoGUI();
			}
		});
		
		
		
		//JPanel para agrupar labels do horário atual do sistema
		JPanel panelHorario = new JPanel();
		panelHorario.setBounds(252, 0, 67, 24);
		frameCadastroPF.getContentPane().add(panelHorario);
		
		
		
		/*
		 * Todos os labels relacionados ao horário
		 */
		JLabel labelHorario = new JLabel("h");
		panelHorario.add(labelHorario);
	
		
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
		
		
		//Button final para cadastrar pessoa
		JButton buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.setBounds(117, 161, 100, 23);
		frameCadastroPF.getContentPane().add(buttonCadastrar);
		
		buttonCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textFieldNome.getText().length() == 0 || textFieldCpf.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Campos em branco não são permitidos.");
				} else {
					nome = textFieldNome.getText();
					textFieldNome.setText("");
					cpf = textFieldCpf.getText();
					textFieldCpf.setText("");
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
					frameCadastroPF.setVisible(false);
					end = enderecoCadastrado.getEnderecoFinal();
					
					//criação do objeto do tipo PessoaFisica
					pessoaFisica = new PessoaFisica(nome, end, cpf);
				}
			}
		});
		
	}
	
	
	public void setEnd(Endereço endereco) {
		try {
			end = endereco;
		}catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
