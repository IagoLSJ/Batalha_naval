import java.util.Scanner;

public class App {
  public static void insert(int l, int c, Navio n, Tabuleiro t) {
    for (int i = l; i <= l + n.linha - 1; i++) {
      for (int j = c; j <= c + n.coluna - 1; j++) {
        if (t.tabuleiro[i][j] == 1) {
          System.out.println("Não se pode colocar um navio sobre o outro capitão.");
          return;
        }
        t.tabuleiro[i][j] = 1;
      }
    }
  }
  public static  void inserirNavios(Navio n1, Navio n2, Navio n3, Navio n4, Tabuleiro t) {
    Scanner scanner = new Scanner(System.in);
    int inserirNavios = 1;
    int nl = 0;
    int nc = 0;

    System.out.println("Coloque seus navios de guerra no mar!!!");
    while (inserirNavios <= 4) {
      System.out.format("Insira a linha do %d navio: ", inserirNavios);
      nl = scanner.nextInt();

      System.out.format("Insira a coluna do %d navio: ", inserirNavios);
      nc = scanner.nextInt();

      switch (inserirNavios) {
      case 1:
        insert(nl, nc, n1, t);
        break;
      case 2:
        insert(nl, nc, n2, t);
        break;
      case 3:
        insert(nl, nc, n3, t);
        break;
      case 4:
        insert(nl, nc, n4, t);
        break;
      default:
        break;
      }
//    Limpar o console
      System.out.print("\033[H\033[2J");
      System.out.flush();
      inserirNavios++;
    }
   

  }
  public static boolean disparo(int l, int c, Tabuleiro t) {
     if (t.tabuleiro[l][c] == 1) {
       t.tabuleiro[l][c] = 2;
       return true;
     }
    return false;
  }

  public static boolean endGame(Tabuleiro t) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (t.tabuleiro[i][j] == 1) {
          return false;
        }
      }
    }
    System.out.println("Parabens você ganhou");
    return true;
  }

  public static void main(String[] args) {
    Tabuleiro t1 = new Tabuleiro();
    Tabuleiro t2 = new Tabuleiro();
  
    Navio n1 = new Navio(1, 4);
    Navio n2 = new Navio(1, 1);
    Navio n3 = new Navio(2, 2);
    Navio n4 = new Navio(3, 2);

    Scanner scanner = new Scanner(System.in);
  
    System.out.println("Jogador 01 pode colocar seus navios no mar");
    inserirNavios(n1, n2, n3, n4, t1);
    System.out.println("Jogador 02 pode colocar seus navios no mar");
    inserirNavios(n1, n2, n3, n4, t2);
    System.out.println("Vamos comaçar o jogo");
    int nl = 0;
    int nc = 0;
    int currentPlayer = 1;
    while (!endGame(t1) | !endGame(t2)) {
    	 System.out.println("Vez do jogador: " + currentPlayer);
      if (currentPlayer == 1) {
        System.out.format("Insira uma linha: ");
        nl = scanner.nextInt();

        System.out.format("Insira uma coluna: ");
        nc = scanner.nextInt();

        System.out.print("\033[H\033[2J");
        System.out.flush();
        disparo(nl, nc, t2);
        t1.showTabuleiro();
        currentPlayer = 2;
      } else {
        System.out.format("Insira uma linha: ");
        nl = scanner.nextInt();

        System.out.format("Insira uma coluna: ");
        nc = scanner.nextInt();

        System.out.print("\033[H\033[2J");
        System.out.flush();
        disparo(nl, nc, t1);
        t2.showTabuleiro();
        currentPlayer = 1;
      }

     }
  }
}