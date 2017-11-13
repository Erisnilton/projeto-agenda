public class PessoaFisica extends Pessoa {

	private String cpf;
	private int anoNascimento;
	private static int quantPessoasFisicas = 0;

	public PessoaFisica(String cpf, int anoNascimento, String nome, String endereco, MeioContato[] meio) {
		super(nome, endereco, TipoPessoa.FISICA, meio);
		this.anoNascimento = anoNascimento;
		this.cpf = cpf;
		quantPessoasFisicas++;
	}
	
	public static void setQuantPessoasFisicas() {
		quantPessoasFisicas--;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public static int getQuantPessoasFisicas() {
		return quantPessoasFisicas;
	}

	public int calcularIdade(int anoAtual) {
		return anoAtual - this.anoNascimento;
	}

	@Override
	public void mostrarDados() {
		System.out.println("Nome: " + getNome());
		System.out.println("Endereco: " + getEndereco());
		System.out.println("CPF: " + this.cpf);
		System.out.println("Idade: " + calcularIdade(2017) + " anos");
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] != null) {
				System.out.print(lista[i].meioContato.getNome() + ": ");
				System.out.println(lista[i].getDescricao());
			}
		}
		System.out.println("----------------------------------------------------");
	}
}