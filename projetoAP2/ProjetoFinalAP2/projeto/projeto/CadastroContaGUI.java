package projeto;
import java.awt.EventQueue;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;


public class CadastroContaGUI {

	private JFrame frameCadastroConta;
	private JTextField textFieldLimite;
	
	//atributos para guardar as informações da GUI
	private Conta contaFinal;
	private Pessoa clienteFinal;
	private double limite = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroContaGUI window = new CadastroContaGUI();
					window.frameCadastroConta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroContaGUI() {
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
		frameCadastroConta = new JFrame();
		frameCadastroConta.setResizable(false);
		frameCadastroConta.setTitle("Conta");
		frameCadastroConta.setBounds(100, 100, 355, 275);
		frameCadastroConta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCadastroConta.getContentPane().setLayout(null);
		
		JPanel panelLabelPrincipal = new JPanel();
		panelLabelPrincipal.setBounds(10, 0, 250, 21);
		frameCadastroConta.getContentPane().add(panelLabelPrincipal);
		
		JLabel labelCadastroConta = new JLabel("Cadastro de Contas:");
		panelLabelPrincipal.add(labelCadastroConta);
		
		JPanel panelHorario = new JPanel();
		panelHorario.setBounds(267, 0, 62, 21);
		frameCadastroConta.getContentPane().add(panelHorario);
		
		
		
		JPanel panelTipoDeConta = new JPanel();
		panelTipoDeConta.setBounds(10, 33, 312, 33);
		frameCadastroConta.getContentPane().add(panelTipoDeConta);
		
		JLabel labelTipoDeConta = new JLabel("Tipo de Conta:");
		panelTipoDeConta.add(labelTipoDeConta);
	
		/*
		 * RadioButtons e ButtonGroup para seleção de tipo de conta
		 */
		JRadioButton rBContaCorrente = new JRadioButton("Conta Corrente");
		panelTipoDeConta.add(rBContaCorrente);
		
		JRadioButton rBContaPoupanca = new JRadioButton("Conta Poupança");
		panelTipoDeConta.add(rBContaPoupanca);
		
		ButtonGroup rbGroup = new ButtonGroup();
		rbGroup.add(rBContaCorrente);
		rbGroup.add(rBContaPoupanca);
		
		
		
		//Panel para agrupar entrada de dados
		JPanel panelDados = new JPanel();
		panelDados.setBounds(10, 77, 270, 70);
		frameCadastroConta.getContentPane().add(panelDados);
		panelDados.setLayout(null);
		
		
		//Label indicando posição do numero da conta na GUI
		JLabel labelNumero = new JLabel("Numero da Conta:");
		labelNumero.setBounds(10, 11, 88, 14);
		panelDados.add(labelNumero);
		
		
		//Label indicando posição do cliente na GUI
		JLabel labelCliente = new JLabel("Cliente:");
		labelCliente.setBounds(10, 48, 46, 14);
		panelDados.add(labelCliente);
		
		
		//Botão para adição de um cliente
		JButton buttonAddCliente = new JButton("Adic. Cliente...");
		buttonAddCliente.setBounds(155, 44, 105, 23);
		panelDados.add(buttonAddCliente);
		
		
		//Label do numero da conta, gerado na classe Conta
		JLabel labelGeraNumero = new JLabel("Nº");
		labelGeraNumero.setBounds(123, 11, 46, 14);
		panelDados.add(labelGeraNumero);
		
		labelGeraNumero.setText(Integer.toString(Conta.geraNumero));
		
		JPanel panelLimite = new JPanel();
		panelLimite.setBounds(10, 156, 270, 26);
		frameCadastroConta.getContentPane().add(panelLimite);
		panelLimite.setLayout(null);
		
		JLabel labelLimite = new JLabel("Limite: ");
		labelLimite.setBounds(10, 8, 34, 14);
		panelLimite.add(labelLimite);
		
		textFieldLimite = new JTextField();
		textFieldLimite.setBounds(54, 5, 110, 20);
		panelLimite.add(textFieldLimite);
		textFieldLimite.setColumns(10);
		
		//Métodos para liberar o limite dependendo do radioButton selecionado
		rBContaCorrente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rBContaCorrente.isSelected() == false) {
					labelLimite.setEnabled(false);
					textFieldLimite.setEnabled(false);
				} else
					if(rBContaCorrente.isSelected()) {
						labelLimite.setEnabled(true);
						textFieldLimite.setEnabled(true);
					}
				
			}
		});
		rBContaPoupanca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rBContaCorrente.isSelected() == false) {
					labelLimite.setEnabled(false);
					textFieldLimite.setEnabled(false);
				} else
					if(rBContaCorrente.isSelected()) {
						labelLimite.setEnabled(true);
						textFieldLimite.setEnabled(true);
					}
				
			}
		});
		
		//Label do horário
		JLabel labelHorario = new JLabel("HHhMMmin");
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
						
						
						//Botão final, responsável por realizar o cadastro
						JButton buttonCadastrar = new JButton("Cadastrar");
						buttonCadastrar.setBounds(118, 193, 89, 23);
						frameCadastroConta.getContentPane().add(buttonCadastrar);
						buttonCadastrar.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								if(rBContaCorrente.isSelected()) {
									try {
										limite = Double.parseDouble(textFieldLimite.getText());
									}catch (NumberFormatException e1) {
										JOptionPane.showInputDialog(null, "Entrada de número inválida no campo Limite");
										e1.printStackTrace();
									}
									contaFinal = new ContaCorrente(clienteFinal, limite);
								}
							}
						});
		
	}
}
