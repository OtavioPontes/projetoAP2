package projeto;
public abstract class Pessoa {

	
	//Atributos
	protected static int geraid = 0 ;
	protected String id;
	protected String nome;
	protected Endereço endereço;
	
	//Construtor
	public Pessoa(String nome,Endereço endereço){
		this.id =Integer.toString(geraid);
		this.nome = nome;
		this.endereço = endereço;
		geraid++;
	}

	//Método abstrato
	abstract String gerarId() ;
	
	//Métodos get
	public String getNome() {
		return this.nome;
	}
	public String getId() {
		return this.id;
	}

	//Método set
	private void setEndereço(Endereço endereço) {
		this.endereço = endereço;
	}

	
	public String toString(){
		return "Id: "+this.id+"\nNome: "+this.nome+"\nEndereço: "+this.endereço+"\n";
	}

}
