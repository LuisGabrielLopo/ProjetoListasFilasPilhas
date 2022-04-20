package model;

import exception.ListaVaziaException;

public class Pilha extends ListaNo {

    private static volatile Pilha instance = null;

    public Pilha() {
        setTamanhoLista(0);
        setInicio(null);
        setUltimo(null);
    }

    public static Pilha getIstance() {
        if (instance == null) {
            synchronized (Pilha.class) {
                if (instance == null) {
                    instance = new Pilha();
                }
            }
        }
        return instance;
    }

    public void push(Integer inserirValor) {
        if(estaVazio()) {
            insereNoInicio(inserirValor);
        } else {
            insereNoFim(inserirValor);
        }
    }

    public Integer pop() {

        if (getTamanhoLista() == 0) {
            throw new ListaVaziaException("A fila está vazia");
        }
        No valorRetorno = getUltimo();
        if (getUltimo().equals(getInicio())) {
            setUltimo(null);
        } else {
            No atual = getInicio();
            while(atual.getProximo() != getUltimo()){
                atual = atual.getProximo();
            }
            setUltimo(atual);
            atual.proximo = null;
        }
        this.setTamanhoLista(this.getTamanhoLista() - 1);
        return valorRetorno.getValor();
    }

    public void iteratorPilha() {
        if (estaVazio()) {
            System.out.printf("Está vazio %s\n");
            return;
        }

        No auxiliar = getInicio();
        if (getTamanhoLista().equals(0)) {
            System.out.printf("Valor: %d ", auxiliar.getValor());
            System.out.printf("\nA fila tem %d de tamanho \n\n", getTamanhoLista());
            return;
        }

        while (auxiliar != null) {
            System.out.printf(" <- Valor: %d", auxiliar.getValor());
            auxiliar = auxiliar.getProximo();
        }
        System.out.printf("\nA pilha tem %d de tamanho \n\n", getTamanhoLista());
    }

    public Boolean exists(Integer valor) {
        if (estaVazio()) {
            return Boolean.FALSE;
        }

        No auxiliar = getInicio();
        while (auxiliar != null) {
            if (auxiliar.getValor().equals(valor)) {
                return Boolean.TRUE;
            }
            auxiliar = auxiliar.getProximo();
        }
        return Boolean.FALSE;
    }


}


