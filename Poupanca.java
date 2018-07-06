import java.util.Scanner;

import javax.swing.JOptionPane;

public class Poupanca extends Conta{
   
    
	public Poupanca(Pessoa cliente) {
		super(cliente);
		
	}
   

    @Override
    public void saque(double valor) {
        while (true){
            try{
                if (valor>getSaldo()){
                    throw new ContaCorrente.ContaException();
                }
                break;
            }
            catch(ContaCorrente.ContaException e){
            	JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                e.printStackTrace();           
            }
        }
    }

    @Override
    public String getTipo() {
        return null;
    }
    
}
