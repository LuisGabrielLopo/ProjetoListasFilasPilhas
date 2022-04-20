package controller;

import exception.EscolhaInvalidaExcepiton;
import service.*;

import sun.applet.Main;

import java.util.Scanner;

public class Menu {

    private final FilaService filaService = new FilaService();
    private final PilhaService pilhaService = new PilhaService();
    private final ListaService listaService = new ListaService();
    private Integer acao = 0;
    private Integer option = 0;

    public void inicio() {
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("(1) Inserir novo elemento\n(2) Remover Elemento\n(3) Buscar Elemento\n(4) Imprimir Elemento\n(0)Sair\n");
            acao = scan.nextInt();
            if (!validaEscolha(acao, 4)) {
                throw new EscolhaInvalidaExcepiton("Escolha invalida, por favor, escolha uma opção de 0 a 4");
            }
            System.out.print("(1) Lista\n(2) Pilha\n(3) Fila\n(0)Sair\n");
            option = scan.nextInt();
            if (!validaEscolha(option, 3)) {
                throw new EscolhaInvalidaExcepiton("Escolha invalida, por favor, escolha uma opção de 0 a 4");
            }
            switch (option) {
                case 1:
                    System.out.println(acao);
                    listaService.iniciar(acao);
                    break;
                case 2:
                    pilhaService.iniciar(acao);
                    break;
                case 3:
                    filaService.iniciar(acao);
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    break;
                default:
                    throw new EscolhaInvalidaExcepiton("Defina uma opção valida no menu");
            }
        }while (option != 0);
    }

    public Boolean validaEscolha(Integer escolha, Integer limite) {
        if (escolha < 0 || escolha > limite) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
