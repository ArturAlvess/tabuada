package br.senai.sp.jandira;

import java.util.Scanner;

import br.senai.jandira.model.Tabuada;

public class AppTabuada {

	public static void main(String[] args) {
		
		Scanner numeros = new Scanner(System.in);
		Tabuada usuario = new Tabuada();
		
		
		System.out.print("Qual o multiplicando? ");
		numeros.nextInt();
		
		System.out.print("Qual o mínimo multiplicando? ");
		numeros.nextInt();
		
		System.out.println("Qual o máximo multiplicando? ");
		numeros.nextInt();
		
			}

}
