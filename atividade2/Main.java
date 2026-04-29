public class Main {

    public static void main(String[] args) {
        Sala sala = criarSala();
        int opcao = -1;

        while (opcao != 0) {
            opcao = menuPrincipal(sala);

            if (opcao == 1) {
                sala.alterarDados();
            } else if (opcao == 2) {
                sala.adicionarSessao();
            } else if (opcao == 3) {
                sala.listarSessoes();
            } else if (opcao == 4) {
                sala.alterarSessao();
            } else if (opcao == 5) {
                sala.removerSessao();
            } else if (opcao == 6) {
                gerenciarFilmes(sala);
            } else if (opcao == 7) {
                gerenciarAtores(sala);
            } else if (opcao == 8) {
                sala.listarTudo();
            } else if (opcao == 0) {
                InOut.MsgDeInformacao("UVV Flix", "Sistema encerrado.");
            } else {
                InOut.MsgDeErro("Erro", "Opcao invalida.");
            }
        }
    }

    static Sala criarSala() {
        int id = InOut.leInt("ID da sala:");
        int assentos = InOut.leInt("Numero de assentos:");
        String tela = InOut.leString("Tipo de tela:");
        String local = InOut.leString("Localizacao:");

        return new Sala(id, assentos, tela, local);
    }

    static int menuPrincipal(Sala sala) {
        String texto = "UVV Flix\n\n";
        texto += sala + "\n\n";
        texto += "1 - Alterar dados da sala\n";
        texto += "2 - Cadastrar sessao\n";
        texto += "3 - Listar sessoes\n";
        texto += "4 - Alterar sessao\n";
        texto += "5 - Remover sessao\n";
        texto += "6 - Gerenciar filmes\n";
        texto += "7 - Gerenciar atores\n";
        texto += "8 - Relatorio completo\n";
        texto += "0 - Sair";

        return InOut.leInt(texto);
    }

    static void gerenciarFilmes(Sala sala) {
        Sessao sessao = sala.escolherSessao();

        if (sessao == null) {
            return;
        }

        int opcao = -1;

        while (opcao != 0) {
            String texto = "Filmes\n\n";
            texto += sessao + "\n\n";
            texto += "1 - Cadastrar filme\n";
            texto += "2 - Listar filmes\n";
            texto += "3 - Alterar filme\n";
            texto += "4 - Remover filme\n";
            texto += "0 - Voltar";

            opcao = InOut.leInt(texto);

            if (opcao == 1) {
                sessao.adicionarFilme();
            } else if (opcao == 2) {
                sessao.listarFilmes();
            } else if (opcao == 3) {
                sessao.alterarFilme();
            } else if (opcao == 4) {
                sessao.removerFilme();
            } else if (opcao == 0) {
                return;
            } else {
                InOut.MsgDeErro("Erro", "Opcao invalida.");
            }
        }
    }

    static void gerenciarAtores(Sala sala) {
        Sessao sessao = sala.escolherSessao();

        if (sessao == null) {
            return;
        }

        Filme filme = sessao.escolherFilme();

        if (filme == null) {
            return;
        }

        int opcao = -1;

        while (opcao != 0) {
            String texto = "Atores\n\n";
            texto += filme + "\n\n";
            texto += "1 - Cadastrar ator\n";
            texto += "2 - Listar atores\n";
            texto += "3 - Alterar ator\n";
            texto += "4 - Remover ator\n";
            texto += "0 - Voltar";

            opcao = InOut.leInt(texto);

            if (opcao == 1) {
                filme.adicionarAtor();
            } else if (opcao == 2) {
                filme.listarAtores();
            } else if (opcao == 3) {
                filme.alterarAtor();
            } else if (opcao == 4) {
                filme.removerAtor();
            } else if (opcao == 0) {
                return;
            } else {
                InOut.MsgDeErro("Erro", "Opcao invalida.");
            }
        }
    }
}
