

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SaqueGUI {
	
	private  JFrame janela;
	private  JPanel painel,painelCabeçalho;
	private  JTextField caixaTexto;
	private  JLabel textoSaque, textoBanco, tagSaque;
	private  final JButton botaoSacar = new JButton("Sacar");
	
	
	public SaqueGUI() {
		
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
		
		BorderLayout g1 = new BorderLayout();
		g1.setVgap(20);
		g1.setHgap(50);
		
		janela = new JFrame("Saque");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.getContentPane().setLayout(g1);
		janela.setBounds(100, 100, 550, 252);
		janela.setLocationRelativeTo(null);
		
		painel = new JPanel();
		painelCabeçalho = new JPanel();
		painelCabeçalho.setLayout(new GridLayout(2,1));
		
		textoBanco = new JLabel("Banco Los Santos");
		textoBanco.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textoBanco.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT);
		
		tagSaque = new JLabel("Insira o valor a ser sacado: ");
		tagSaque.setBounds(78, 5, 207, 21);
		tagSaque.setFont(new Font("Tahoma", Font.PLAIN, 17));
		caixaTexto = new JTextField(20);
		caixaTexto.setBounds(290, 5, 166, 20);
		
		painelCabeçalho.add(textoBanco);
		painel.setLayout(null);
		
		
		painel.add(tagSaque);
		painel.add(caixaTexto);
		janela.getContentPane().add(painelCabeçalho,BorderLayout.NORTH);
		janela.getContentPane().add(painel,BorderLayout.CENTER);
		botaoSacar.setBounds(212, 71, 120, 31);
		painel.add(botaoSacar);
		botaoSacar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(caixaTexto.getText().length() == 0) {
					JOptionPane.showMessageDialog(janela, "Nenhum valor foi sacado.");
					janela.setVisible(false);
				} else {
					try {
						double valor = Double.parseDouble(caixaTexto.getText());
						JanelaPrincipalGUI.getContas().get(SelecionaContaGUI.getSelectedIndex()).saque(valor);
						janela.setVisible(false);
						JOptionPane.showMessageDialog(janela, "O saque foi realizado.");	
					} catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(janela, "Valor de saque inválido.");
					} catch (ContaException e1) {
						JOptionPane.showMessageDialog(janela, "Saldo insuficiente.");
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		janela.setVisible(true);
	}

}
