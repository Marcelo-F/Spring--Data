package projeto.spring.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projeto.spring.data.model.UsuarioSpringData;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long>{
	
	/*
	 * Métodos como salvar, editar, consultar e excluir já são trazidos pelo framework,
	 *  a chamada por ser vista na classe de teste AppSpringDataTeste
	 * */
	
	
	/*Query condicionais*/
	@Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
	public List<UsuarioSpringData> buscaPOrnome(String nome);
	
	@Query(value = "select p from UsuarioSpringData p where p.nome = :paramnome")
	public UsuarioSpringData buscaPorNomeParam(@Param("paramnome") String paramnome);
	
	
	@Modifying
	@Transactional
	@Query(value= "delete from UsuarioSpringData u where u.nome = ?1")
	public void deletePorNome(String nome);
		
	
	@Modifying
	@Transactional
	@Query("update UsuarioSpringData u set u.email =?1 where u.nome =?2") /*Irá atualizar o email apenas onde o nome for igual o nome for passado por parametro*/
	public void updateEmailPorNome(String email, String nome);
		
		
	
	

}
