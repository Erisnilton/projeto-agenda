
public enum TipoMeioContato {

	TELEFONE("Telefone"), EMAIL("Email"), FAX("Fax");

	private String nome;

	private TipoMeioContato(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
}
