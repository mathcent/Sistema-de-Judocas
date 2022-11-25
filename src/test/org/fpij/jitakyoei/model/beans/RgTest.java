package org.fpij.jitakyoei.model.beans;

import org.junit.Test;
import utils.GenerateObjects;

import static org.junit.Assert.*;

public class RgTest {
    Rg rgTest = new Rg();


    @Test
    public void checkNumero(){
        String numero = "rua calebao";
        rgTest.setNumero(numero);
        String numeroRetorno = rgTest.getNumero();

        assertEquals(numero, numeroRetorno);
    }

    @Test
    public void checkOrgao(){
        String orgao = "rua calebao";
        rgTest.setOrgaoExpedidor(orgao);
        String orgaoRetorno = rgTest.getOrgaoExpedidor();

        assertEquals(orgao, orgaoRetorno);
    }

    @Test
    public void checkHashAndConstructor(){
        String testString = "1";
        Rg rgTest = new Rg(testString, testString);

        int retorno = rgTest.hashCode();

        assertNotNull(retorno);
    }

    @Test
    public void checkEqualsTrue(){
        String testString = "1";
        Rg rgTest = new Rg(testString, testString);

        boolean retorno = rgTest.equals(new Rg(testString, testString));

        assertTrue(retorno);
    }

    @Test
    public void checkEqualsFalse(){
        String testString = "1";
        Rg rgTest = new Rg(testString, testString);

        boolean retorno = rgTest.equals(GenerateObjects.generateFiliado());

        assertFalse(retorno);
    }
}
