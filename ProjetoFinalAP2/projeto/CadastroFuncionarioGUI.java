import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroFuncionarioGUI {

	private JFrame frameCadastroFuncionario;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldCargo;

	//Variaveis para o armazenamento dos dados
	private Funcionario func;
	private String nome;
	private String cpf;
	private String cargo;
	private Endereço end;
	private CadastroEnderecoGUI cadastroEnd;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionarioGUI window = new CadastroFuncionarioGUI();
					window.frameCadastroFuncionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroFuncionarioGUI() {
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
		frameCadastroFuncionario = new JFrame();
		frameCadastroFuncionario.setResizable(false);
		frameCadastroFuncionario.setTitle("Funcionário");
		frameCadastroFuncionario.setBounds(100, 100, 330, 311);
		frameCadastroFuncionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCadastroFuncionario.getContentPane().setLayout(null);
		
		
		//Panel para o label do título
		JPanel panelLableFuncionario = new JPanel();
		panelLableFuncionario.setBounds(0, 0, 314, 27);
		frameCadastroFuncionario.getContentPane().add(panelLableFuncionario);
		
		//Label para o título do cabeçalho
		JLabel labelFuncionario = new JLabel("Cadastro de Funconário:");
		panelLableFuncionario.add(labelFuncionario);
		
		
		//Panel para Label da entrada de dados
		JPanel panelLabelDados = new JPanel();
		panelLabelDados.setBounds(10, 38, 61, 176);
		frameCadastroFuncionario.getContentPane().add(panelLabelDados);
		panelLabelDados.setLayout(new GridLayout(4, 1, 0, 0));
		
		
		/*
		 * Todos os lables relacionados à entrada de dados
		 */
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabelDados.add(labelNome);
		
		JLabel lableCpf = new JLabel("CPF:");
		lableCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabelDados.add(lableCpf);
		
		JLabel lableCargo = new JLabel("Cargo:");
		lableCargo.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabelDados.add(lableCargo);
		
		JLabel labelEndereco = new JLabel("Endereço:");
		labelEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabelDados.add(labelEndereco);
		
		
		//Panel agrupando meios de entrada de dados
		JPanel panelEntradaDados = new JPanel();
		panelEntradaDados.setBounds(81, 38, 223, 176);
		frameCadastroFuncionario.getContentPane().add(panelEntradaDados);
		panelEntradaDados.setLayout(null);
		
		
		/*
		 * Todos os componentes relacionados à entrada de dados
		 */
		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 11, 203, 20);
		panelEntradaDados.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(10, 54, 203, 20);
		panelEntradaDados.add(textFieldCpf);
		
		textFieldCargo = new JTextField();
		textFieldCargo.setColumns(10);
		textFieldCargo.setBounds(10, 100, 203, 20);
		panelEntradaDados.add(textFieldCargo);
		
		JButton buttonAddEndereco = new JButton("Adic. Endereço...");
		buttonAddEndereco.setBounds(96, 142, 117, 23);
		panelEntradaDados.add(buttonAddEndereco);
		buttonAddEndereco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastroEnd = new CadastroEnderecoGUI();
			}
		});
		
		
		//Button final para realizar o cadastro
		JButton buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.setBounds(110, 238, 89, 23);
		frameCadastroFuncionario.getContentPane().add(buttonCadastrar);
		buttonCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldNome.getText().length() == 0 || textFieldCpf.getText().length() == 0 || textFieldCargo.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Campos em branco não são permitidos.");
				} else {
					nome = textFieldNome.getText();
					textFieldNome.setText("");
					cpf = textFieldCpf.getText();
					textFieldCpf.setText("");
					cargo = textFieldCargo.getText();
					textFieldCargo.setText("");
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
					
					try {
						end = cadastroEnd.getEnderecoFinal();
					}catch (NullPointerException e1) {
						e1.printStackTrace();
					}
					frameCadastroFuncionario.setVisible(false);
					
					func = new Funcionario(nome, end, cpf, cargo);
		
				}
			}
			
		});
		
	}
}