public class Pessoa {

	private String endereco;
	private String nome;
	private static int quantPessoa = 0;
	TipoPessoa tipo;
	MeioContato[] lista;

	public Pessoa(String nome, String endereco, TipoPessoa alguem) {
		this.endereco = endereco;
		this.nome = nome;
		this.tipo = alguem;
	}

	public Pessoa(String nome, String endereco, TipoPessoa alguem, MeioContato[] contato) {
		this.endereco = endereco;
		this.nome = nome;
		this.tipo = alguem;
		this.lista = contato;
		quantPessoa++;
	}
	
	public static void setQuantPessoa() {
		quantPessoa--;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public static int getQuantPessoa() {
		return quantPessoa;
	}

	public void mostrarDados() {}
}