public class Agenda {

	private int quantLivre = 10;
	private int posicaoLivre = 0;
	Pessoa[] lista = new Pessoa[10];
	Pessoa[] listaAux = new Pessoa[10];

	private void auxiliar() {
		int j = 0;
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] != null) {
				listaAux[j] = lista[i];
				j++;
			}
		}
		for (int i = 0; i < lista.length; i++) {
			lista[i]=listaAux[i];
		}
	}

	public void adicionaContato(Pessoa pessoa) {
		lista[posicaoLivre] = pessoa;
		posicaoLivre++;
		quantLivre--;
		System.out.println("Contato adicionado com sucesso!");
	}

	public void removerContato(Pessoa pessoa) {
		for (int i = 0; i < posicaoLivre; i++) {
			if (pessoa.getNome().equals(lista[i].getNome()) && pessoa.tipo.equals(lista[i].tipo)) {
				lista[i] = null;
				posicaoLivre--;
				quantLivre++;
				Pessoa.setQuantPessoa();
				if (pessoa.tipo == TipoPessoa.FISICA)
					PessoaFisica.setQuantPessoasFisicas();
				else
					PessoaJuridica.setQuantPessoasJuridicas();
				System.out.println("Contato removido com sucesso!");
			} else if (i == posicaoLivre) {
				System.out.println("Contato não existe!");
			}
		}
		auxiliar();
	}

	public int getQuantLivre() {
		return quantLivre;
	}

	public void mostrarDados() {
		for (int i = 0; i < posicaoLivre; i++) {
			lista[i].mostrarDados();
		}
	}

	public PessoaFisica[] consultaDadosPF(String nome) {
		PessoaFisica[] fisicos = new PessoaFisica[10];
		int j = 0;
		for (int i = 0; i < posicaoLivre; i++) {
			if (lista[i].getNome().equals(nome) && lista[i].tipo == TipoPessoa.FISICA) {
				fisicos[j] = (PessoaFisica) lista[i];
				j++;
			}
		}
		return fisicos;
	}

	public PessoaJuridica[] consultaDadosPJ(String nome) {
		PessoaJuridica[] juridicos = new PessoaJuridica[10];
		int j = 0;
		for (int i = 0; i < posicaoLivre; i++) {
			if (lista[i].getNome().equals(nome) && lista[i].tipo == TipoPessoa.JURIDICA) {
				juridicos[j] = (PessoaJuridica) lista[i];
				j++;
			}
		}
		return juridicos;
	}
}