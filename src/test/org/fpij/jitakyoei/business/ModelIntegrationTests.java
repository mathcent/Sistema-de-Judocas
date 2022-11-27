package org.fpij.jitakyoei.business;

import org.fpij.jitakyoei.model.beans.*;
import org.fpij.jitakyoei.model.dao.DAO;
import org.fpij.jitakyoei.model.dao.DAOImpl;
import org.fpij.jitakyoei.util.DatabaseManager;
import org.junit.BeforeClass;

import java.util.Date;

public class ModelIntegrationTests {
	private static DAO<Aluno> alunoDao;
	private static Aluno aluno;
	private static Entidade entidade;
	private static Endereco endereco;
	private static Filiado filiadoAluno;
	private static Filiado filiadoProf;
	private static Professor professor;
	
	@BeforeClass
	public static void setUp(){
		DatabaseManager.setEnviroment(DatabaseManager.TEST);
		filiadoAluno = new Filiado();
		filiadoAluno.setNome("Aluno");
		filiadoAluno.setCpf("012.345.678-90");
		filiadoAluno.setDataNascimento(new Date());
		filiadoAluno.setDataCadastro(new Date());
		filiadoAluno.setId(1332L);
		filiadoAluno.setRg(new Rg("0123456-7", "SSP-PI"));
		
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
		aluno.setFiliado(filiadoAluno);
		aluno.setProfessor(professor);
		aluno.setEntidade(entidade);
		
		alunoDao = new DAOImpl<>(Aluno.class);
	}
	
}
