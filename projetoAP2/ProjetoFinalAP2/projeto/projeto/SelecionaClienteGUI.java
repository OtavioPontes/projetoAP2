import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SelecionaClienteGUI {

	private JFrame frameSelecionaCliente;
	
	private String selecionado;
	private String[] nomePessoas;
	private Pessoa cliente;

	
	public SelecionaClienteGUI() {
		initialize();
		
		frameSelecionaCliente.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSelecionaCliente = new JFrame();
		frameSelecionaCliente.setTitle("Cliente");
		frameSelecionaCliente.setBounds(100, 100, 400, 315);
		frameSelecionaCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSelecionaCliente.getContentPane().setLayout(null);
		
		//métodos para criar array com nome dos clientes cadastrados
		nomePessoas = new String[JanelaPrincipalGUI.getPessoas().size()];

		for (int i = 0; i < JanelaPrincipalGUI.getPessoas().size(); i++) {
			nomePessoas[i] = JanelaPrincipalGUI.getPessoas().get(i).getNome();
		}
		
		
		
		JList listSelecaoCliente = new JList(nomePessoas);
		listSelecaoCliente.setBounds(20, 36, 337, 193);
		frameSelecionaCliente.getContentPane().add(listSelecaoCliente);
		
		JLabel labelTitulo = new JLabel("Selecione o cliente cadastrado:");
		labelTitulo.setBounds(20, 11, 156, 14);
		frameSelecionaCliente.getContentPane().add(labelTitulo);
		
		JButton buttonOK = new JButton("OK");
		buttonOK.setBounds(142, 240, 89, 23);
		frameSelecionaCliente.getContentPane().add(buttonOK);
		buttonOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listSelecaoCliente.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(frameSelecionaCliente, "Por favor, selecione um cliente.");
				} else {
					cliente = JanelaPrincipalGUI.getPessoas().get(listSelecaoCliente.getSelectedIndex());
					frameSelecionaCliente.setVisible(false);
					CadastroContaGUI.atualizaCliente(cliente);
				}
								
			}
		});
		
	}
	
	public Pessoa getClienteFinal() {
		return cliente;	
	}
}
