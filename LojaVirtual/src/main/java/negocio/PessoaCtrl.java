package negocio;


import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.postgresql.jdbc2.EscapedFunctions;

import persistencia.PessoaDAO;
import beans.Cidade;
import beans.Estado;
import beans.Fone;
import beans.Pessoa;

@ManagedBean
@SessionScoped
public class PessoaCtrl implements Serializable {

	private static final long serialVersionUID = 1L;
		private Pessoa pessoa;
		private Fone fone;
		private Estado uf;
		
		private List<Estado> estado;
		private List<Cidade> cidade;
		
		public List<Pessoa> getListagem(){
			return PessoaDAO.listagem("");
		}
		
		public String actionGravar(){
			
			if(pessoa.getId() == 0){
				PessoaDAO.inserir(pessoa);
				return actionInserir();
			}else{
				PessoaDAO.alterar(pessoa);
				return "/pessoa/lista_pessoa";
			}		
		}
		
		public String actionInserir(){
			pessoa = new Pessoa();
			return "/pessoa/lista_pessoa";
		}
		
		public String actionExcluir(){
			PessoaDAO.excluir(pessoa);
			return "/pessoa/lista_pessoa";
		}
		
		public String actionAlterar(Pessoa p){
			pessoa = p;
			return "form_pessoa";
		}
		
		public Pessoa getPessoa() {
			return pessoa;
		}
		public void setPessoa(Pessoa pessoa) {
			this.pessoa = pessoa;
		}
		
		public String actionInserirFone(){
			Fone fone = new Fone();
			fone.setPessoa(pessoa);
			pessoa.getFones().add(fone);
			return "form_pessoa";
		}
		public String actionExcluirFone(Fone f){
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

		public Estado getUf() {
			return uf;
		}

		public void setUf(Estado uf) {
			this.uf = uf;
		}

		public List<Estado> getEstado() {
			return estado;
		}

		public void setEstado(List<Estado> estado) {
			this.estado = estado;
		}

		public List<Cidade> getCidade() {
			return cidade;
		}

		public void setCidade(List<Cidade> cidade) {
			this.cidade = cidade;
		}


	}
