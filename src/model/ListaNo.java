package model;

import exception.ListaVaziaException;
import exception.PosicaoListaInexistente;

public class ListaNo{

    private No inicio;
    private No ultimo ;
    private Integer tamanhoLista = 0;
    private static volatile ListaNo instance = null;


    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public static ListaNo getIstance() {
        if (instance == null) {
            synchronized (ListaNo.class) {
                if (instance == null) {
                    instance = new ListaNo();
                }
            }
        }
        return instance;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public Integer getTamanhoLista() {
        return tamanhoLista;
    }

    public void setTamanhoLista(Integer tamanhoLista) {
        this.tamanhoLista = tamanhoLista;
    }

    public Boolean estaVazio(){
        return this.inicio == null;
    }

    private No pegaNo(int posicao) {
        if (!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posicao Inesistente");
        }

        No atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >=0 && posicao < this.tamanhoLista;
    }



    public void insereEmQualquerLugar( Integer insertItem, int posicao){
      if (estaVazio()){
          insereNoInicio(insertItem);
      }else if (posicao == 1){
          insereNoInicio(insertItem);
      }
      else if (tamanhoLista + 1 == posicao){
          insereNoInicio(insertItem);
      }else {
          No elemento = inicio;
          int contador =1;
          while(contador != posicao -1){
              if (contador!= 0){
                  elemento = elemento.proximo;
              }
              contador ++;
          }
          elemento.setProximo(new No(insertItem,elemento.getProximo()));
          this.tamanhoLista++;
      }



    }

    public void insereNoInicio(Integer insertItem){
       No novo = new No(insertItem, inicio);
       this.inicio = novo;

       if (this.tamanhoLista == 0){
           this.ultimo = this.inicio;
       }
       this.tamanhoLista ++;

    }
    public void insereNoFim(Integer insertItem){
       if (this.tamanhoLista == 0){
           insereNoInicio(insertItem);
       }else{
           No novo = new No(insertItem);
           this.ultimo.setProximo(novo);
           this.ultimo = novo;
           this.tamanhoLista++;
       }

    }

    public void removeInicio() throws ListaVaziaException {
        if (estaVazio()) {
            throw new ListaVaziaException("A lista está vazia");
        }
        this.inicio = this.inicio.getProximo();
        this.tamanhoLista--;

        if (this.tamanhoLista == 0){
            this.ultimo = null;
        }


    }
    public Integer removeFim() throws ListaVaziaException {
        if (estaVazio()){
            throw  new ListaVaziaException("Lista Vazia");
        }
        Integer removedItem = ultimo.valor;

        if (inicio == ultimo){
            inicio = ultimo = null;
        }
        else{
            No atual = inicio;
            while (atual.proximo != ultimo){
                atual = atual.proximo;
            }
            ultimo = atual;
            atual.proximo = null;
        }
        this.tamanhoLista -- ;
        return removedItem;

    }
    public void removeEmQualquerPosicao (int posicao){
        if(posicao < 0 || posicao >= tamanhoLista || inicio == null){
            throw new PosicaoListaInexistente("Não existe");
        }else if (posicao == 0){
            removeInicio();
        }else if (posicao == tamanhoLista -1){
            removeFim();
        } else {
            No anterior = this.pegaNo(posicao - 1);
            No atual = anterior.getProximo();
            No proxima = atual.getProximo();
            anterior.setProximo(proxima);
            proxima.setAnterior(anterior);
            this.tamanhoLista--;
        }

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

    public void iteratorLista(){
        if (estaVazio()) {
            System.out.printf("Lista Vazia %s\n");
            return;
        }
        No auxiliar = getInicio();
        if (getTamanhoLista().equals(0)){
            System.out.printf("Valor: %d ", auxiliar.getValor());
            System.out.printf("\nA fila tem %d de tamanho \n\n", getTamanhoLista());
            return;
        }

        while (auxiliar != null) {
            System.out.printf(" <- Valor: %d", auxiliar.getValor());
            auxiliar = auxiliar.getProximo();
        }
        System.out.printf("\nA fila tem %d de tamanho \n\n", getTamanhoLista());
    }


}
