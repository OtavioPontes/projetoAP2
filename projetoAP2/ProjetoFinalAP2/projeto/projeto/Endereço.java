

public class Endereço {

	//Atributos
	protected static int geraId = 0;
	protected String id;
	private String tipo = "Residencial";
	private String tipoDeLogradouro;
	private String logradouro; 
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	
	
	//Construtor 1
	public Endereço(String tipe, String tipoDeLogradouro, String logradouro, int numero, String bairro,
			String cidade, String estado, String cep) {
		
		this.id = Integer.toString(geraId);
		this.tipoDeLogradouro = tipoDeLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		geraId++;
	}


	//Construtor 2
	public Endereço(String tipoDeLogradouro, String logradouro, int numero, String bairro, String cidade, String estado,
			String cep) {
		this.id = Integer.toString(geraId);
		this.tipoDeLogradouro = tipoDeLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		geraId++;
	}
	
	private String gerarId() {
		return ("Endereço - " + geraId);
	}
	
	//Métodos get
	public String getId() {
		return this.id;
	}

	public String getTipo() {
		return this.tipo;
	}
	
	public String getTipoDeLogradouro() {
		return this.tipoDeLogradouro;
	}
	public String getLogradouro() {
		return this.logradouro;
	}
	public int getNumero() {
		return this.numero;
	}
	public String getCep() {
		return this.cep;
	
	}
	public String getCidade() {
		return this.cidade;
	
	}
	public String getEstado() {
		return this.estado;
	}

	public String getBairro() {
		return this.bairro;
	}
	
	//Métodos set 
	protected void setTipe(String tipo) {
		this.tipo = tipo;
	}


	protected void setTipoDeLogradouro(String tipoDeLogradouro) {
		this.tipoDeLogradouro = tipoDeLogradouro;
	}

	protected void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	protected void setNumero(int numero) {
		this.numero = numero;
	}

	protected void setBairro(String bairro) {
		this.bairro = bairro;
	}

	protected void setCidade(String cidade) {
		this.cidade = cidade;
	}

	protected void setEstado(String estado) {
		this.estado = estado;
	}

	protected void setCEP(String cep) {
		this.cep = cep;
	}


	
	//Método toString
		public String toString() {
		return "\n Id: " + id + "\n Tipo: " + tipo + "\n Tipo de Logradouro: " + tipoDeLogradouro + "\n Logradouro: "
				+ logradouro + ", Número: " + numero + ", Bairro: " + bairro + "\n Cidade: " + cidade + "\n Estado: " + estado
				+ "\n Cep: " + cep;
	}


	










}
