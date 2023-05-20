public class Navio {
  public int linha;
  public int coluna;


  public Navio(int linha, int coluna) {
    this.linha = linha;
    this.coluna = coluna;
  }

  public void inverterNavio(){
    int aux = this.coluna;
    this.coluna = this.linha;
    this.linha = aux;
  }
}
