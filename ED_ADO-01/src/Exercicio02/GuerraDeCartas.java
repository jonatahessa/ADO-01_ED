/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio02;

import java.util.Random;

/**
 *
 * @author jonat
 */
public class GuerraDeCartas {

    static Fila baralhoJogador1 = new Fila();
    static Fila baralhoJogador2 = new Fila();

    static Object[] criarBaralho() {
        Object[] manilhas = {"A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2"};
        Object[] baralhoMontado = new Object[52];
        int aux = 0, contaVezes = 0;

        for (int i = 0; i < baralhoMontado.length; i++) {
            switch (contaVezes) {
                case 0:
                    baralhoMontado[i] = manilhas[aux] + " de Ouros";
                    aux++;
                    break;
                case 1:
                    baralhoMontado[i] = manilhas[aux] + " de Espadas";
                    aux++;
                    break;
                case 2:
                    baralhoMontado[i] = manilhas[aux] + " de Copas";
                    aux++;
                    break;
                default:
                    baralhoMontado[i] = manilhas[aux] + " de Paus";
                    aux++;
                    break;
            }

            if (aux == 13) {
                aux = 0;
                contaVezes++;
            }
        }
        baralhoMontado = embaralhar(baralhoMontado);
        return baralhoMontado;

    }

    static Object[] embaralhar(Object[] baralho) {
        Random ramdom = new Random();
        Object aux;

        for (int i = 0; i < baralho.length; i++) {
            int j = ramdom.nextInt(baralho.length);

            aux = baralho[i];
            baralho[i] = baralho[j];
            baralho[j] = aux;
        }
        return baralho;
    }

    static void distribuirCartas(Object[] baralho) {
        for (int i = 0; i < baralho.length; i++) {
            if (i % 2 != 1) {
                baralhoJogador1.enqueue(baralho[i]);
            } else {
                baralhoJogador2.enqueue(baralho[i]);
            }
        }
    }

    static int conversaoCartas(Object carta) {
        int valor;
        switch (carta.toString().charAt(0)) {
            case 'A':
                valor = 13;
                break;
            case 'K':
                valor = 12;
                break;
            case 'Q':
                valor = 11;
                break;
            case 'J':
                valor = 10;
                break;
            case 'T':
                valor = 9;
                break;
            case '9':
                valor = 8;
                break;
            case '8':
                valor = 7;
                break;
            case '7':
                valor = 6;
                break;
            case '6':
                valor = 5;
                break;
            case '5':
                valor = 4;
                break;
            case '4':
                valor = 3;
                break;
            case '3':
                valor = 2;
                break;
            default:
                valor = 1;
                break;
        }
        return valor;
    }

    static int jogar() {
        int contaRodadas = 0, contaEmpates = 0;
        Pilha cartasJogador1 = new Pilha();
        Pilha cartasJogador2 = new Pilha();
        
        while (!baralhoJogador1.isEmpty() || !baralhoJogador2.isEmpty()) {
            cartasJogador1.push(baralhoJogador1.dequeue());
            cartasJogador2.push(baralhoJogador2.dequeue());
            int valor1 = conversaoCartas(cartasJogador1.top());
            int valor2 = conversaoCartas(cartasJogador2.top());
            System.out.println("Valor 1 = " + valor1);
            System.out.println("Valor 2 = " + valor2);
            
            if (valor1 == valor2) {
                for (int i = 0; i < 2; i++) {
                    if (!baralhoJogador1.isEmpty() && !baralhoJogador2.isEmpty()) {
                        cartasJogador1.push(baralhoJogador1.dequeue());
                        cartasJogador2.push(baralhoJogador2.dequeue());
                    } else {
                        return 0;
                    }
                }
                System.out.println("Empate!");
                contaEmpates++;
                contaRodadas++;
            } else if (valor1 > valor2) {
                while (!cartasJogador1.isEmpty()) {
                    baralhoJogador1.enqueue(cartasJogador1.pop());
                }
                while (!cartasJogador2.isEmpty()) {
                    baralhoJogador1.enqueue(cartasJogador2.pop());
                }
                System.out.println("Ponto Jogador 1");
                contaRodadas++;
            } else if (valor1 < valor2) {
                while (!cartasJogador1.isEmpty()) {
                    baralhoJogador2.enqueue(cartasJogador1.pop());
                }
                while (!cartasJogador2.isEmpty()) {
                    baralhoJogador2.enqueue(cartasJogador2.pop());
                }
                System.out.println("Ponto Jogador 2");
                contaRodadas++;
            }
        }

        if (cartasJogador1.isFull()) {
            System.out.println("O jogador 1 venceu, depois de " + contaRodadas + " rodadas e " + contaEmpates + "!");
        } else if (cartasJogador2.isFull()) {
            System.out.println("O jogador 2 venceu, depois de " + contaRodadas + " rodadas e " + contaEmpates + "!");
        }
        return 1;
    }

    public static void main(String[] args) {
        Object[] baralho = criarBaralho();
        distribuirCartas(baralho);
        jogar();
    }
}
