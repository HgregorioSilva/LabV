package br.gov.sp.fatec.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "CUR_CURSO")

public class Curso {
	
	public Curso(){
	}
	

	public Curso( String nome, String periodo, String materia, String duracao, Aluno aluno) {
		this.nome = nome;
		this.periodo = periodo;
		this.materia = materia;
		this.duracao = duracao;
		this.aluno = aluno;
	}
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CUR_ID")
	private Long id;
	
	@Column(name = "CUR_NOME")
	private String nome;
	
	@Column(name = "CUR_PERIODO")
	private String periodo;
	
	@Column(name = "CUR_MATERIA")
	private String materia;
	
	@Column(name = "CUR_DURACAO")
	private String duracao;
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "ALN_ID") 
			
			
	private Aluno aluno;
			
	

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

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setPorta(String duracao) {
		this.duracao = duracao;
	}


	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
	
	
	
	
	

}
