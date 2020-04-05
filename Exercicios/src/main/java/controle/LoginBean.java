package controle;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.PessoaDAO;
import dao.PessoaDAOImpl;
import entidade.Pessoa;
import util.JpaUtil;



@ManagedBean(name="LoginBean")
@RequestScoped
public class LoginBean {	

	
	private String pessoaAdmin = "admin";
	private String senhaAdmin = "admin";
	
	private String pessoaTXT;
	private String senhaTXT;
	
	private static final String PESQUISAR = "paginas/pessoa/pesquisarPessoa.xhtml"; 
	private PessoaDAO pessoaDAO;
	private String mensagem;
	
	public LoginBean() { 
		this.pessoaDAO = new PessoaDAOImpl(JpaUtil.getEntityManager());
	}
	
		public void entrar() throws IOException {
		if(this.pessoaTXT.equals(this.pessoaAdmin)
		  && this.senhaTXT.equals(this.senhaAdmin)) {
			FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
		}else { 
			Pessoa pessoaPesquisa = this.pessoaDAO.pesquisar(this.pessoaTXT);
			if(pessoaPesquisa != null) {
				if(pessoaPesquisa.getSenha().equals(this.senhaTXT)) {
					FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
				}else {
					this.mensagem = "Senha errada";
				}
			}else {
				this.mensagem = "Nao existe";				
				
			}
			
		}
	}

	public String getPessoaTXT() {
		return pessoaTXT;
	}

	public void setPessoaTXT(String pessoaTXT) {
		this.pessoaTXT = pessoaTXT;
	}

	public String getSenhaTXT() {
		return senhaTXT;
	}

	public void setSenhaTXT(String senhaTXT) {
		this.senhaTXT = senhaTXT;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


}
