/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio01;

import java.util.Scanner;


/**
 *
 * @author jonata.hmoliveira
 */
public class JogoDeCartas {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Entre o tamanho da pilha de cartas: ");
        int tamanho = reader.nextInt();
        int aux = tamanho;
        int aux2 = 0;
        Pilha pilha = new Pilha(tamanho);
        
        /* Popula o a pilha com números inteiros, do tamanho da
           pilha decrementando até 1. */
        while (!pilha.isFull()) {
            pilha.push(aux);
            aux--;
            System.out.println(pilha.top());
        }

        /* Laço de repetição que faz a operação até o topo da pilha
           ser igual a 0, descartando nas rodadas pares e passando
           para a base nas rodadas ímpares. */
        while(pilha.getTop() > 0) {
            if (aux2 % 2 != 0) {
                pilha.passaParaBase();
            } else {
                pilha.guardaDescarte();
            }
            aux2++;
        }
        
        /* Imprime com concatenação semelhante ao enunciado. */
        System.out.print("Cartas Descartadas: ");
        pilha.imprimeDescartadas();
        System.out.println("\nCarta Restante: " + pilha.pop());
    }

}
