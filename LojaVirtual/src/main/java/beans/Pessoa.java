package beans;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="Pessoa") //Declarando a tabela da classe pessoa
public class Pessoa {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //Acho que é para definir parametro unico de identificação
	@Column (name="pes_id")
	private int id;
	@Column (name="pes_nome", length = 60, nullable = true)
	private String nome;
	@Column (name="pes_cpf", length = 14, nullable = true)
	private char cpf;
	@Column (name="pes_rg", length = 20)
	private String rg;
	@Column (name="pes_data_nasc")
	private Date data;
	@Column (name="pes_rua", length = 60)
	private String rua;
	@Column (name="pes_bairro", length = 30)
	private String bairro;
	@Column (name="pes_cidade", length = 30)
	private String cidade;
	@Column (name="pes_uf", length = 2)
	private char uf;
	@Column (name="pes_cep")
	private int cep;
	@Column (name="pes_email", length = 40)
	private String email;
	@Column (name="pes_senha", length = 32)
	private String senha;
	@Column (name="pes_tipo", length = 30)
	private String tipo;
	
	//Relacionamento de 1 para vários
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch=FetchType.EAGER) //cascade significa que quando excluir um pessoa da tabela, todos os telefone também serão excluídos.
	private List<Fone> fones = new ArrayList<Fone>();
	
	
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
	public char getCpf() {
		return cpf;
	}
	public void setCpf(char cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public char getUf() {
		return uf;
	}
	public void setUf(char uf) {
		this.uf = uf;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<Fone> getFones() {
		return fones;
	}
	public void setFones(List<Fone> fones) {
		this.fones = fones;
	}
	
	
	
	
	
}
