package com.tddteste;

public class Navio {
    public int linha = 0;
    public int coluna = 0;
  
    public Navio(int linha, int coluna) {
      if((linha > 0 && coluna > 0)){
        this.linha = linha;
        this.coluna = coluna;
      }
    }
  
    public void inverterNavio(){
      int aux = this.coluna;
      this.coluna = this.linha;
      this.linha = aux;
    }
  }