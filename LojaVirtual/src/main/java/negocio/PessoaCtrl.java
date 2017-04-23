package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jboss.logging.Messages;

import persistencia.EstadoDAO;
import persistencia.PessoaDAO;
import beans.Cidade;
import beans.End_Estado;
import beans.Fone;
import beans.Pessoa;

@ManagedBean
@SessionScoped
public class PessoaCtrl implements Serializable {

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private Fone fone;
	private End_Estado end_Estado;
	private Cidade cidade;

	private List<End_Estado> end_Estados;
	private List<Cidade> cidades;

	public List<Pessoa> getListagem() {
		return PessoaDAO.listagem("");
	}

	public String actionGravar() {

		if (pessoa.getId() == 0) {
			PessoaDAO.inserir(pessoa);
			return actionInserir();
		} else {
			PessoaDAO.alterar(pessoa);
			return "/pessoa/lista_pessoa";
		}
	}

	public String actionInserir() {

		try {
			pessoa = new Pessoa();
			EstadoDAO estadodao = new EstadoDAO();
			end_Estados = estadodao.listagem();

			return "/pessoa/lista_pessoa";
		} catch (RuntimeException erro) {
            System.out.println("Erro ao tentar criar uma nova pessoa.");
			erro.printStackTrace();
          return null;
		}
	}

	public String actionExcluir() {
		PessoaDAO.excluir(pessoa);
		return "/pessoa/lista_pessoa";
	}

	public String actionAlterar(Pessoa p) {
		pessoa = p;
		return "form_pessoa";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String actionInserirFone() {
		Fone fone = new Fone();
		fone.setPessoa(pessoa);
		pessoa.getFones().add(fone);
		return "form_pessoa";
	}

	public String actionExcluirFone(Fone f) {
		// Os alunos ... pesquisar e codificar

		PessoaDAO.excluirFone(f);
		pessoa.getFones().remove(f);
		return "form_pessoa";
	}

	public Fone getFone() {
		return fone;
	}

	public void setFone(Fone fone) {
		this.fone = fone;
	}

	public End_Estado getEstado() {
		return end_Estado;
	}

	public void setEstado(End_Estado end_Estado) {
		this.end_Estado = end_Estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<End_Estado> getEstados() {
		return end_Estados;
	}

	public void setEstados(List<End_Estado> end_Estados) {
		this.end_Estados = end_Estados;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

}
