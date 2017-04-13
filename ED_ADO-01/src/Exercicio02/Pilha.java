/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio02;

/**
 *
 * @author jonata.hmoliveira
 */
public class Pilha {

    private int numeroDeCartas;
    private Object[] dados;
    private int top;

    // Construtor - Cria uma pilha vazia do tamanho passado ao construtor.
    public Pilha() {
        numeroDeCartas = 0;
        dados = new Object[52];
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
}
