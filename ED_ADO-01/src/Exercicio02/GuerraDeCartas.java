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

    public static Object[] criarBaralho() {
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

    public static Object[] embaralhar(Object[] baralho) {
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
    
    public static void distribuirCartas(Object[] baralho) {
        for (int i = 0; i < baralho.length; i++) {
            if (i % 2 != 1) {
                baralhoJogador1.enqueue(baralho[i]);
            }
        }
    }

    public static void main(String[] args) {
        Object[] baralho = criarBaralho();
        
    }
}
