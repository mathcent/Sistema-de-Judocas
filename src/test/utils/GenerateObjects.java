package utils;

import org.fpij.jitakyoei.facade.AppFacade;
import org.fpij.jitakyoei.model.beans.*;
import org.fpij.jitakyoei.view.AppView;

import java.util.Date;
import java.util.Random;

public class GenerateObjects {

    public static ProfessorEntidade generateProfessorEntidade() {
        ProfessorEntidade f1 = new ProfessorEntidade(
                GenerateObjects.generateProfessor(),
                GenerateObjects.generateEntidade()
        );

        return f1;
    }

    public static Filiado generateFiliado() {
        Filiado f1 = new Filiado();
        f1.setNome("Aécio");
        f1.setCpf("036.464.453-27");
        f1.setDataNascimento(new Date());
        f1.setDataCadastro(new Date());
        f1.setId(new Random().nextLong());
        f1.setEndereco(GenerateObjects.generateEndereco());
        return f1;
    }

    public static Entidade generateEntidade() {
        Entidade entidade = new Entidade();
        entidade.setEndereco(GenerateObjects.generateEndereco());
        entidade.setNome("Academia 1");
        entidade.setTelefone1("(086)1234-5432");
        return entidade;
    }

    public static Endereco generateEndereco() {
        Endereco endereco = new Endereco();
        endereco.setBairro("Dirceu");
        endereco.setCep("64078-213");
        endereco.setCidade("Teresina");
        endereco.setEstado("PI");
        endereco.setRua("Rua Des. Berilo Mota");
        return endereco;
    }

    public static Professor generateProfessor() {
        Professor professor = new Professor();
        professor.setFiliado(GenerateObjects.generateFiliado());
        return professor;
    }

    public static Aluno generateAluno() {
        Aluno aluno = new Aluno();
        aluno.setFiliado(GenerateObjects.generateFiliado());
        aluno.setProfessor(GenerateObjects.generateProfessor());
        aluno.setEntidade(GenerateObjects.generateEntidade());
        return aluno;
    }

    public static AppView generateAppView(){
        return new AppView() {
            @Override
            public void handleModelChange(Object obj) {

            }

            @Override
            public void displayException(Exception e) {

            }

            @Override
            public void registerFacade(AppFacade facade) {

            }
        };
    }

}
