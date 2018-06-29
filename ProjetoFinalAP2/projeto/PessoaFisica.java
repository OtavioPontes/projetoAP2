
public class PessoaFisica extends Pessoa{

	protected static int geraid = 0;
	private String cpf;
	
	public PessoaFisica (String nome, Endereço endereço, String cpf) {
		this.nome = nome;
		//this.endereço = endereço;
		this.cpf = cpf;
		this.id = this.gerarID();
	}
	
	@Override
	protected String gerarID() {
		geraid++;
		return "Int " + geraid;
	}
	
	private boolean validaCPF() {
		
		int soma1=0, resto1=0, soma2=0, resto2=0;
		int num[] = new int[9];
		int verif[] = new int[2];
		int aux = 10, aux2 = 11;
		boolean teste = true;
		
		for(int i=0; i<9; i++) {
			num[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
		}
		
		if(num[0]==num[1] && num[1]==num[2] && num[2]==num[3] && num[3]==num[4] && num[4] == num[5]&& num[5] == num[6] && num[6] == num[7] && num[7] == num[8]) {
			teste = false;
		}
		
		for(int i=0; i<9; i++) {
			soma1 += num[i] * aux;
			aux--;
		}
		
		resto1 = (soma1*10) % 11;
		
		if(resto1==10) {
			resto1 = 0;
		}
		
		for(int i=0; i<9; i++) {
			soma2 += num[i] * aux2;
			aux2--;
		}
		
		soma2 += resto1*2;
		resto2 = (soma2*10) % 11;
		
		for(int i=0; i<2; i++) {
			verif[i] = Integer.parseInt(String.valueOf(cpf.charAt(i+9)));
		}
		
		if(resto1 == verif[0] && resto2 == verif[1] && teste == true) {
			return true;
		}
		else {
			return false;
		}
	}

	public String getCPF() {
		return this.cpf;
	}

	public String toString() {
		return "PessoaFisica [Nome: " + nome + ", ID: " + id + ", Endereço: " + ", CPF: " + cpf + "]";
	}
}
