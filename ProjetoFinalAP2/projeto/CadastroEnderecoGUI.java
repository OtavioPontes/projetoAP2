import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;

public class CadastroEnderecoGUI {

	private JFrame frameCadastroEndereco;
	private JTextField textFieldLogradouro;
	private JTextField textFieldTipoDeLogradouro;
	private JTextField textFieldBairro;
	private JTextField textFieldNumero;
	private JTextField textFieldCidade;
	private JTextField textFieldCep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroEnderecoGUI window = new CadastroEnderecoGUI();
					window.frameCadastroEndereco.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroEnderecoGUI() {
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
				
		frameCadastroEndereco = new JFrame();
		frameCadastroEndereco.setTitle("Endereço");
		frameCadastroEndereco.setBounds(100, 100, 365, 326);
		frameCadastroEndereco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCadastroEndereco.getContentPane().setLayout(null);
		
		//Panel para o Label do nome principal
		JPanel panelLabelPrincipal = new JPanel();
		panelLabelPrincipal.setBounds(0, 0, 252, 32);
		frameCadastroEndereco.getContentPane().add(panelLabelPrincipal);
		
		//Label do nome principal
		JLabel labelCadastroEndereço = new JLabel("Cadastro de novo endereço:");
		labelCadastroEndereço.setHorizontalTextPosition(SwingConstants.LEFT);
		labelCadastroEndereço.setHorizontalAlignment(SwingConstants.LEFT);
		panelLabelPrincipal.add(labelCadastroEndereço);
		
		
		//Panel para os componentes de entrada de dados
		JPanel panelDados = new JPanel();
		panelDados.setBounds(10, 42, 330, 251);
		frameCadastroEndereco.getContentPane().add(panelDados);
		panelDados.setLayout(null);
		
		
		/*
		 * Todos os componentes para entrada de dados
		 */
		JLabel LabelLogradouro = new JLabel("Logradouro:");
		LabelLogradouro.setBounds(10, 23, 71, 14);
		panelDados.add(LabelLogradouro);
		
		textFieldLogradouro = new JTextField();
		textFieldLogradouro.setBounds(120, 20, 200, 20);
		panelDados.add(textFieldLogradouro);
		textFieldLogradouro.setColumns(10);
		
		textFieldTipoDeLogradouro = new JTextField();
		textFieldTipoDeLogradouro.setColumns(10);
		textFieldTipoDeLogradouro.setBounds(120, 53, 200, 20);
		panelDados.add(textFieldTipoDeLogradouro);
		
		JLabel labelTipoLogradouro = new JLabel("Tipo de Logradouro:");
		labelTipoLogradouro.setBounds(10, 49, 106, 29);
		panelDados.add(labelTipoLogradouro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(120, 85, 200, 20);
		panelDados.add(textFieldBairro);
		
		JLabel labelBairro = new JLabel("Bairro:");
		labelBairro.setBounds(10, 88, 71, 14);
		panelDados.add(labelBairro);
		
		JLabel labelNumero = new JLabel("Número:");
		labelNumero.setBounds(10, 133, 46, 14);
		panelDados.add(labelNumero);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(60, 130, 54, 20);
		panelDados.add(textFieldNumero);
		textFieldNumero.setColumns(4);
		
		JLabel labelCidade = new JLabel("Cidade:");
		labelCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCidade.setBounds(134, 133, 46, 14);
		panelDados.add(labelCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(190, 130, 130, 20);
		panelDados.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		
		//permite a escolha da unidade federativa
		Choice choiceUF = new Choice();
		choiceUF.setBounds(60, 165, 56, 20);
		panelDados.add(choiceUF);
		choiceUF.add("AC");
		choiceUF.add("AL");
		choiceUF.add("AP");
		choiceUF.add("AM");
		choiceUF.add("BA");
		choiceUF.add("CE");
		choiceUF.add("DF");
		choiceUF.add("ES");
		choiceUF.add("GO");
		choiceUF.add("MA");
		choiceUF.add("MT");
		choiceUF.add("MS");
		choiceUF.add("MG");
		choiceUF.add("SP");
		choiceUF.add("PA");
		choiceUF.add("PB");
		choiceUF.add("PR");
		choiceUF.add("PE");
		choiceUF.add("PI");
		choiceUF.add("RJ");
		choiceUF.add("RN");
		choiceUF.add("RS");
		choiceUF.add("RO");
		choiceUF.add("RR");
		choiceUF.add("SC");
		choiceUF.add("SP");
		choiceUF.add("SE");
		choiceUF.add("TO");
		
		
		JLabel LabelUF = new JLabel("UF:");
		LabelUF.setBounds(34, 165, 22, 20);
		panelDados.add(LabelUF);
		
		JLabel labelCep = new JLabel("CEP:");
		labelCep.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCep.setBounds(134, 168, 46, 14);
		panelDados.add(labelCep);
		
		textFieldCep = new JTextField();
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(190, 165, 130, 20);
		panelDados.add(textFieldCep);
		
		
		
		//Botão final para cadastrar endereço
		JButton buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.setBounds(120, 205, 89, 23);
		panelDados.add(buttonCadastrar);
		
		
		
		//panel e checkbox para verificaçaõ da variavel "tipe", da classe endereço
		JPanel panelTipe = new JPanel();
		panelTipe.setBounds(254, 0, 86, 32);
		frameCadastroEndereco.getContentPane().add(panelTipe);
		
		JCheckBox checkBoxTipe = new JCheckBox("Residencial");
		checkBoxTipe.setSelected(true);
		panelTipe.add(checkBoxTipe);
	}
	
	
	
	//Método para converter UF selecionada em String com nome do estado
	public String UfEstado(String uf) {
		String estado = "";
		if(uf == "AC") {
			estado = "Acre";
		} else
		
		if(uf == "Al") {
				estado = "Alagoas";
		} else
		
			if(uf == "AP") {
				estado = "Amapá";
		} else
			
		if(uf == "AM") {
			estado = "Amazonas";
			} else
				if(uf == "BA") {
					estado = "Bahia";
				} else
					if(uf == "CE") {
						estado = "Ceará";
					} else
						if(uf == "DF") {
							estado = "Distrito Federal";
						} else
							if(uf == "ES") {
								estado = "Espírito Santo";
							} else
								if(uf == "GO") {
									estado = "Goías";
								} else
									if(uf == "MA") {
										estado = "Maranhão";
									} else
										if(uf == "MT") {
											estado = "Mato Grosso";
										} else
											if(uf == "MS") {
												estado = "Mato Grosso do Sul";
											} else
												if(uf == "MG") {
													estado = "Minas Gerais";
												} else
													if(uf == "PA") {
														estado = "Pará";
													} else
														if(uf == "PB") {
															estado = "Paraíba";
														} else
															if(uf == "PR") {
																estado = "Paraná";
															} else
																if(uf == "PE") {
																	estado = "Pernambuco";
																} else
																	if(uf == "PI") {
																		estado = "Piauí";
																	} else
																		if(uf == "RJ") {
																			estado = "Rio de Janeiro";
																		} else
																			if(uf == "RN") {
																				estado = "Rio Grande do Norte";
																			} else
																				if(uf == "RS") {
																					estado = "Rio Grande do Sul";
																				} else
																					if(uf == "RO") {
																						estado = "Rondônia";
																					} else
																						if(uf == "RR") {
																							estado = "Roraima";
																						} else
																							if(uf == "SC") {
																								estado = "Santa Catarina";
																							} else
																								if(uf == "SP") {
																									estado = "São Paulo";
																								} else
																									if(uf == "SE") {
																										estado = "Sergipe";
																									} else
																										if(uf == "TO") {
																											estado = "Tocantins";
																										}
		return estado;
		
	}
}
