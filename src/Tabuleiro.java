public class Tabuleiro {
  int tabuleiro[][];

  public Tabuleiro() {
    this.tabuleiro = new int [10][10];
    for(int i =0;i<10;i++){
      for(int j =0; j<10;j++){
        this.tabuleiro[i][j] = 0;
      }
    }
  }

  public void showTabuleiro(){
    for (int i = 0; i <10 ; i++) {
      for (int j = 0; j <10 ; j++) {
          if(this.tabuleiro[i][j]==1){
            System.out.print(" N ");
          }else if(this.tabuleiro[i][j] == 2){
            System.out.print(" X ");
          }else {
            System.out.print(" M ");
          }
      }
      System.out.println();
    }
  }  
}
