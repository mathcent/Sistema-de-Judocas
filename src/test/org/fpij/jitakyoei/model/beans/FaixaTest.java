package org.fpij.jitakyoei.model.beans;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FaixaTest {
    Faixa faixaTest = new Faixa();

    @Test
    public void checkCor(){
        CorFaixa corFaixa = CorFaixa.AZUL;
        faixaTest.setCor(corFaixa);
        CorFaixa corRetorno = faixaTest.getCor();

        assertEquals(corFaixa, corRetorno);
    }

    @Test
    public void checkData(){
        Date data = new Date();
        faixaTest.setDataEntrega(data);
        Date dataRetorno = faixaTest.getDataEntrega();

        assertEquals(data, dataRetorno);
    }

    @Test
    public void checkConstructorAndToString(){
        Date data = new Date();
        CorFaixa corFaixa = CorFaixa.AZUL;

        Faixa faixaTest = new Faixa(corFaixa, data);

        String expected = corFaixa + " - " + data;

        assertEquals(expected, faixaTest.toString());
    }
}
