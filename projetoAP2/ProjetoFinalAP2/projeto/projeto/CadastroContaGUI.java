import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;


public class CadastroContaGUI {

	private JFrame frameCadastroConta;
	private JTextField textFieldLimite;
	private SelecionaClienteGUI selecionaCliente;
	private static JLabel labelNomeCliente;
	
	//atributos para guardar as informações da GUI
	private Conta contaFinal;
	private static Pessoa clienteFinal = null;
	private double limite = 0;

	public static void atualizaCliente(Pessoa cliente) {
		clienteFinal = cliente;
		labelNomeCliente.setText(cliente.getNome());
		
	}
	
	//Construtor padrão
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
		//mostra a janela
		frameCadastroConta.setVisible(true);
	}

	//Coloca os componentes no frame
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
		rBContaCorrente.setSelected(true);
		
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
		buttonAddCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selecionaCliente = new SelecionaClienteGUI();
				
			}
		});
		
		
		//Label do numero da conta, gerado na classe Conta
		JLabel labelGeraNumero = new JLabel("Gerado automaticamente.");
		labelGeraNumero.setBounds(123, 11, 137, 14);
		panelDados.add(labelGeraNumero);
		
		
		//Label que mostra o nome do cliente
		labelNomeCliente = new JLabel("New label");
		labelNomeCliente.setBounds(63, 48, 46, 14);
		panelDados.add(labelNomeCliente);
		
		
		
		
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
								try {
									clienteFinal = selecionaCliente.getClienteFinal();
									
									if(textFieldLimite.getText().length() == 0 && rBContaCorrente.isSelected()) {
										JOptionPane.showMessageDialog(frameCadastroConta, "O campo limite não pode estar vazio.");
									} else
										
									if(rBContaCorrente.isSelected()) {
										try {
											limite = Double.parseDouble(textFieldLimite.getText());
											contaFinal = new ContaCorrente(clienteFinal, limite);
											JOptionPane.showMessageDialog(frameCadastroConta, "Conta cadastrada com sucesso.");
											JanelaPrincipalGUI.addConta(contaFinal);
											frameCadastroConta.setVisible(false);
											
										}catch (NumberFormatException e1) {
											JOptionPane.showMessageDialog(frameCadastroConta, "Entrada de número inválida no campo Limite");
											e1.printStackTrace();
										}
										
									} else 
									    if(rBContaPoupanca.isSelected()){
									    	contaFinal = new Poupanca(clienteFinal);
									    	JOptionPane.showMessageDialog(frameCadastroConta, "Conta cadastrada com sucesso.");
									    	
									    	JanelaPrincipalGUI.addConta(contaFinal);
									    	frameCadastroConta.setVisible(false);
									    	
									}
								} catch (NullPointerException e1) {
									JOptionPane.showMessageDialog(frameCadastroConta, "Por favor, adicione um cliente para associar à conta.");
								}
									
								
							}
						});
					}
	
}
