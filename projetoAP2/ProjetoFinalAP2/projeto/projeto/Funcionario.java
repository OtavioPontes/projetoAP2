public class Funcionario extends PessoaFisica {

	private static int geraid = 0;
	private String cargo;
	
	public Funcionario(String nome, Endereço endereço, String cpf, String cargo) throws PessoaException{
		super(nome, endereço, cpf);
		this.cargo = cargo;
	}

	@Override
	protected String gerarId() {
		geraid++;
		return "Int " + geraid;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Funcionario [Cargo = " + cargo + ", CPF = " + getCPF() + ", Nome = " + getNome() + ", Id = " + getId() + "]";
	}
}
