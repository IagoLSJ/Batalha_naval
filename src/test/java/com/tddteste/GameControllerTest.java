package com.tddteste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameControllerTest {
    
    @Test
    public void shouldValidateAsTrue()
    {
        GameController gameTeste = new GameController();
        boolean teste = gameTeste.validacao(5, 5);
        assertTrue(teste);
    }

    @Test
    public void shouldNotValidateAsTrue()
    {
        GameController gameTeste = new GameController();
        boolean teste = gameTeste.validacao(10, 10);
        assertFalse(teste);
    }

    @Test
    public void shouldInsertTheNavio()
    {
        GameController gameTeste = new GameController();
        Navio navioTeste = new Navio(1, 4);
        Tabuleiro tabuleiroTeste = new Tabuleiro();
        boolean teste = gameTeste.insert(5, 5, navioTeste, tabuleiroTeste);
        assertTrue(teste);
    }

    @Test
    public void shouldNotInsertTheNavio()
    {
        GameController gameTeste = new GameController();
        Navio navioTeste = new Navio(1, 4);
        Tabuleiro tabuleiroTeste = new Tabuleiro();
        boolean teste = gameTeste.insert(10, 10, navioTeste, tabuleiroTeste);
        assertFalse(teste);
    }

    @Test
    public void shouldNotInsertWithNullNavio()
    {
        GameController gameTeste = new GameController();
        Navio navioTeste = new Navio(1, 7);
        Tabuleiro tabuleiroTeste = new Tabuleiro();
        boolean teste = gameTeste.insert(9, 9, navioTeste, tabuleiroTeste);
        assertFalse(teste);
    }

    @Test
    public void shouldNotInsertNavioOverOther()
    {
        GameController gameTeste = new GameController();
        Navio navioTeste = new Navio(1, 7);
        Tabuleiro tabuleiroTeste = new Tabuleiro();
        gameTeste.insert(0, 0, navioTeste, tabuleiroTeste);
        boolean teste = gameTeste.insert(0, 0, navioTeste, tabuleiroTeste);
        assertFalse(teste);
    }

    @Test
    public void shouldExecuteDisparo()
    {
        GameController gameTeste = new GameController();
        Tabuleiro tabuleiroTeste = new Tabuleiro();
        tabuleiroTeste.tabuleiro[0][0] = 1;
        boolean teste = gameTeste.disparo(0, 0, tabuleiroTeste);
        assertTrue(teste);
    }

    @Test
    public void shouldNotExecuteDisparo()
    {
        GameController gameTeste = new GameController();
        Tabuleiro tabuleiroTeste = new Tabuleiro();
        tabuleiroTeste.tabuleiro[0][0] = 1;
        boolean teste = gameTeste.disparo(20, 20, tabuleiroTeste);
        assertFalse(teste);
    }

    @Test
    public void shouldWinTheGame()
    {
        GameController gameTeste = new GameController();
        Tabuleiro tabuleiroTeste = new Tabuleiro();
        boolean teste = gameTeste.endGame(tabuleiroTeste, "Joao");
        assertTrue(teste);
    }

    @Test
    public void shouldNotWinTheGame()
    {
        GameController gameTeste = new GameController();
        Tabuleiro tabuleiroTeste = new Tabuleiro();
        tabuleiroTeste.tabuleiro[0][0] = 1;
        boolean teste = gameTeste.endGame(tabuleiroTeste, "Joao");
        assertFalse(teste);
    }

    

}
