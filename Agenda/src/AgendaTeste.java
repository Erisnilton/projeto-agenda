import java.util.Scanner;

public class AgendaTeste {

	public static MeioContato[] operacao() {
		Scanner teclado = new Scanner(System.in);
		MeioContato[] quant = new MeioContato[20];
		int tipoContato;
		int posLivre = 0;

		do {
			System.out.println("Qual meio de contato deseja adicionar: ");
			System.out.println("1- Email\t2- Telefone\t3- Fax\t0- fim");
			tipoContato = teclado.nextInt();
			switch (tipoContato) {
			case 1:
				MeioContato meio = new MeioContato();
				meio.meioContato = TipoMeioContato.EMAIL;
				System.out.print("Descrição: ");
				meio.setDescricao(teclado.next());
				quant[posLivre] = meio;
				posLivre++;
				break;
			case 2:
				MeioContato meio1 = new MeioContato();
				meio1.meioContato = TipoMeioContato.TELEFONE;
				System.out.print("Descrição: ");
				meio1.setDescricao(teclado.next());
				quant[posLivre] = meio1;
				posLivre++;
				break;
			case 3:
				MeioContato meio2 = new MeioContato();
				meio2.meioContato = TipoMeioContato.FAX;
				System.out.print("Descrição: ");
				meio2.setDescricao(teclado.next());
				quant[posLivre] = meio2;
				posLivre++;
				break;
			case 0:
				break;
			default:
				System.out.println("Invalido");
				break;
			}
		} while (tipoContato >= 1);
		return quant;
	}

	public static void operacao2(Pessoa[] pessoa) {
		for (int i = 0; i < pessoa.length; i++) {
			if (pessoa[i] != null)
				pessoa[i].mostrarDados();
		}
	}

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		Agenda agenda = new Agenda();
		int opcao;

		do {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=MENU=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Digite uma opção:");
			System.out.println("1- Adicionar Contato\t\t\t2- Remover Contato");
			System.out.println("3- Mostrar Dados\t\t\t4- Consultar Dados de Pessoa Fisica");
			System.out.println("5- Consultar Dados de Pessoa Juridica\t6- Total de Contatos");
			System.out.println("0- Sair");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=MENU=-=-=-=-=-=-=-=-=-=-=-=-");
			opcao = teclado.nextInt();
			switch (opcao) {
			case 1:
				if (agenda.getQuantLivre() > 0) {
					System.out.println("Deseja adicionar pessoa fisica ou juridica?");
					String tipo = teclado.next();
					if (tipo.equals("fisica")) {
						System.out.print("Nome: ");
						String nome = teclado.next();
						System.out.print("Endereço: ");
						String endereco = teclado.next();
						System.out.print("CPF: ");
						String cpf = teclado.next();
						System.out.print("Ano de Nascimento: ");
						int nasc = teclado.nextInt();
						agenda.adicionaContato(new PessoaFisica(cpf, nasc, nome, endereco, operacao()));
					} else if (tipo.equals("juridica")) {
						System.out.print("Nome: ");
						String nome = teclado.next();
						System.out.print("Endereço: ");
						String endereco = teclado.next();
						System.out.print("CNPJ: ");
						String cnpj = teclado.next();
						System.out.print("Nome Fantasia: ");
						String nomeF = teclado.next();
						agenda.adicionaContato(new PessoaJuridica(nome, endereco, cnpj, nomeF, operacao()));
					} else {
						System.out.println("Tipo Invalido!");
						continue;
					}
				} else
					System.out.println("Não há espaço livre!");
				break;
			case 2:
				if (agenda.getQuantLivre() < 10) {
					System.out.print("Digite o nome da pessoa que deseja remover: ");
					String nome = teclado.next();
					System.out.print("Digite o endereço: ");
					String endereco = teclado.next();
					System.out.print("Tipo da pessoa: ");
					String tipo = teclado.next();
					if (tipo.equals("fisica"))
						agenda.removerContato(new Pessoa(nome, endereco, TipoPessoa.FISICA));
					else
						agenda.removerContato(new Pessoa(nome, endereco, TipoPessoa.JURIDICA));
				} else
					System.out.println("Não existem contatos!");
				break;
			case 3:
				agenda.mostrarDados();
				break;
			case 4:
				System.out.print("Digite o nome do contato: ");
				String nomeP = teclado.next();
				operacao2(agenda.consultaDadosPF(nomeP));
				break;
			case 5:
				System.out.print("Digite o nome do contato: ");
				String nomeJ = teclado.next();
				operacao2(agenda.consultaDadosPJ(nomeJ));
				break;
			case 6:
				System.out.println("Total de Pessoas: " + Pessoa.getQuantPessoa());
				System.out.println("Total de Pessoas Fisicas: " + PessoaFisica.getQuantPessoasFisicas());
				System.out.println("Total de Pessoas Juridicas: " + PessoaJuridica.getQuantPessoasJuridicas());
				break;
			case 0:
				System.out.println("----------------Programa encerrado!----------------");
				break;
			default:
				System.out.println("-=-=-=-=-=-=-=-=-=-Comando Invalido-=-=-=-=-=-=-=-=-=-");
				break;
			}

		} while (opcao > 0);
	}
}