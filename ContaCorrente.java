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
    public void saque(double valor) throws ContaException{
       
         if (valor>(getSaldo() + limite)){
                 throw new ContaException();
             }
         else {
        	 super.saque(valor);
         }
    }

    //sobrescrição do metodo getTipo
    @Override
    public String getTipo() {
        return null;        
    }

    //metodo setLimite
    public void setLimite(double limite) {
        this.limite = limite;
    }

    //metodo getLimite
    public double getLimite() {
        return limite;
    }

    
    
}
