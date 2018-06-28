import java.util.Scanner;

public class Poupanca extends Conta{
    Scanner input = new Scanner (System.in);
    
    public void Poupanca(Pessoa cliente){
    
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
                System.out.println("Seu limite é insuficiente, por favor entre com um novo valor:");
                valor = input.nextDouble();                
            }
        }
    }

    @Override
    public String getTipo() {
        return null;
    }
    
}
