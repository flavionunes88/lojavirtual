package beans;

import javax.persistence.*;

@Entity
@Table (name="Estado") //Declarando a tabela da classe estado
public class Cidade {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column (name="cid_id")
	private int id;
	@Column (name="cid_nome", length = 80, nullable = true)
	private String nome;
	
	@ManyToOne // Define um relacionamento de Muitos para Um
	@JoinColumn(name="est_id") //Define caracteristicas do atributo da tabela quando se utiliza relacionamentos, no caso acima, o atributo que irá conter a chave estrangeira terá o nome de “est_id”
	private End_Estado end_Estado;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public End_Estado getEstado() {
		return end_Estado;
	}

	public void setEstado(End_Estado end_Estado) {
		this.end_Estado = end_Estado;
	}
	
	
}
