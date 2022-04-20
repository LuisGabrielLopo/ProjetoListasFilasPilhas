package service;

import exception.ValorExisteException;
import model.FilaNo;

import java.util.Scanner;

public class FilaService {
    private final FilaNo fila = FilaNo.getInstance();
    private Scanner scan = new Scanner(System.in);

    public void iniciar(Integer acao){
        switch (acao){
            case 1:
                System.out.println("Qual o número deseja inserir?");
                Integer valorInserir = scan.nextInt();
                adicionar(valorInserir);
                imprimir();
                break;
            case 2:
                System.out.printf("número removido: %d\n", remover());
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

    public void adicionar(Integer valor){
        if (this.fila.exists(valor)){
            throw new ValorExisteException("Esse valor já existe dentro da fila");
        }
        this.fila.inserirNoFim(valor);
    }

    public Integer remover(){
        return this.fila.removerNoInicio();
    }

    public void imprimir(){
        this.fila.iteratorFila();
    }

    public Boolean buscar(Integer valor){
        return this.fila.exists(valor);
    }

}
