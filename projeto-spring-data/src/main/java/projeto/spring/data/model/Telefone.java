package projeto.spring.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String tipo;
	private String numero;
	
	/*Relacionamento entre tabelas*/
	@ManyToOne  /*Muitos telefones para um usuáiro*/
	private UsuarioSpringData usuarioSpringData;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public UsuarioSpringData getUsuarioSpringData() {
		return usuarioSpringData;
	}


	public void setUsuarioSpringData(UsuarioSpringData usuarioSpringData) {
		this.usuarioSpringData = usuarioSpringData;
	}
	
	
	

}
