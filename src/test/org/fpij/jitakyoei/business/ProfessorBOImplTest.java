package org.fpij.jitakyoei.business;

import org.fpij.jitakyoei.model.beans.Filiado;
import org.fpij.jitakyoei.model.beans.Professor;
import org.fpij.jitakyoei.util.DatabaseManager;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.GenerateObjects;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProfessorBOImplTest {

    ProfessorBOImpl professorTest = new ProfessorBOImpl(GenerateObjects.generateAppView());

    @BeforeClass
    public static void set(){
        DatabaseManager.setEnviroment(DatabaseManager.TEST);

    }

    @Test
    public void checkCreateProfessor() throws Exception {
        Professor professor = GenerateObjects.generateProfessor();
        professorTest.createProfessor(professor);

        List<Professor> retornoLista = professorTest.searchProfessor(professor);
        Professor professorReceived = retornoLista.get(retornoLista.size()-1);

        assertEquals(professor.getFiliado().getNome(), professorReceived.getFiliado().getNome());
    }

    @Test
    public void checkUpdateProfessor() throws Exception {
        // get last professor
        Professor professor = GenerateObjects.generateProfessor();
        professorTest.createProfessor(professor);

        List<Professor> retornoLista = professorTest.listAll();
        Professor lastProfessorInserted = retornoLista.get(0);

        Filiado newFiliado = GenerateObjects.generateFiliado();
        lastProfessorInserted.setFiliado(newFiliado);

        // update last Alunp
        professorTest.updateProfessor(lastProfessorInserted);

        // search for the last professor
        List<Professor> retorno = professorTest.listAll();
        Professor professorReceivedFinal = retorno.get(0);

        assertEquals(newFiliado, professorReceivedFinal.getFiliado());
    }

    @Test
    public void checkUpdateProfessorIllegalArgumentException() throws Exception {
        try{
            professorTest.updateProfessor(new Professor());
        } catch (Exception e){
            assertNotNull(e);
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    public void checkUpdateProfessorException() throws Exception {
        try{
            professorTest.updateProfessor(new Professor());
        } catch (Exception e){
            assertNotNull(e);
            assertEquals(Exception.class, e.getClass());
        }
    }


    @Test
    public void checkCreateProfessorException() throws Exception {
        try {
            professorTest.createProfessor(null);
        } catch (Exception e){
            assertNotNull(e);
            assertEquals(Exception.class, e.getClass());
        }
    }

    @Test
    public void checkSearchProfessorException() throws Exception {

        try {
            professorTest.searchProfessor(null);
        } catch (Exception e){
            assertNotNull(e);
            assertEquals(Exception.class, e.getClass());
        }
    }

}
