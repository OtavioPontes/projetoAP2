package projeto;

public abstract class Pessoa {

	protected static int geraid = 0 ;
	protected String id;
	protected String nome;
	protected Endereço endereço;




	abstract String gerarId() ;
	
	public String getNome() {
		return this.nome;
	}
	public String getId() {
		return this.id;
	}


	private void setEndereço(Endereço endereço) {
		this.endereço = endereço;
	}




}
