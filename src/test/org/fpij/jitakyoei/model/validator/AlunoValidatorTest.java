package org.fpij.jitakyoei.model.validator;

import org.fpij.jitakyoei.model.beans.Aluno;
import org.fpij.jitakyoei.model.dao.DAO;
import org.fpij.jitakyoei.model.dao.DAOImpl;
import org.junit.Test;
import utils.GenerateObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AlunoValidatorTest {

    AlunoValidator alunoValidatorTest = new AlunoValidator();

    @Test
    public void checkgetValidate(){

        boolean retornoGetValidate = this.alunoValidatorTest.validate(GenerateObjects.generateAluno());

        assertEquals(true, retornoGetValidate);
    }
}
