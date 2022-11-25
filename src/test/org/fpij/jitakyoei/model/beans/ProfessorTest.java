package org.fpij.jitakyoei.model.beans;

import org.junit.Test;
import utils.GenerateObjects;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProfessorTest {
    Professor professorTest = new Professor();


    @Test
    public void checkFiliado(){
        Filiado filiado = GenerateObjects.generateFiliado();
        professorTest.setFiliado(filiado);
        Filiado filiadoRetorno = professorTest.getFiliado();

        assertEquals(filiado, filiadoRetorno);
    }

    @Test
    public void checkEntidade(){
        Entidade entidade = GenerateObjects.generateEntidade();
        List<Entidade> listEntidade = new ArrayList<>();
        listEntidade.add(entidade);
        listEntidade.add(entidade);

        professorTest.setEntidades(listEntidade);
        List<Entidade> entidadeRetorno = professorTest.getEntidades();

        assertEquals(listEntidade, entidadeRetorno);
    }

    @Test
    public void checkHashAndConstructor(){
        int retorno = professorTest.hashCode();

        assertNotNull(retorno);
        assertEquals(professorTest.getFiliado().nome, professorTest.toString());
    }

    @Test
    public void checkEqualsTrue(){
        Professor professor = new Professor();

        boolean retorno = professorTest.equals(
                professor);

        assertTrue(retorno);
    }

    @Test
    public void checkEqualsFalse(){
        boolean retorno =  professorTest.equals(
                GenerateObjects.generateFiliado());

        assertFalse(retorno);
    }
}
