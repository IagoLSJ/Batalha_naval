import java.util.Map;
import java.util.Scanner;

public class App {

	public static boolean validacao(int l, int c) {
		if (l > 9 || c > 9 || l < 0 || c < 0) {
			return false;
		}
		return true;
	}

	public static boolean insert(int l, int c, Navio n, Tabuleiro t) {
		if (n.linha + l > 9 || n.coluna + c > 9) {
			System.out.println("Seu navio não cabe aqui!!!");
			return false;
		}
		for (int i = l; i <= l + n.linha - 1; i++) {
			for (int j = c; j <= c + n.coluna - 1; j++) {
				if (t.tabuleiro[i][j] == 1) {
					System.out.println("Não se pode colocar um navio sobre o outro capitão.");
					return false;
				}
				t.tabuleiro[i][j] = 1;
			}
		}
		return true;
	}

	public static int scanner(Scanner scanner) {
		scanner.hasNextInt();
		while (!scanner.hasNextInt()) {
			System.out.println("Coloque entrada válida");
			scanner.nextLine();
		}
		int numero = scanner.nextInt();
		return numero;
	}

	public static void inserirNavios(Map<Integer, Navio> navios, Tabuleiro t, int index) {
		Scanner scanner = new Scanner(System.in);
		int nl = 0;
		int nc = 0;
		boolean isInsert = false;
		if (index == 7) {
			return;
		}
		System.out.format("Seu navio é %dx%d", navios.get(index).linha, navios.get(index).coluna);
		System.out.format("\n Insira a linha do %d navio: ", index);
		nl = scanner(scanner);

		System.out.format("\n Insira a coluna do %d navio: ", index);
		nc = scanner(scanner);
		isInsert = insert(nl, nc, navios.get(index), t);
		if (validacao(nl, nc) && isInsert) {
			inserirNavios(navios, t, index + 1);
		} else if (index <= 6) {
			inserirNavios(navios, t, index);
		}
	}

	public static boolean disparo(int l, int c, Tabuleiro t) {

		if (t.tabuleiro[l][c] == 1) {
			t.tabuleiro[l][c] = 2;
			return true;
		}
		return false;
	}

	public static boolean endGame(Tabuleiro t, int jogador, String nomeJogador) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (t.tabuleiro[i][j] == 1) {
					return false;
				}
			}
		}

		System.out.format("Parabens %s você ganhou", nomeJogador);
		return true;
	}

	public static void main(String[] args) {
		Jogador jogador01 = new Jogador("Iago");
		Jogador jogador02 = new Jogador("Jose");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Jogador 01 pode colocar seus navios no mar");
		inserirNavios(jogador01.navios, jogador01.tabuleiro, 1);
		System.out.println("Jogador 02 pode colocar seus navios no mar");
		inserirNavios(jogador02.navios, jogador02.tabuleiro, 1);
		System.out.println("Vamos começar o jogo");
	
		int nl = 0;
		int nc = 0;
		int currentPlayer = 1;
		String currentPlayerName = jogador01.nome;
	
		while (!endGame(jogador01.tabuleiro, currentPlayer, jogador01.nome) && !endGame(jogador02.tabuleiro, currentPlayer, jogador02.nome)) {
			System.out.format("Vez do %s jogar", currentPlayerName);
			if (currentPlayer == 1) {

				System.out.format("Insira uma linha: ");
				nl = scanner(scanner);

				System.out.format("Insira uma coluna: ");
				nc = scanner(scanner);
				while (!validacao(nl, nc)) {
					System.out.println("Tente um numero dentro do tabuleiro capitão!!!");
				
					System.out.format("Insira uma linha: ");
					nl = scanner(scanner);
					System.out.format("Insira uma coluna: ");
					nc = scanner(scanner);
				}

				disparo(nl, nc, jogador02.tabuleiro);
				jogador01.tabuleiro.showTabuleiro();
				currentPlayer = 2;
				currentPlayerName = jogador02.nome;
			} else {

				System.out.format("Insira uma linha: ");
				nl = scanner(scanner);

				System.out.format("Insira uma coluna: ");
				nc = scanner(scanner);

				while (!validacao(nl, nc)) {
					System.out.println("Tente um numero dentro do tabuleiro capitão!!!");

					System.out.format("Insira uma linha: ");
					nl = scanner(scanner);

					System.out.format("Insira uma coluna: ");
					nc = scanner(scanner);
				}
				disparo(nl, nc, jogador01.tabuleiro);
				jogador02.tabuleiro.showTabuleiro();
				
				currentPlayer = 1;
				currentPlayerName = jogador01.nome;
			}

		}
	}
}