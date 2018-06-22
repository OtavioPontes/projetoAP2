package projeto;

public class PessoaJuridica extends Pessoa{

	protected static int geraid = 0;
	private String cnpj;
	
	public PessoaJuridica (String nome, Endereço endereço, String cnpj) {
		this.nome = nome;
		this.endereço = endereço;
		this.cnpj = cnpj;
	}
	
	protected String gerarId() {
		return null;
	}
	
	private boolean validaCNPJ() {
		return true;
	}
	
	public String getCNPJ() {
		return cnpj;
	}

	public String toString() {
		return "PessoaJuridica [cnpj=" + cnpj + "]";
	}
}
