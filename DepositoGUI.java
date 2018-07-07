package projeto;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DepositoGUI {

	private  JFrame janela;
	private  JPanel painel,painelCabeçalho;
	private  JTextField caixaTexto;
	private  JLabel textoBanco,tagDeposito;
	private  JButton botaoDeposito;
	private String deposito;
	private ImageIcon icone = new ImageIcon(getClass().getResource("bancoLS.png"));
	
	public DepositoGUI() {
		
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
		
		janela = new JFrame("Depósito");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.getContentPane().setLayout(g1);
		janela.setBounds(100, 100, 550, 252);
		janela.setLocationRelativeTo(null);
		janela.setIconImage(icone.getImage());
		painel = new JPanel();
		painelCabeçalho = new JPanel();
		painelCabeçalho.setLayout(new GridLayout(2,1));
		
		textoBanco = new JLabel("Banco Los Santos");
		textoBanco.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textoBanco.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT);
		
		tagDeposito = new JLabel("Insira o valor a ser depositado: ");
		tagDeposito.setBounds(78, 5, 207, 21);
		tagDeposito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		caixaTexto = new JTextField(20);
		caixaTexto.setBounds(290, 5, 166, 20);
		
		painelCabeçalho.add(textoBanco);
		painel.setLayout(null);
		botaoDeposito = new JButton("Depositar");
		
		painel.add(tagDeposito);
		painel.add(caixaTexto);
		janela.getContentPane().add(painelCabeçalho,BorderLayout.NORTH);
		janela.getContentPane().add(painel,BorderLayout.CENTER);
		botaoDeposito.setBounds(212, 71, 120, 31);
		painel.add(botaoDeposito);
		
		janela.setVisible(true);
	
		botaoDeposito.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					deposito = caixaTexto.getText();
					double valor = Double.parseDouble(deposito);
					JanelaPrincipalGUI.getContas().get(SelecionaContaGUI.getSelectedIndex()).deposito(valor);
					janela.setVisible(false);
					JOptionPane.showMessageDialog(null,"O valor foi depositado com sucesso");
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(janela, "O valor depositado é inválido. Utilize pontos, e não virgulas.");
				}
				
				
				
				
			}
		});
	
	}
}
