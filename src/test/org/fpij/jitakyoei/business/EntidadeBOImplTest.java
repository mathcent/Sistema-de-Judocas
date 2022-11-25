package org.fpij.jitakyoei.business;

import org.fpij.jitakyoei.model.beans.Entidade;
import org.fpij.jitakyoei.model.beans.Filiado;
import org.fpij.jitakyoei.util.DatabaseManager;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.GenerateObjects;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EntidadeBOImplTest {

    EntidadeBOImpl entidadeTest = new EntidadeBOImpl(GenerateObjects.generateAppView());

    @BeforeClass
    public static void set(){
        DatabaseManager.setEnviroment(DatabaseManager.TEST);

    }

    @Test
    public void checkCreateEntidade() throws Exception {
        Entidade entidade = GenerateObjects.generateEntidade();
        entidadeTest.createEntidade(entidade);

        List<Entidade> retornoLista = entidadeTest.searchEntidade(entidade);
        Entidade entidadeReceived = retornoLista.get(retornoLista.size()-1);

        assertEquals(entidade.getNome(), entidadeReceived.getNome());
    }

    @Test
    public void checkUpdateEntidade() throws Exception {
        // get last entidade
        Entidade entidade = GenerateObjects.generateEntidade();
        entidadeTest.createEntidade(entidade);

        List<Entidade> retornoLista = entidadeTest.listAll();
        Entidade lastEntidadeInserted = retornoLista.get(0);

        lastEntidadeInserted.setTelefone2("teste");

        // update last Alunp
        entidadeTest.updateEntidade(lastEntidadeInserted);

        // search for the last entidade
        List<Entidade> retorno = entidadeTest.listAll();
        Entidade entidadeReceivedFinal = retorno.get(0);

        assertEquals("teste", entidadeReceivedFinal.getTelefone2());
    }

    @Test
    public void checkUpdateEntidadeIllegalArgumentException() {
        try{
            entidadeTest.updateEntidade(new Entidade());
        } catch (Exception e){
            assertNotNull(e);
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    public void checkUpdateEntidadeException() {
        try{
            entidadeTest.updateEntidade(new Entidade());
        } catch (Exception e){
            assertNotNull(e);
            assertEquals(Exception.class, e.getClass());
        }
    }


    @Test
    public void checkCreateEntidadeException() {
        try {
            entidadeTest.createEntidade(null);
        } catch (Exception e){
            assertNotNull(e);
            assertEquals(Exception.class, e.getClass());
        }
    }

    @Test
    public void checkSearchEntidadeException() {

        try {
            entidadeTest.searchEntidade(null);
        } catch (Exception e){
            assertNotNull(e);
            assertEquals(Exception.class, e.getClass());
        }
    }

}
