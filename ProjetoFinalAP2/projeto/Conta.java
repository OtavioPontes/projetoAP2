public abstract class Conta{
    
    //Atributos
    protected static int geraNumero=0;
    private int numero;
    private double saldo = 0;
    private Pessoa cliente;

    //Metodos construtores
    public Conta(int numero, Pessoa cliente) {
        this.numero = numero;
        this.cliente = cliente;
        geraNumero++;
    }

    public Conta() {
        geraNumero++;
    }
    
    //metodo que retorna o numero gerado no construtor
    protected static int geraNumero(){
        return geraNumero;        
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
