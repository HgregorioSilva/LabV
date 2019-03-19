package br.gov.sp.fatec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.repository.CursoRepository;
import br.gov.sp.fatec.repository.AlunoRepository;
import br.gov.sp.fatec.service.CursoService;
import br.gov.sp.fatec.service.AlunoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class SpringDataJpa2Test {
	
	private static final String NOME = "João";
	private static final String SOBRENOME = "Silva";
	private static final int IDADE = 28;
	private static final int SEMESTRE = 4;
	private static final String RA = "2020-45";
	private static final char SEXO = 'M';
	
	private static final String NOME_CURSO = "Banco de dados";
	private static final String PERIODO = "Manhã";
	private static final String MATERIA = "Estrutura de dados";
	private static final String DURACAO = "180 horas";
	
	@Autowired
	private AlunoRepository alunoRep;
	@Autowired
	private AlunoService alunoService;
	@Autowired
	private CursoRepository cursoRep;
	@Autowired
	private CursoService cursoService;
	
	public void setAlunoRepo(AlunoRepository aluno) {
		this.alunoRep = aluno;
	}
	
	//Testando o service referente a Servidor, onde faz se a conparação do objeto retornado na inserção dentro de um banco.
		@Test
		public void TestServiceAlunoInsertBD(){
			Aluno aluno1 = new Aluno();
			aluno1.setAluno(NOME, SOBRENOME,IDADE, SEMESTRE, RA, SEXO);
			alunoRep.save(aluno1);
			assertNotEquals(alunoService.incluiAluno(aluno1),null);		
		}
		
		//Teste do reoisitory do Servidor, contemplando a busca de um servidor por IP.
		@Test
		public void TestRepositoryAlunoCosnultaBD(){
			Aluno aluno1 = new Aluno();
			aluno1.setAluno(NOME, SOBRENOME, IDADE, SEMESTRE, RA, SEXO);
			alunoRep.save(aluno1);
			alunoService.incluiAluno(aluno1);
			assertEquals(alunoRep.findByNome(NOME).getId(),RA);		
		}
		
		//Testando o service referente a Banco, retorna um boolan, retornando um true caso contemple as condições de inserção.
		@Test
		public void TestServiceCursoInclusaoConsultaBDDadosRepetidos(){
			Aluno aluno1 = new Aluno();
			aluno1.setAluno(NOME, SOBRENOME, IDADE, SEMESTRE, RA, SEXO);
			Curso cur = new Curso(NOME_CURSO,PERIODO,MATERIA,DURACAO,aluno1);
			cur.setAluno(aluno1);
			//Objeto inserido.
			cursoService.incluiCursoClasse(cur);
			//Impede que haja insercao de dados repetidos em um mesma porta.
			assertFalse(cursoService.incluiCursoClasse(cur));
		}
		
		//Teste do reoisitory do Banco, contemplando a busca de um banco pela Porta.
		@Test
		public void TestRepositoryCursoConsultaBD(){
			Aluno aluno1 = new Aluno();
			aluno1.setAluno(NOME, SOBRENOME, IDADE, SEMESTRE, RA, SEXO );
			Curso cur = new Curso(NOME_CURSO,PERIODO,MATERIA,DURACAO,aluno1);
			cur.setAluno(aluno1);
			cursoService.incluiCursoClasse(cur);
			//assertEquals(cursoRep.findByMateria(MATERIA).getNome(),"Banco de dados");
			//assertEquals(cursoRep.findByDuracao(DURACAO).getNome(),"Banco de dados");
		}
	

}
