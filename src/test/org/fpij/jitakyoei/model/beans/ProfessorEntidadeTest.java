package org.fpij.jitakyoei.model.beans;

import org.junit.Test;
import utils.GenerateObjects;

import static org.junit.Assert.*;

public class ProfessorEntidadeTest {
    ProfessorEntidade professorEntidadeTest = new ProfessorEntidade(
            GenerateObjects.generateProfessor(),
            GenerateObjects.generateEntidade()
    );


    @Test
    public void checkProfessor(){
        Professor professor = GenerateObjects.generateProfessor();
        professorEntidadeTest.setProfessor(professor);
        Professor professorRetorno = professorEntidadeTest.getProfessor();

        assertEquals(professor, professorRetorno);
    }

    @Test
    public void checkEntidade(){
        Entidade entidade = GenerateObjects.generateEntidade();
        professorEntidadeTest.setEntidade(entidade);
        Entidade entidadeRetorno = professorEntidadeTest.getEntidade();

        assertEquals(entidade, entidadeRetorno);
    }

    @Test
    public void checkHashAndConstructor(){
        int retorno = professorEntidadeTest.hashCode();

        assertNotNull(retorno);
    }

    @Test
    public void checkEqualsTrue(){
        ProfessorEntidade professorEntidade = new ProfessorEntidade(
                professorEntidadeTest.getProfessor(),
                professorEntidadeTest.getEntidade());

        boolean retorno = professorEntidadeTest.equals(
                professorEntidade);

        assertTrue(retorno);
    }

    @Test
    public void checkEqualsFalse(){
        boolean retorno =  professorEntidadeTest.equals(
                GenerateObjects.generateFiliado());

        assertFalse(retorno);
    }
}
