package org.fpij.jitakyoei.model.beans;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnderecoTest {
    Endereco enderecoTest = new Endereco();

    @Test
    public void checkRua(){
        String rua = "rua calebao";
        enderecoTest.setRua(rua);
        String ruaRetorno = enderecoTest.getRua();

        assertEquals(rua, ruaRetorno);
    }

    @Test
    public void checkNumero(){
        String numero = "rua calebao";
        enderecoTest.setNumero(numero);
        String numeroRetorno = enderecoTest.getNumero();

        assertEquals(numero, numeroRetorno);
    }

    @Test
    public void checkBairro(){
        String bairro = "rua calebao";
        enderecoTest.setBairro(bairro);
        String bairroRetorno = enderecoTest.getBairro();

        assertEquals(bairro, bairroRetorno);
    }

    @Test
    public void checkCidade(){
        String cidade = "rua calebao";
        enderecoTest.setCidade(cidade);
        String cidadeRetorno = enderecoTest.getCidade();

        assertEquals(cidade, cidadeRetorno);
    }

    @Test
    public void checkEstado(){
        String estado = "rua calebao";
        enderecoTest.setEstado(estado);
        String estadoRetorno = enderecoTest.getEstado();

        assertEquals(estado, estadoRetorno);
    }

    @Test
    public void checkCep(){
        String cep = "rua calebao";
        enderecoTest.setCep(cep);
        String cepRetorno = enderecoTest.getCep();

        assertEquals(cep, cepRetorno);
    }

    @Test
    public void checkToStrin(){
        String testString = "1";
        enderecoTest.setRua(testString);
        enderecoTest.setNumero(testString);
        enderecoTest.setBairro(testString);
        enderecoTest.setCidade(testString);
        enderecoTest.setEstado(testString);
        enderecoTest.setCep(testString);
        String retorno = enderecoTest.toString();

        String expected = "\nRua: 1" +
                "\nNumero: 1"+
                "\nBairro: 1"+
                "\nCidade: 1"+
                "\nEstado: 1"+
                "\nCep: 1";

        assertEquals(expected, retorno);
    }
}
