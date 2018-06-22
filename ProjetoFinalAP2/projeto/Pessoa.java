
public abstract class Pessoa {

	//Atributos
	protected static int geraid = 0 ;
	protected String id;
	protected String nome;
	protected Endereço endereço;

	//Método de incremento do ID
	protected abstract String gerarID() ;
	
	//Métodos que retornam dados
	public String getNome() {
		return this.nome;
	}
	public String getId() {
		return this.id;
	}

	//Método para setar endereço
	private void setEndereço(Endereço endereço) {
		this.endereço = endereço;
	}

	//Método que gera a String descritiva do objeto
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", endereço=" + endereço + "]";
	}
	
}
