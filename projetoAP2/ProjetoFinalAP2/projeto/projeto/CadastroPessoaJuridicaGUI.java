import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;

public class CadastroPessoaJuridicaGUI {

	private JFrame frameCadastroPJ;
	private JTextField textFieldNome;
	private JTextField textFieldCnpj;
	
	private PessoaJuridica pessoaFinal;
	private CadastroEnderecoGUI enderecoCadastrado = null;
	private String nome;
	private String cnpj;
	private Endereço end;


	//Construtor padrão
	public CadastroPessoaJuridicaGUI() {
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
		//mostra a Janela
		frameCadastroPJ.setVisible(true);
	}

	//Coloca os componentes no frame
	private void criaLayout() {
		frameCadastroPJ = new JFrame();
		frameCadastroPJ.setResizable(false);
		frameCadastroPJ.setTitle("Pessoa Jurídica");
		frameCadastroPJ.setBounds(100, 100, 335, 233);
		frameCadastroPJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCadastroPJ.getContentPane().setLayout(null);
		
		
		//Panel para o label principal
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBounds(0, 0, 242, 24);
		frameCadastroPJ.getContentPane().add(panelCadastro);
		
		
		//Label principal, abaixo do título da janela
		JLabel labelCadastro = new JLabel("Cadastro de Pessoa Jurídica:");
		panelCadastro.add(labelCadastro);
		
		
		//JPanel para agrupar todos os labels relacionados às entradas do cadastro
		JPanel panelLabelsDados = new JPanel();
		panelLabelsDados.setBounds(0, 24, 67, 126);
		frameCadastroPJ.getContentPane().add(panelLabelsDados);
		panelLabelsDados.setLayout(new GridLayout(3, 1));
		
		/*
		 * Todos os labels relacionados ao cadastro
		 */
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabelsDados.add(labelNome);
		
		JLabel labelCnpj = new JLabel("CNPJ:");
		labelCnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabelsDados.add(labelCnpj);
		
		JLabel labelEndereco = new JLabel("Endereço:");
		labelEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabelsDados.add(labelEndereco);
		
		
		
		
		//JPanel para agrupar os textFields (e botão) relacionado ao cadastro
		JPanel panelTextFieldCadastro = new JPanel();
		panelTextFieldCadastro.setBounds(71, 24, 248, 126);
		frameCadastroPJ.getContentPane().add(panelTextFieldCadastro);
		panelTextFieldCadastro.setLayout(null);
		
		
		
		/*
		 * TExtFields e Button para entrada de dados
		 */
		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 11, 228, 23);
		panelTextFieldCadastro.add(textFieldNome);
		textFieldNome.setColumns(20);
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setColumns(20);
		textFieldCnpj.setBounds(10, 48, 228, 23);
		panelTextFieldCadastro.add(textFieldCnpj);
		
		JButton buttonCadastroEndereco = new JButton("Adic. Endereço...");
		buttonCadastroEndereco.setBounds(110, 90, 128, 23);
		panelTextFieldCadastro.add(buttonCadastroEndereco);
		//Listener para cadastrar Endereço
		buttonCadastroEndereco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				enderecoCadastrado = new CadastroEnderecoGUI();
			}
		});
		
		
		//JPanel para agrupar labels do horário atual do sistema
		JPanel panelHorario = new JPanel();
		panelHorario.setBounds(252, 0, 67, 24);
		frameCadastroPJ.getContentPane().add(panelHorario);
		
		
		
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
		frameCadastroPJ.getContentPane().add(buttonCadastrar);
		
		//Listener para ação de cadastrar pessoa juridica
		buttonCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textFieldNome.getText().length() == 0 || textFieldCnpj.getText().length() == 0) {
					JOptionPane.showMessageDialog(frameCadastroPJ, "Campos em branco não são permitidos.");
				} else
					if(enderecoCadastrado == null) {
						JOptionPane.showMessageDialog(frameCadastroPJ, "Por favor, adicione um endereço.");
					} else
						if(textFieldCnpj.getText().length() != 14) {
							JOptionPane.showMessageDialog(frameCadastroPJ, "O CNPJ deve ter 14 dígitos. Utilize somente numeros.");
						} else{
							nome = textFieldNome.getText();
							cnpj = textFieldCnpj.getText();
							end = enderecoCadastrado.getEnderecoFinal();
							
							//tentativa de criação do objeto pessoa Juridica
							try {
								pessoaFinal = new PessoaJuridica(nome, end, cnpj);
								JOptionPane.showMessageDialog(frameCadastroPJ, "Cadastro realizado com sucesso");
								JanelaPrincipalGUI.addPessoa(pessoaFinal);
								
								textFieldNome.setText("");
								textFieldCnpj.setText("");
								frameCadastroPJ.setVisible(false);
								
							} catch(Exception e1){
								JOptionPane.showMessageDialog(frameCadastroPJ, "O CNPJ digitado não é valido. Por favor, entre com um CNPJ válido, utilizando somente números.");				
							}
						}
				
			}
		});
		
	
	}

}
