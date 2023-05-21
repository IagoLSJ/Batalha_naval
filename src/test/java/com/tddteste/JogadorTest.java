package com.tddteste;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JogadorTest {
    @Test
    public void shouldCreateNewJogador()
    {
        Jogador jogadorTeste = new Jogador("Joao");
        assertNotNull(jogadorTeste);
        
    }

    @Test
    public void shouldNotCreateNewJogadorWithEmptyName()
    {
        Jogador jogadorTeste = new Jogador("");
        boolean teste = true;
        if(jogadorTeste.nome == ""){
            teste = false;
        }
        assertTrue(teste);
        
    }

    @Test
    public void shouldNotCreateNewJogadorWithWrongName()
    {
        Jogador jogadorTeste = new Jogador("/$%@#$%¨%$#");
        boolean teste = true;
        if(jogadorTeste.nome == "/$%@#$%¨%$#"){
            teste = false;
        }
        assertTrue(teste);
        
    }
}
