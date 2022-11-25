package org.fpij.jitakyoei.model.beans;

import org.junit.Test;
import utils.GenerateObjects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class FiliadoTest {
    Filiado filiadoTest = new Filiado();


    @Test
    public void checkId(){
        Long id = 1L;
        filiadoTest.setId(id);
        Long idRetorno = filiadoTest.getId();

        assertEquals(id, idRetorno);
    }

    @Test
    public void checkNome(){
        String nome = "rua calebao";
        filiadoTest.setNome(nome);
        String nomeRetorno = filiadoTest.getNome();

        assertEquals(nome, nomeRetorno);
    }

    @Test
    public void checkCnpj(){
        String cnpj = "rua calebao";
        filiadoTest.setRegistroCbj(cnpj);
        String cnpjRetorno = filiadoTest.getRegistroCbj();

        assertEquals(cnpj, cnpjRetorno);
    }

    @Test
    public void checkDataNascimento(){
        Date data = new Date();
        filiadoTest.setDataNascimento(data);
        Date dataRetorno = filiadoTest.getDataNascimento();

        assertEquals(data, dataRetorno);
    }

    @Test
    public void checkDataCadastro(){
        Date data = new Date();
        filiadoTest.setDataCadastro(data);
        Date dataRetorno = filiadoTest.getDataCadastro();

        assertEquals(data, dataRetorno);
    }


    @Test
    public void checkRg(){
        Rg rg = new Rg("test", "test");
        filiadoTest.setRg(rg);
        Rg rgRetorno = filiadoTest.getRg();

        assertEquals(rg, rgRetorno);
    }

    @Test
    public void checkFaixas(){
        Faixa faixa = new Faixa();
        List<Faixa> listFaixas = new ArrayList<>();
        listFaixas.add(faixa);

        filiadoTest.setFaixas(listFaixas);
        List<Faixa> listFaixasRetorno = filiadoTest.getFaixas();

        assertEquals(listFaixas, listFaixasRetorno);
    }

    @Test
    public void checkTelefone12(){
        String telefone1 = "rua calebao1";
        String telefone2 = "rua calebao2";

        filiadoTest.setTelefone1(telefone1);
        filiadoTest.setTelefone2(telefone2);

        String telefone1Retorno = filiadoTest.getTelefone1();
        String telefone2Retorno = filiadoTest.getTelefone2();

        assertEquals(telefone1, telefone1Retorno);
        assertEquals(telefone2, telefone2Retorno);
    }

    @Test
    public void checkEmail(){
        String email = "calebao";
        filiadoTest.setEmail(email);
        String emailRetorno = filiadoTest.getEmail();

        assertEquals(email, emailRetorno);
    }

    @Test
    public void checkCpf(){
        String cnpj = "rua calebao";
        filiadoTest.setCpf(cnpj);
        String cnpjRetorno = filiadoTest.getCpf();

        assertEquals(cnpj, cnpjRetorno);
    }

    @Test
    public void checkObservacoes(){
        String cnpj = "rua calebao";
        filiadoTest.setObservacoes(cnpj);
        String cnpjRetorno = filiadoTest.getObservacoes();

        assertEquals(cnpj, cnpjRetorno);
    }


    @Test
    public void checkEndereco(){
        Endereco endereco = GenerateObjects.generateEndereco();
        filiadoTest.setEndereco(endereco);
        Endereco enderecoRetorno = filiadoTest.getEndereco();

        assertEquals(endereco, enderecoRetorno);
    }

    @Test
    public void checkHashAndConstructor(){
        filiadoTest.setId(2L);
        int retorno = filiadoTest.hashCode();

        assertNotNull(retorno);
    }

    @Test
    public void checkEqualsTrue(){
        filiadoTest.setId(2L);
        filiadoTest.setNome("teste");
        Filiado filiadoTestCheck = new Filiado();
        filiadoTestCheck.setNome(filiadoTest.getNome());
        filiadoTestCheck.setId(filiadoTest.getId());

        boolean retorno = filiadoTest.equals(filiadoTestCheck);

        assertTrue(retorno);
    }

    @Test
    public void checkEqualsFalse(){
        boolean retorno = filiadoTest.equals(GenerateObjects.generateAluno());

        assertFalse(retorno);
    }
}
