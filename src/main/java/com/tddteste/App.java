package com.tddteste;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String playerName1;
		String playerName2;
		System.out.format("Jogador 1 informe seu nome: ");
		playerName1 =  scanner.nextLine();
		System.out.format("Jogador 2 informe seu nome: ");
		playerName2 =  scanner.nextLine();
		
		GameController game = new GameController();
		game.startGame(playerName1, playerName2);
	}
}