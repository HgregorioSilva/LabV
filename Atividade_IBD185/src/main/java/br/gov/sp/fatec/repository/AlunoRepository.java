package br.gov.sp.fatec.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.model.Aluno;


public interface AlunoRepository extends CrudRepository<Aluno,Long>{
	
	public Aluno findByNome1(String nome);
	
	@Query("select s from Aluno s where s.nome like ?1")
	public Aluno findByNome(@Param(":nome") String nome);
	
	@Query("select count(*) from Aluno s where s.nome like ?1")
	public String findByQntnome(@Param(":nome") String nome);


}
