public class PessoaJuridica extends Pessoa {

	private String cnpj;
	private String nomeFantasia;
	private static int quantPessoasJuridicas = 0;

	public PessoaJuridica(String nome, String endereco, String cnpj, String nomeFantasia, MeioContato[] contato) {
		super(nome, endereco, TipoPessoa.JURIDICA, contato);
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		quantPessoasJuridicas++;
	}
	
	public static void setQuantPessoasJuridicas() {
		quantPessoasJuridicas--;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public static int getQuantPessoasJuridicas() {
		return quantPessoasJuridicas;
	}

	@Override
	public void mostrarDados() {
		System.out.println("Nome: " + getNome());
		System.out.println("Endereco: " + getEndereco());
		System.out.println("CNPJ: " + this.cnpj);
		System.out.println("Nome Fantasia: " + this.nomeFantasia);
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] != null) {
				System.out.print(lista[i].meioContato.getNome() + ": ");
				System.out.println(lista[i].getDescricao());
			}
		}
		System.out.println("-----------------------------------------------");
	}

}