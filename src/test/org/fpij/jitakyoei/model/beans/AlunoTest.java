package org.fpij.jitakyoei.model.beans;

import org.fpij.jitakyoei.model.validator.AlunoValidator;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.GenerateObjects;

import static org.junit.Assert.*;

public class AlunoTest {

    Aluno alunoTest = new Aluno();

    @Test
    public void checkFiliado(){
        Filiado filiadoTest = GenerateObjects.generateFiliado();
        alunoTest.setFiliado(filiadoTest);
        Filiado filiadoRetorno = alunoTest.getFiliado();

        assertEquals(filiadoTest, filiadoRetorno);
    }

    @Test
    public void checkEntidade(){
        Entidade entidadeTest = GenerateObjects.generateEntidade();
        alunoTest.setEntidade(entidadeTest);
        Entidade entidadeRetorno = alunoTest.getEntidade();

        assertEquals(entidadeTest, entidadeRetorno);
    }

    @Test
    public void checkProfessor(){
        Professor professorTest = GenerateObjects.generateProfessor();
        alunoTest.setProfessor(professorTest);
        Professor professorRetorno = alunoTest.getProfessor();

        assertEquals(professorTest, professorRetorno);
    }

    @Test
    public void checkEqualsTrue(){
        Aluno alunoTestToCopy = new Aluno();
        Professor professorTest = GenerateObjects.generateProfessor();
        alunoTestToCopy.setProfessor(professorTest);
        Entidade entidadeTest = GenerateObjects.generateEntidade();
        alunoTestToCopy.setEntidade(entidadeTest);
        Filiado filiadoTest = GenerateObjects.generateFiliado();
        alunoTestToCopy.setFiliado(filiadoTest);

        alunoTest.setProfessor(professorTest);
        alunoTest.setEntidade(entidadeTest);
        alunoTest.setFiliado(filiadoTest);

        boolean retornoEquals = alunoTest.equals(alunoTestToCopy);

        assertTrue(retornoEquals);

    }

    @Test
    public void checkEqualsFalse(){
        boolean retornoEquals = alunoTest.equals(GenerateObjects.generateFiliado());

        assertFalse(retornoEquals);

    }

    @Test
    public void checkCopy(){
        Aluno alunoTestToCopy = new Aluno();
        Professor professorTest = GenerateObjects.generateProfessor();
        alunoTestToCopy.setProfessor(professorTest);
        Entidade entidadeTest = GenerateObjects.generateEntidade();
        alunoTestToCopy.setEntidade(entidadeTest);
        Filiado filiadoTest = GenerateObjects.generateFiliado();
        alunoTestToCopy.setFiliado(filiadoTest);

        alunoTest.setProfessor(GenerateObjects.generateProfessor());
        alunoTest.setEntidade(GenerateObjects.generateEntidade());
        alunoTest.setFiliado(GenerateObjects.generateFiliado());

        alunoTest.copyProperties(alunoTestToCopy);

        assertEquals(professorTest, alunoTest.getProfessor());
        assertEquals(entidadeTest, alunoTest.getEntidade());
        assertEquals(filiadoTest, alunoTest.getFiliado());

    }

    @Test
    public void checkHAshCodeAndToString(){
        alunoTest.setProfessor(GenerateObjects.generateProfessor());
        alunoTest.setEntidade(GenerateObjects.generateEntidade());
        alunoTest.setFiliado(GenerateObjects.generateFiliado());

        int retornoHash = alunoTest.hashCode();

        assertNotNull(retornoHash);
        assertNotNull(alunoTest.toString());
    }
}
