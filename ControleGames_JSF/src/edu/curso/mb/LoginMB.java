package edu.curso.mb;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.curso.dao.LoginDAO;
import edu.curso.dao.LoginDAOImpl;
import edu.curso.entidade.Login;

@ManagedBean
@SessionScoped
public class LoginMB {

	private Login loginAtual;
	private String mensagem;
	private boolean logado;
	private LoginDAO lDao;
	private List<Login> logins;

	public LoginMB() {
		loginAtual = new Login();
		lDao = new LoginDAOImpl();

	}

	public void gravar() throws IOException {

		try {
			lDao.gravar(loginAtual);
			setmensagem("Gravado com sucesso");
			loginAtual = new Login();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualizar() {
		try {
			lDao.atualizar(loginAtual);
			setmensagem("Atualizado com sucesso");
			loginAtual = new Login();
			pesquisarTodos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// public void pesquisar(){
	// try {
	// logins = lDao.pesquisarTodos(); // chmar pesquisar todos e joga em uma
	// lista
	// int tamanho = logins.size() - 1; // pega o tamanho da lista - 1 pra fazer
	// a busca da pesquisa
	// while (tamanho >= 0)
	// {
	//
	// if(loginAtual.getNome().equals(logins.get(tamanho).getNome()) ) // se for
	// encontrado o nome na lista, diminui o tamanho da variavel tamanho
	// {
	// tamanho --;
	// }
	// else
	// {
	// logins.remove(tamanho); // se não for encontrado na lista, remove o campo
	// da lista na posição tamanho
	// tamanho --;
	//
	// }
	//
	// }
	// if(logins.size() > 0)
	// {
	// setmensagem("Login localizado"); //se sobrar algo na lista, informa login
	// localizado
	// }
	// else
	// {
	// setmensagem("Login não localizado");
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//

	public void pesquisarTodos() {
		try {
			logins = lDao.pesquisarTodos();
			setmensagem("Pesquisa Concluida");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String carregar(Login l) {
		loginAtual = l;
		return "";
	}

	 public String remover(){
	 try {
	 lDao.remover(loginAtual);
	 pesquisarTodos(); 
	 setmensagem("Remoção Concluída");
	 } catch (SQLException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 return "";
	 }

	public String login() throws SQLException {
		boolean login = lDao.logar(loginAtual.getNome(), loginAtual.getSenha());
		if (login == true) {
			setLogado(true);
			// setmensagem("Logado com sucesso");
			return "home";
		} else {
			setLogado(false);
			setmensagem("Login não localizado");
			return "login";
		}

	}

	public String logout() {		
//		boolean login = lDao.logar(loginAtual.getNome(), loginAtual.getSenha());
//		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login";
	}

	public Login getLoginAtual() {
		return loginAtual;
	}

	public void setLoginAtual(Login loginAtual) {
		this.loginAtual = loginAtual;
	}

	public String getmensagem() {
		return mensagem;
	}

	public void setmensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public LoginDAO getlDao() {
		return lDao;
	}

	public void setlDao(LoginDAO lDao) {
		this.lDao = lDao;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public List<Login> getLogins() {
		return logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

}
