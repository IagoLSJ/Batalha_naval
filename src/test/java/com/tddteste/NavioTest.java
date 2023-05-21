package com.tddteste;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class NavioTest {
    
    @Test
    public void shouldCreateNewNavio()
    {
        Navio navioTeste = new Navio(1, 4);
        assertNotNull(navioTeste);
    }

    @Test
    public void shouldNotCreateNewNavioWithWrongValues()
    {
        Navio navioTeste = new Navio(-1, -1);
        boolean testeLinha = true;
        boolean testeColuna = true;
        if(navioTeste.linha < 0 && navioTeste.coluna < 0){
            testeLinha = false;
            testeColuna = false;
        }
        
        assertTrue(testeColuna && testeLinha);
    }

}