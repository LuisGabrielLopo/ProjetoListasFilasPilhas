package service;

import exception.ValorExisteException;
import model.ListaNo;

import java.util.Scanner;

public class ListaService {
    private final ListaNo lista = ListaNo.getIstance();
    private Scanner scan = new Scanner(System.in);

    public void iniciar(Integer acao){
        switch (acao){
            case 1:
                System.out.println("Deseja inserir? [I] inicio [M]meio  [F]fim");
                String inserir = scan.next();
                if (inserir.equalsIgnoreCase("I")){
                    System.out.println("Informe um número a ser adcionado");
                    Integer valorInserir= scan.nextInt();
                    adicionarInicio(valorInserir);
                    imprimir();
                }
                if (inserir.equalsIgnoreCase("M")){
                    System.out.println("Informe um número a ser adcionado");
                    Integer valorinserir = scan.nextInt();
                    System.out.println("Informe a posição do número a ser adcionado");
                    int valorMeio = scan.nextInt();
                    adcionarQualquerLugar(valorinserir, valorMeio);
                    imprimir();
                }
                if (inserir.equalsIgnoreCase("F")){
                    System.out.println("Informe um número a ser adcionado");
                    Integer valorInserir= scan.nextInt();
                    adicionarFinal(valorInserir);
                    imprimir();
                }
                break;

            case 2:
                System.out.println("Deseja excluir? [I] inicio [M]meio  [F]fim");
                String excluir = scan.next();
                if (excluir.equalsIgnoreCase("I")){
                    removerInicio();
                    imprimir();
                }
                if (excluir.equalsIgnoreCase("M")){
                    System.out.println("Informe a posição do número a ser removido");
                    Integer valorMeio = scan.nextInt();
                    removeQualquerLugar(valorMeio);
                    imprimir();
                }
                if (excluir.equalsIgnoreCase("F")){
                    removerFinal();
                    imprimir();
                }


                imprimir();
                break;
            case 3:
                System.out.println("Qual o número deseja inserir?");
                Integer valorBuscar = scan.nextInt();
                Boolean existe = buscar(valorBuscar);
                if (existe){
                    System.out.println("o número existe na fila");
                }else{
                    System.out.println("O número não existe na fila");
                }
                break;
            case 4:
                imprimir();
                break;
        }
    }

    public void adicionarInicio(Integer valor){
        if (this.lista.exists(valor)){
            throw new ValorExisteException("Esse valor já existe dentro da lista");
        }
        this.lista.insereNoInicio(valor);
    }
    public void adicionarFinal(Integer valor){
        if (this.lista.exists(valor)){
            throw new ValorExisteException("Esse valor já existe dentro da lista");
        }
        this.lista.insereNoFim(valor);
    }
    public void adcionarQualquerLugar(Integer valor, int posicao){
        if (this.lista.exists(valor)){
            throw new ValorExisteException("Esse valor já existe dentro da lista");
        }
        this.lista.insereEmQualquerLugar(valor, posicao);
    }

    public void removerInicio(){
        this.lista.removeInicio();
    }
    public void removerFinal(){
        this.lista.removeFim();
    }
    public  void removeQualquerLugar(int posicao){
        this.lista.removeEmQualquerPosicao(posicao);
    }

    public void imprimir(){
        this.lista.iteratorLista();
    }

    public Boolean buscar(Integer valor){
        return this.lista.exists(valor);
    }

}
