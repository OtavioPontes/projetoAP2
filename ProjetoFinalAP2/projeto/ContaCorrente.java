import java.util.Scanner;

public class ContaCorrente extends Conta{
    
    //atributos
    private double limite;
    private Poupanca contaPoupanca;
    
    //criação do scanner
    Scanner input = new Scanner(System.in);
    
    //Sobrescrição do metodo saque
    @Override
    public void saque(double valor) {
        while (true){
            try{
                if (valor>(getSaldo()+limite)){
                    throw new ContaException();
                }
                break;                
            }
            catch(ContaException e){
                System.out.println("Seu limite é insuficiente, por favor entre com um novo valor:");
                valor = input.nextDouble();             
            }
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

    //criação da exceção personalizada ContaException
    public static class ContaException extends Exception {

        public ContaException() {
        }
    }
    
}
