import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;





public class CaixaEletronicoGUI {
	
	//Componentes
	private JFrame janelaCaixa;
	private JPanel painel;
	private JButton botaoSaque;
	private JButton botaoDeposito;
	private JButton botaoSaldo;
	private JLabel textoBanco;
	private JLabel textoAgencia;
	private JPanel painelCabeçalho;
	private JPanel painelSup1;
	private JPanel painelSup2;
	private JPanel painelSup3;
	private JLabel labelHorario;
	private SaqueGUI saqueGUI;
	private DepositoGUI depositoGUI;
	private Conta conta = JanelaPrincipalGUI.getContas().get(SelecionaContaGUI.getSelectedIndex());
	
	//Construtor
	public CaixaEletronicoGUI() {
		
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
				
				
		//Método para deixar janela parecida com o SO
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
	
	//Cria o layout
	private void criaLayout() {
		
		janelaCaixa = new JFrame("Caixa Eletrônico");
		painel = new JPanel();
		botaoSaque = new JButton("Saque");
		botaoDeposito = new JButton("Depósito");
		botaoSaldo = new JButton("Saldo");
		textoBanco = new JLabel("Banco de Los Santos");
		textoAgencia = new JLabel("Número da Conta: " + conta.geraNumero());
		painelCabeçalho = new JPanel();
		painelSup1 = new JPanel();
		painelSup2 = new JPanel();
		painelSup3 = new JPanel();
		labelHorario = new JLabel();
		botaoSaque.setFont(new Font("Tahoma", Font.PLAIN, 22));
		botaoDeposito.setFont(new Font("Tahoma", Font.PLAIN, 22));
		botaoSaldo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textoAgencia.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT);
		GridLayout layout1 = new GridLayout(3,1);
		layout1.setHgap(150);
		layout1.setVgap(20);
		painelCabeçalho.setLayout(new GridLayout(2,1));
		painelCabeçalho.add(textoBanco);
		painelCabeçalho.add(textoAgencia);
		textoAgencia.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textoBanco.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textoBanco.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		painel.setLayout(layout1);
		painel.add(botaoSaldo);
		painel.add(botaoSaque);
		painel.add(botaoDeposito);
		painelSup3.setLayout(new BorderLayout());
		painelSup3.add(labelHorario,BorderLayout.EAST);
		
		janelaCaixa.setLayout(new BorderLayout());
		janelaCaixa.setSize(600, 450);
		janelaCaixa.setLocationRelativeTo(null);
		janelaCaixa.add(painelCabeçalho,BorderLayout.NORTH);
		janelaCaixa.add(painelSup1, BorderLayout.EAST);
		janelaCaixa.add(painelSup2, BorderLayout.WEST);
		janelaCaixa.add(painelSup3, BorderLayout.SOUTH);
		janelaCaixa.add(painel, BorderLayout.CENTER);
		
		janelaCaixa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaCaixa.setVisible(true);
		
		//clique em saque
		botaoSaque.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 saqueGUI = new SaqueGUI();
				
			}
		});
		
		
		//clique em deposito
		botaoDeposito.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 depositoGUI = new DepositoGUI();
				
			}
		});
		
		
		//clique em saldo
		botaoSaldo.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double saldo = conta.getSaldo();
				JOptionPane.showMessageDialog(janelaCaixa, "Seu saldo é de R$" + saldo + ".");
			}
		});
	
	
	}
	

	


}