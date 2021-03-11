package projeto.spring.data;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.dao.InterfaceSpringDataUser;
import projeto.spring.data.dao.InterfaceTelefone;
import projeto.spring.data.model.Telefone;
import projeto.spring.data.model.UsuarioSpringData;

import org.springframework.beans.factory.annotation.Autowired;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTeste {
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	@Autowired
	private InterfaceTelefone interfaceTelefone;
	
	
	
	
	
	@Test
	public void testeInsert() {
		System.out.println("Spring com Sucesso");	
		
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("teste@hotmail.com");
		usuarioSpringData.setLogin("admin");
		usuarioSpringData.setSenha("123");
		usuarioSpringData.setNome("Me deleta");
		usuarioSpringData.setIdade(1);
		
		interfaceSpringDataUser.save(usuarioSpringData);
		
		System.out.println("Usuarios cadastrados ->> " +interfaceSpringDataUser.count() );
	}
	
	
	@Test
	public void testeConsultar() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		System.out.println("Email: " +usuarioSpringData.get().getEmail());
		System.out.println("IDade: "+ usuarioSpringData.get().getIdade());
		System.out.println("Login: " + usuarioSpringData.get().getLogin());
		System.out.println("Nome: " + usuarioSpringData.get().getNome());
		System.out.println("Senha: " +usuarioSpringData.get().getSenha());
		System.out.println("Id: " + usuarioSpringData.get().getId());		
	}
	
	
	
	@Test
	public void testeConsultaTodos() {
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			
			System.out.println("Email: " +usuarioSpringData.getEmail());
			System.out.println("IDade: "+ usuarioSpringData.getIdade());
			System.out.println("Login: " + usuarioSpringData.getLogin());
			System.out.println("Nome: " + usuarioSpringData.getNome());
			System.out.println("Senha: " +usuarioSpringData.getSenha());
			System.out.println("Id: " + usuarioSpringData.getId());	
			System.out.println("------------------------------------------");
			
		}
		
		
	}
	
	
	@Test
	public void atualizacadastro() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		UsuarioSpringData data = usuarioSpringData.get();
		data.setNome("NovoNome");
		interfaceSpringDataUser.save(data);
	}
	
	
	
	
	@Test 
	public void testeDelete() {
		
		interfaceSpringDataUser.deleteById(3L);
		
		
	}
	@Test
	public void testeConsultaNOme() {/*Traz resultado que contem o nome passado */
		
		List<UsuarioSpringData> list = interfaceSpringDataUser.buscaPOrnome("Mendoça");
		
		
			for (UsuarioSpringData usuarioSpringData : list) {
			
			System.out.println("Email: " +usuarioSpringData.getEmail());
			System.out.println("IDade: "+ usuarioSpringData.getIdade());
			System.out.println("Login: " + usuarioSpringData.getLogin());
			System.out.println("Nome: " + usuarioSpringData.getNome());
			System.out.println("Senha: " +usuarioSpringData.getSenha());
			System.out.println("Id: " + usuarioSpringData.getId());	
			System.out.println("------------------------------------------");
			
		}
		
		
		
	}
	
	
	
	
	@Test
	public void testeConsultaNOmeParam() { /*Traz o nome  exato que esta sendo passado por parametro*/
		
		UsuarioSpringData usuarioSpringData= interfaceSpringDataUser.buscaPorNomeParam("NovoNome");
		
		
			
			System.out.println("Email: " +usuarioSpringData.getEmail());
			System.out.println("IDade: "+ usuarioSpringData.getIdade());
			System.out.println("Login: " + usuarioSpringData.getLogin());
			System.out.println("Nome: " + usuarioSpringData.getNome());
			System.out.println("Senha: " +usuarioSpringData.getSenha());
			System.out.println("Id: " + usuarioSpringData.getId());	
			System.out.println("------------------------------------------");
			
		
		
		
		
	}
	
	@Test
	public void testeDeletePorNome() {
		interfaceSpringDataUser.deletePorNome("Me deleta");
	}
	
	
	@Test
	public void testeUpdateEmailPorNome() {
		interfaceSpringDataUser.updateEmailPorNome("novoemail@hotmail.com", "Mendoça");
		
		
		
	}
	
	
	@Test
	public void testeInserteTelefone() {
		Optional<UsuarioSpringData> usuarioSpringData =  interfaceSpringDataUser.findById(1L); /*Consulta os dados do cliente*/
		Telefone telefone = new Telefone();
		
		telefone.setNumero("3515153153");
		telefone.setTipo("Casa");
		telefone.setUsuarioSpringData(usuarioSpringData.get()); 
		interfaceTelefone.save(telefone);
		
		
	}
	
	
	
}
