public abstract class Conta{
    
    //Atributos
    protected static int geraNumero=0;
    private int numero;
    private double saldo = 0;
    private Pessoa cliente;

    
    
    //Metodo construtor, implementado para facilitar utilização dos construtores das subclasses
    public Conta(Pessoa cliente) {
    	numero = geraNumero;
    	geraNumero++;
        this.cliente = cliente;
    }

    
    
    
    //metodo que retorna o numero gerado no construtor
    protected static int geraNumero(){
        return numero;        
    }

    //Metodo que retorna o saldo
    public double getSaldo() {
        return saldo;
    }
    
    //Metodo de deposito
    public void deposito(double valor){
        saldo += valor;
    }
    
    //Metodo para retornar o cliente
    public Pessoa getCliente() {
        return cliente;
    }
    
    //Metodo de saque
    public abstract void saque(double valor);
    
    //Metodo abstrato de retorno do tipo
    public abstract String getTipo();    
}
