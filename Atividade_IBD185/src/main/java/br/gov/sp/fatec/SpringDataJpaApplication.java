package br.gov.sp.fatec;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.repository.CursoRepository;
import br.gov.sp.fatec.repository.AlunoRepository;
import br.gov.sp.fatec.service.CursoService;
import br.gov.sp.fatec.service.AlunoService;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner{
	
	@Autowired
	private AlunoService alunoService;
	private Aluno aluno;
	@Autowired
	private AlunoRepository alunoRep;
	@Autowired
	private CursoRepository cursoRep;
	@Autowired
	private CursoService cursoService;
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
	
	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		/////////////////////////////
		//System.out.println("Encontrou========>");
		//System.out.println(servRep.findByQntip("192.161.1.2"));
		aluno = new Aluno("João","Silva", 25, 4, "2018345",'M');
		//servidorService.incluiServidor(serv);
		//System.out.println("Encontrou========>"+ bancoService.incluiBanco("SQL Server", "Developer", "2017", "8082", "Microsoft","192.161.1.1"));
		Curso curso = new Curso("Banco de dados","Noturno","Estrutura de dados","160 h",aluno);
		//ban.setServidor(new ArrayList<Servidor>());
		//ban.getServidor().add(serv);
		System.out.println("Encontrou========>"+ cursoService.incluiCursoClasse(curso));
		////////////////////////////
		//System.out.println("Encontrou========>"+bancRep.findByDev("Oracle"));
		
		//System.out.println("Encontrou========>"+bancRep.findByPorta("8081"));
		//System.out.println(servRep.findByIp("192.161.1.2")!=null);
		//System.out.println(servidorService.findByNome("192.161.1.1").getIp());
		//System.out.println(servidorService.findById("192.161.1.1").getNome());
		
	}

}
