package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.farmacia.DAO.ImoveisDAO;
import br.com.farmacia.DAO.InquilinosDAO;
import br.com.farmacia.domain.Imoveis;
import br.com.farmacia.domain.Inquilinos;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "MBInquilinos")
@ViewScoped
public class InquilinosBean {
	private Inquilinos inquilinos;
	private ArrayList<Inquilinos>itens;
	private ArrayList<Inquilinos>itensFiltrados;
	private ArrayList<Imoveis>comboImoveis;
	
	public Inquilinos getInquilinos() {
		return inquilinos;
	}
	public void setInquilinos(Inquilinos inquilinos) {
		this.inquilinos = inquilinos;
	}
	public ArrayList<Imoveis> getComboImoveis() {
		return comboImoveis;
	}
	public void setComboImoveis(ArrayList<Imoveis> comboImoveis) {
		this.comboImoveis = comboImoveis;
	}
	public ArrayList<Inquilinos> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Inquilinos> itens) {
		this.itens = itens;
	}
	public ArrayList<Inquilinos> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Inquilinos> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

@PostConstruct
public void prepararPesquisa(){
	try {
		InquilinosDAO dao = new InquilinosDAO();
		itens = dao.listar();
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void prepararNovo(){
	try {
		inquilinos = new Inquilinos();
		ImoveisDAO dao = new ImoveisDAO();
		comboImoveis = dao.listar();
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void novo(){
	try {
		InquilinosDAO dao = new InquilinosDAO();
		dao.salvar(inquilinos);
		itens = dao.listar();
		JSFUtil.adicionarMensagemSucesso("Inquilino salvo com sucesso!");	
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void excluir(){
	try {
		InquilinosDAO dao = new InquilinosDAO();
		dao.excluir(inquilinos);
		
		// vai listar depois de excluido		
		itens = dao.listar();			
		JSFUtil.adicionarMensagemSucesso("Inquilino excluido com sucesso!");
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void editar(){
	try {
		InquilinosDAO dao = new InquilinosDAO();
		dao.editar(inquilinos);				
		itens = dao.listar();
		JSFUtil.adicionarMensagemSucesso("Inquilino editado com sucesso!");
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void prepararEditar(){
	try {
		inquilinos = new Inquilinos();
		ImoveisDAO dao = new ImoveisDAO();
		comboImoveis = dao.listar();
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}
}
