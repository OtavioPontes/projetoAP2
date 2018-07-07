package projeto;
public class PessoaJuridica extends Pessoa{

	//Atributos
	protected static int geraid = 0;
	private String cnpj;
	
	//Método Construtor
	public PessoaJuridica (String nome, Endereço endereço, String cnpj) throws PessoaException {
		super(nome,endereço);
		this.id = Integer.toString(geraid);
		
		//metodo para validar o cnpj
		if(validaCNPJ(cnpj)) {
			this.cnpj = cnpj;
		} else {
			throw new PessoaException();
		}
		
		geraid++;
	}
	
	//Método gerarId
	@Override
	protected String gerarId() {
		geraid++;
		return "Int " + geraid;
	}
	
	//Método validaCNPJ
		private boolean validaCNPJ(String cnpj) {
			int soma1=0, resto1=0, soma2=0, resto2=0;
			int seq1[] = new int[4];
			int seq2[] = new int [8];
			int verif[] = new int[2];
			int aux1 = 5, aux2 = 9, aux3 = 6, aux4 = 9;
			boolean teste = true;
			
			for(int i=0; i<4; i++) {
				seq1[i] = Integer.parseInt(String.valueOf(cnpj.charAt(i)));
			}
			for(int i=4; i<12; i++) {
				seq2[i-4] = Integer.parseInt(String.valueOf(cnpj.charAt(i)));
			}
			
			if(seq1[0]==seq1[1] && seq1[1]==seq1[2] && seq1[2]==seq1[3] && seq1[3]==seq2[0] && seq2[0] == seq2[1]&& seq2[1] == seq2[2] && seq2[2] == seq2[3] && seq2[3] == seq2[4] && seq2[4]==seq2[5] && seq2[5]==seq2[6] && seq2[6]==seq2[7]) {
				teste = false;
			}
			
			for(int i=0; i<4; i++) {
				soma1 += seq1[i] * aux1;
				aux1--;
			}
			for(int i=4; i<12; i++) {
				soma1 += seq2[i-4] * aux2;
				aux2--;
			}
			
			resto1 = soma1 % 11;
			
			if(resto1==0 || resto1==1) {
				resto1 = 0;
			}
			
			else {
				resto1 = 11 - resto1;
			}
			
			for(int i=0; i<4; i++) {
				soma2 += seq1[i] * aux3;
				aux3--;
			}
			
			soma2 += seq2[0] * 2;
			
			for(int i=1; i<8; i++) {
				soma2 += seq2[i] * aux4;
				aux4--;
			}
			
			soma2 += resto1*2;
			resto2 = soma2 % 11;
			
			if(resto2 == 0 || resto2 == 1) {
				resto2 = 0;
			}
			
			else {
				resto2 = 11 - resto2;
			}
			
			for(int i=0; i<2; i++) {
				verif[i] = Integer.parseInt(String.valueOf(cnpj.charAt(i+12)));
			}
			
			if(resto1 == verif[0] && resto2 == verif[1] && teste == true) {
				return true;
			}
			else {
				return false;
				
			}
		}
		
	//Método getCNPJ
	public String getCNPJ() {
		return cnpj;
	}
	//Método toString
	public String toString() {
		return super.toString()+"Cnpj: "+this.cnpj+"\n";
	}
	
	//Classe para Exceção de Pessoa
		public class PessoaException extends Exception {
			public PessoaException() {
				
			}
		}
}
