package br.com.caioq.positivo_ou_negativo;

import java.util.Scanner;

public class PositivoOuNegativo  {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite um Numero : ");
            int num = sc.nextInt();
            
            Numero numero = new Numero();
            String pOn = numero.PositivoOrNegativo(num);
            System.out.println(pOn);
        }  
    }
}
