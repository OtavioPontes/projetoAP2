import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;

public class SelecionaContaGUI {

	private JFrame frameSelecionaConta;
	private static int selectedIndex;
	private CaixaEletronicoGUI caixa;
	
	public SelecionaContaGUI() {
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
		frameSelecionaConta.setVisible(true);
	}

	//Cria os componentes do Layout
	private void criaLayout() {
		frameSelecionaConta = new JFrame();
		frameSelecionaConta.setTitle("Conta");
		frameSelecionaConta.setBounds(100, 100, 330, 311);
		frameSelecionaConta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameSelecionaConta.getContentPane().setLayout(null);
		frameSelecionaConta.setLocationRelativeTo(null);
		
		
		
		JLabel labelSelecionaConta = new JLabel("Selecione a conta a ser gerenciada:");
		labelSelecionaConta.setBounds(22, 11, 171, 14);
		frameSelecionaConta.getContentPane().add(labelSelecionaConta);
		
		JList listNomesContas = new JList(converteNomes());
		listNomesContas.setBounds(22, 36, 266, 190);
		frameSelecionaConta.getContentPane().add(listNomesContas);
		
		JButton buttonSelecionarConta = new JButton("OK");
		buttonSelecionarConta.setBounds(117, 237, 89, 23);
		frameSelecionaConta.getContentPane().add(buttonSelecionarConta);
		buttonSelecionarConta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listNomesContas.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(frameSelecionaConta, "Por favor, selecione uma conta");
				} else {
					selectedIndex = listNomesContas.getSelectedIndex();
					caixa = new CaixaEletronicoGUI();
					frameSelecionaConta.setVisible(false);
				}
			}
		});
	}
	
	//Método que converte contas cadastradas em vetor com nomes dos clientes
	private String[] converteNomes() {
		int tamanho = JanelaPrincipalGUI.getContas().size();
		String[] nomesContas = new String[tamanho];
		for(int i = 0; i < tamanho; i++) {
			nomesContas[i] = JanelaPrincipalGUI.getContas().get(i).getCliente().getNome();
		}
		return nomesContas;
	}
	
	//Retorna o index selecionado
	public static int getSelectedIndex() {
		return selectedIndex;
	}
}
