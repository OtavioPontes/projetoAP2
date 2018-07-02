package projeto;

public class PessoaJuridica extends Pessoa{

	//Atributos
	protected static int geraid = 0;
	private String cnpj;
	
	//Método Construtor
	public PessoaJuridica (String nome, Endereço endereço, String cnpj) {
		super(nome,endereço);
		this.id = Integer.toString(geraid);
		this.cnpj = cnpj;
		geraid++;
	}
	
	//Método gerarId
	protected String gerarId() {
		return null;
	}
	//Método validaCNPJ
	private boolean validaCNPJ() {
		return true;
	}
	//Método getCNPJ
	public String getCNPJ() {
		return cnpj;
	}
	//Método toString
	public String toString() {
		return super.toString()+"Cnpj: "+this.cnpj+"\n";
	}
}
