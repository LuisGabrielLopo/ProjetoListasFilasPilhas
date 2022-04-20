package service;

import exception.ValorExisteException;
import model.Pilha;
import java.util.Scanner;

public class PilhaService {
    private final Pilha pilha = Pilha.getIstance();
    private Scanner scan = new Scanner(System.in);

    public void iniciar(Integer acao){
        switch (acao){
            case 1:
                System.out.println("Insira o valor desejado");
                Integer valorInserir = scan.nextInt();
                pilha.push(valorInserir);
                imprimir();
                break;

            case 2:
                pilha.pop();
//                System.out.printf("Número removido: %d\n", pilha.pop());
                imprimir();
                break;

            case 3:
                System.out.println("Qual número deseja inserir?");
                Integer valorBuscar = scan.nextInt();
                Boolean existe = buscar(valorBuscar);
                if (existe){
                    System.out.println("o número informado já existe na pilha");
                } else {
                    System.out.println("o número informado não existe na pilha");
                }
                break;

            case 4:
                imprimir();
                break;
        }
    }

    public void adicionar(Integer valor){
        if (this.pilha.exists(valor)){
            throw new ValorExisteException("Esse valor já existe dentro da pilha");
        }
        this.pilha.push(valor);
    }

    public Integer remover(){
        return this.pilha.pop();
    }

    public void imprimir(){
        this.pilha.iteratorPilha();
    }

    public Boolean buscar(Integer valor){
        return this.pilha.exists(valor);
    }

}
