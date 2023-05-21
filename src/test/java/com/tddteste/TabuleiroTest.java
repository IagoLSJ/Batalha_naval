package com.tddteste;
import static org.junit.Assert.assertNotNull;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TabuleiroTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUp() throws UnsupportedEncodingException {
        PrintStream novoFluxoDeImpressao = new PrintStream(output, true, "UTF-8");
        System.setOut(novoFluxoDeImpressao);
    }
    
    @Test
    public void shouldShowTheTabuleiro()
    {
        Tabuleiro tabuleiroTeste = new Tabuleiro();
        tabuleiroTeste.showTabuleiro();
        assertNotNull(output.toString());
    }
    
    @Test
    public void shouldCreateTabuleiro()
    {
        Tabuleiro tabuleiroTeste = new Tabuleiro();
        assertNotNull(tabuleiroTeste);
    }

    @After
    public void cleanUp()  {
        output.reset();
    }

}