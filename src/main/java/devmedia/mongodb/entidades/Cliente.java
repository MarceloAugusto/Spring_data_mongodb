package devmedia.mongodb.entidades;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="clientes")
public class Cliente {
	@Id
	private String id;
	@Field("nome") @Indexed
	private String nome;
	@Field("sobrenome")
	private String sobrenome;
	@Field("rg") @Indexed
	private String carteiraIdentidade;
	@Field("cpf") @Indexed
	private String cpf;
	@Field("compras")
	private Set<Produto> compras;

	public String getId() {return this.id;}
	
	public void setId(String valor) {this.id = valor;}
	
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

	public String getCarteiraIdentidade() {
		return carteiraIdentidade;
	}

	public void setCarteiraIdentidade(String carteiraIdentidade) {
		this.carteiraIdentidade = carteiraIdentidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Set<Produto> getCompras() {
		return compras;
	}

	public void setCompras(Set<Produto> compras) {
		this.compras = compras;
	}
	
	
	
}
