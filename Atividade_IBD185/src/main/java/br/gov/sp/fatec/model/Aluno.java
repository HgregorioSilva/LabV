package br.gov.sp.fatec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="ALN_ALUNO")

public class Aluno {
	
public Aluno(){
		
	}
	
	public Aluno(String nome, String sobrenome, int idade,int semestre,String ra, char sexo){
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.semestre = semestre;
		this.ra = ra;
		this.sexo = sexo;
	}
	
	public void setAluno(String nome, String sobrenome, int idade,int semestre,String ra, char sexo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.semestre = semestre;
		this.ra = ra;
		this.sexo = sexo;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ALN_ID")
	private Long id; 
	
	@Column(name = "ALN_NOME",unique=true, length = 50, nullable = false)
	private String 	nome;
	
	@Column(name = "ALN_SOBRENOME")
	private String sobrenome;
	
	@Column(name = "ALN_IDADE")
	private int idade;
	
	@Column(name = "ALN_SEMESTRE")
	private int semestre;
	
	@Column(name = "ALN_RA")
	private String ra;
	
	@Column(name = "ALN_SEXO")
	private char sexo;
	
	@OneToMany(mappedBy = "aluno")
	private List<Curso> cursosAluno = new ArrayList<Curso>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	

}
