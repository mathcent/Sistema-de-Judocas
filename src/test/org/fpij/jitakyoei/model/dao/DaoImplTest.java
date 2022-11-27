package org.fpij.jitakyoei.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.fpij.jitakyoei.model.beans.Aluno;
import org.fpij.jitakyoei.model.beans.Endereco;
import org.fpij.jitakyoei.model.beans.Entidade;
import org.fpij.jitakyoei.model.beans.Filiado;
import org.fpij.jitakyoei.model.beans.Professor;
import org.fpij.jitakyoei.model.validator.AlunoValidator;
import org.fpij.jitakyoei.model.validator.Validator;
import org.fpij.jitakyoei.util.DatabaseManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.GenerateObjects;

public class DaoImplTest {
	
	private static DAO<Aluno> alunoDao;
	private static Aluno aluno;
	private static Entidade entidade;
	private static Endereco endereco;
	private static Filiado f1;
	private static Filiado filiadoProf;
	private static Professor professor;
	
	@BeforeClass
	public static void setUp(){
		DatabaseManager.setEnviroment(DatabaseManager.TEST);
		f1 = new Filiado();
		f1.setNome("Aluno");
		f1.setCpf("012.345.678-90");
		f1.setDataNascimento(new Date());
		f1.setDataCadastro(new Date());
		f1.setId(1332L);
		
		endereco = new Endereco();
		endereco.setBairro("Bairro");
		endereco.setCep("01234-567");
		endereco.setCidade("Cidade");
		endereco.setEstado("ES");
		endereco.setRua("Rua da FEI");
		
		filiadoProf = new Filiado();
		filiadoProf.setNome("Professor");
		filiadoProf.setCpf("132.456.789-00");
		filiadoProf.setDataNascimento(new Date());
		filiadoProf.setDataCadastro(new Date());
		filiadoProf.setId(3332L);
		filiadoProf.setEndereco(endereco);
		
		professor = new Professor();
		professor.setFiliado(filiadoProf);
		
		entidade = new Entidade();
		entidade.setEndereco(endereco);
		entidade.setNome("Entidade");
		entidade.setTelefone1("(011)1234-5678");
		
		aluno = new Aluno();
		aluno.setFiliado(f1);
		aluno.setProfessor(professor);
		aluno.setEntidade(entidade);
		
		alunoDao = new DAOImpl<Aluno>(Aluno.class);
	}

	public static void clearDatabase(){
		List<Aluno> all = alunoDao.list();
		for (Aluno each : all) {
			alunoDao.delete(each);
		}
		assertEquals(0, alunoDao.list().size());
	}

	// check differents constructors
	@Test
	public void checkConstructorWithUseEquals(){
		DAO<Aluno> alunoDao = new DAOImpl<Aluno>(Aluno.class, false );

		assertNotNull(alunoDao);
	}

	@Test
	public void checkConstructorWithUseEqualsAndValidatorCustom(){

		DAO<Aluno> alunoDao = new DAOImpl<Aluno>(
				Aluno.class,
				new AlunoValidator(),
				false);

		assertNotNull(alunoDao);
	}

	// test save function
	@Test
	public void  testSalvarAlunoComAssociassoes() throws Exception{
		clearDatabase();

		boolean returnReceived = alunoDao.save(aluno);
		assertEquals("012.345.678-90", alunoDao.get(aluno).getFiliado().getCpf());
		assertEquals("Aluno", alunoDao.get(aluno).getFiliado().getNome());
		assertEquals("Professor", alunoDao.get(aluno).getProfessor().getFiliado().getNome());
		assertEquals("Bairro", alunoDao.get(aluno).getProfessor().getFiliado().getEndereco().getBairro());
		assertEquals(true, returnReceived);

	}

	@Test
	public void  testSalvarAlunoComErroValidacao(){
		clearDatabase();

		class CustomValidator<T> implements Validator<T> {
			@Override
			public boolean validate(T obj) {
				return false;
			}
		}

		DAO<Aluno> alunoDao = new DAOImpl<Aluno>(
				Aluno.class,
				new CustomValidator<Aluno>(),
				false);


		boolean returnReceived = alunoDao.save(aluno);
		assertEquals(false, returnReceived);

	}

	
	@Test
	public void updateAluno() throws Exception{
		clearDatabase();
		assertEquals(0, alunoDao.list().size());
		
		alunoDao.save(aluno);
		assertEquals(1, alunoDao.list().size());
		assertEquals("Aluno", aluno.getFiliado().getNome());
		
		Aluno a1 = alunoDao.get(aluno);
		a1.getFiliado().setNome("Teste1");
		alunoDao.save(a1);
		
		Aluno a2 = alunoDao.get(a1);
		assertEquals("Teste1", a2.getFiliado().getNome());
		assertEquals(1, alunoDao.list().size());
	}

	// test list functions
	@Test
	public void testgetAlunosWithUseEquals(){
		int qtd = alunoDao.list().size();

		DAO<Aluno> alunoDaoTest = new DAOImpl<>(Aluno.class, true);

		alunoDaoTest.save(aluno);
		assertEquals(qtd+1, alunoDaoTest.list().size());


		Aluno retornoAluno = alunoDaoTest.get(aluno);

		assertEquals(aluno, retornoAluno);
	}

	@Test
	public void testGetAlunosWithUseEqualsAndEmpty(){
		DAO<Aluno> alunoDaoTest = new DAOImpl<>(Aluno.class, true);

		try {
			Aluno retornoAluno = alunoDaoTest.get(aluno);
		} catch (Exception e){
			assertNotNull(e);
			assertEquals(e.getClass(), IllegalArgumentException.class);

		}
	}

	// test get function

	@Test
	public void testListarEAdicionarAlunos(){
		int qtd = alunoDao.list().size();

		alunoDao.save(GenerateObjects.generateAluno());
		assertEquals(qtd + 1, alunoDao.list().size());

		alunoDao.save(GenerateObjects.generateAluno());
		assertEquals(qtd + 2, alunoDao.list().size());

		alunoDao.save(GenerateObjects.generateAluno());
		assertEquals(qtd + 3, alunoDao.list().size());

		alunoDao.save(GenerateObjects.generateAluno());
		assertEquals(qtd + 4, alunoDao.list().size());

		clearDatabase();
		assertEquals(0, alunoDao.list().size());

		alunoDao.save(GenerateObjects.generateAluno());
		assertEquals(1, alunoDao.list().size());
	}
	@Test
	public void testSearchAluno() throws Exception{
		clearDatabase();
		alunoDao.save(aluno);
		
		Filiado f = new Filiado();
		f.setNome("Aluno");
		Aluno a = new Aluno();
		a.setFiliado(f);
		
		List<Aluno> result = alunoDao.search(a);
		assertEquals(1, result.size());
		assertEquals("012.345.678-90", result.get(0).getFiliado().getCpf());
		
		clearDatabase();
		assertEquals(0, alunoDao.search(a).size());
	}
	
	@AfterClass
	public static void closeDatabase(){
		clearDatabase();
		DatabaseManager.close();
	}
	
}
