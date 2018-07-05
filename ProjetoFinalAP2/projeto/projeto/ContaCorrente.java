package projeto;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ContaCorrente extends Conta{
    
    

	//atributos
    private double limite;
    private Poupanca contaPoupanca;
    
    //Construtor de ContaCorrente, que aciona o construtor de Conta
    public ContaCorrente(Pessoa cliente, double limite) {
		super(cliente);
		this.limite = limite;
	}
    
    
    //Sobrescrita do metodo saque
    @Override
    public void saque(double valor) {
        while (true){
            try{
                if (valor>(getSaldo() + limite)){
                    throw new ContaException();
                }
                break;                
            }
            catch(ContaException e){
            	JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                e.printStackTrace();;             
            }
        }
    }

    //sobrescrição do metodo getTipo
    @Override
    public String getTipo() {
        return "Conta Corrente";        
    }

    //metodo setLimite
    public void setLimite(double limite) {
        this.limite = limite;
    }

    //metodo getLimite
    public double getLimite() {
        return limite;
    }

    //criação da exceção personalizada ContaException
    public static class ContaException extends Exception {

        public ContaException() {
        }
    }
    
}
