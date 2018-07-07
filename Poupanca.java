package projeto;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Poupanca extends Conta{
   
    
	public Poupanca(Pessoa cliente) {
		super(cliente);
		
	}
   

    @Override
    public void saque(double valor) throws ContaException {
        if (valor > getSaldo()){
                 throw new ContaException();
           }
        else {
        	super.saque(valor);
        }
    }

    @Override
    public String getTipo() {
        return null;
    }
    
}
