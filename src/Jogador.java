import java.util.HashMap;
import java.util.Map;

public class Jogador {
  public String nome;
  public Tabuleiro tabuleiro;
  public Map<Integer, Navio> navios = new HashMap<Integer, Navio>(0);


  public Jogador(String nome) {
    this.nome = nome;
    this.tabuleiro = new Tabuleiro();
    this.navios.put(1, new Navio(1, 4));
    this.navios.put(2, new Navio(1, 1));
    this.navios.put(3, new Navio(1, 2));
    this.navios.put(4, new Navio(1, 2));
    this.navios.put(5, new Navio(1, 3));
    this.navios.put(6, new Navio(1, 3));
  }

}
