package projeto.spring.data.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class UsuarioSpringData {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) /*Gera os numeros automaticos da chave primaria, evitando numeros repetidos*/
	private Long id;
	
	private String login;
	
	private String senha;

	private String nome;
	
	
	private String email;
	
	
	private int idade;
	
	@OneToMany(mappedBy ="usuarioSpringData", orphanRemoval = true) /*orphanRemoval  = ao deleltar o cliente referenciado, todos os seus telefones são apagados também*/
	private List<Telefone> telefones;

	
	
	
	
	

	public List<Telefone> getTelefones() {
		return telefones;
	}


	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
			
			
	
	
	
	
	
}
