
public class Endereço {

	//Atributos
	protected static int geraId = 0;
	protected String id;
	private String tipe = "Residencial";
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
		super();
		this.tipe = tipe;
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
		super();
		this.tipoDeLogradouro = tipoDeLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		geraId++;
	}
	
	private String gerarID() {
		return ("Endereço - " + geraId);
	}
	
	
	public String getId() {
		return id;
	}


	public String getTipe() {
		return this.tipe;
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

	protected void setTipe(String tipo) {
		this.tipe = tipo;
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



	@Override
	public String toString() {
		return "Endereço [id:" + id + ", tipe:" + tipe + ", tipoDeLogradouro:" + tipoDeLogradouro + ", logradouro:"
				+ logradouro + ", numero:" + numero + ", bairro:" + bairro + ", cidade:" + cidade + ", estado:" + estado
				+ ", cep:" + cep + "]";
	}


	










}
