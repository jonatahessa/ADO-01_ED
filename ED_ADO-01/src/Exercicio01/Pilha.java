/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio01;

/**
 *
 * @author jonata.hmoliveira
 */
public class Pilha {

    private Object[] descartadas;
    private int numeroDeCartas;
    private Object[] dados;
    private int top;

    public int getTop() {
        return top;
    }

    // Construtor - Cria uma pilha vazia do tamanho passado ao construtor.
    public Pilha(int tamanho) {
        descartadas = new Object[tamanho];
        numeroDeCartas = 0;
        dados = new Object[tamanho];
        top = -1;
    }

    // métodos
    public boolean isFull() {
        return (top == dados.length - 1);
    }

    public boolean isEmpty() {
        return (top == - 1);

    }

    public void push(Object x) {
        if (!isFull()) {
            top++;
            dados[top] = x;

        } else {
            System.out.println("Pilha Cheia");
        }
    }

    public Object pop() {
        if (!isEmpty()) {
            Object x = dados[top];
            top--;
            return x;
        } else {
            System.out.println("Pilha Vazia");
            return null;
        }
    }

    public Object top() {
        if (!isEmpty()) {
            return dados[top];
        } else {
            System.out.println("Pilha Vazia");
            return null;
        }
    }

    public void passaParaBase() {
        Object guardaTop;
        Object[] vetorAux = new Object[dados.length + 1];
        guardaTop = dados[top];
        for (int i = 0; i < dados.length - 1; i++) {
            vetorAux[i] = dados[i];
        }
        for (int i = 0; i < dados.length - 1; i++) {
            dados[i + 1] = vetorAux[i];
        }

        dados[0] = guardaTop;
    }

    public void guardaDescarte() {
        descartadas[numeroDeCartas] = pop();
        numeroDeCartas++;

    }

    public void imprimeDescartadas() {
        for (int i = 0; i < numeroDeCartas; i++) {
            System.out.print(descartadas[i] + ", ");
        }

    }
}
