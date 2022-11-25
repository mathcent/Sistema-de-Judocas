package org.fpij.jitakyoei.model.beans;

import org.junit.Test;
import utils.GenerateObjects;

import static org.junit.Assert.*;

public class EntidadeTest {
    Entidade entidadeTest = new Entidade();


    @Test
    public void checkNome(){
        String nome = "rua calebao";
        entidadeTest.setNome(nome);
        String nomeRetorno = entidadeTest.getNome();

        assertEquals(nome, nomeRetorno);
    }

    @Test
    public void checkTelefone12(){
        String telefone1 = "rua calebao1";
        String telefone2 = "rua calebao2";

        entidadeTest.setTelefone1(telefone1);
        entidadeTest.setTelefone2(telefone2);

        String telefone1Retorno = entidadeTest.getTelefone1();
        String telefone2Retorno = entidadeTest.getTelefone2();

        assertEquals(telefone1, telefone1Retorno);
        assertEquals(telefone2, telefone2Retorno);
    }

    @Test
    public void checkCnpj(){
        String cnpj = "rua calebao";
        entidadeTest.setCnpj(cnpj);
        String cnpjRetorno = entidadeTest.getCnpj();

        assertEquals(cnpj, cnpjRetorno);
    }

    @Test
    public void checkEndereco(){
        Endereco endereco = GenerateObjects.generateEndereco();
        entidadeTest.setEndereco(endereco);
        Endereco enderecoRetorno = entidadeTest.getEndereco();

        assertEquals(endereco, enderecoRetorno);
    }

    @Test
    public void checkHashAndConstructor(){
        int retorno = entidadeTest.hashCode();

        assertNotNull(retorno);
        assertEquals(entidadeTest.getNome(), entidadeTest.toString());
    }

    @Test
    public void checkEqualsTrue(){
        Entidade entidadeTestCheck = new Entidade();
        entidadeTestCheck.setNome(entidadeTest.getNome());

        boolean retorno = entidadeTest.equals(entidadeTestCheck);

        assertTrue(retorno);
    }

    @Test
    public void checkEqualsFalse(){
        boolean retorno = entidadeTest.equals(GenerateObjects.generateFiliado());

        assertFalse(retorno);
    }

    @Test
    public void checkCopy() {
        Entidade entidadeTestCheck = GenerateObjects.generateEntidade();

        entidadeTest.copyProperties(entidadeTestCheck);

        assertEquals(entidadeTestCheck.getNome(), entidadeTest.getNome());
        assertEquals(entidadeTestCheck.getCnpj(), entidadeTest.getCnpj());
        assertEquals(entidadeTestCheck.getTelefone1(), entidadeTest.getTelefone1());
        assertEquals(entidadeTestCheck.getTelefone2(), entidadeTest.getTelefone2());
        assertEquals(entidadeTestCheck.getEndereco(), entidadeTest.getEndereco());

    }
}
