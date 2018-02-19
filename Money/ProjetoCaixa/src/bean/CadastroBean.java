package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.BancoMoedaDAO;
import domain.BancoMoeda;
import util.MoedaUtil;

@ManagedBean(name = "MBBancoMoeda")
@ViewScoped
public class CadastroBean {
	private ListDataModel<BancoMoeda> itens;
	private BancoMoeda moeda;

	public BancoMoeda getMoeda() {
		return moeda;
	}

	public void setMoeda(BancoMoeda moeda) {
		this.moeda = moeda;
	}

	public ListDataModel<BancoMoeda> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<BancoMoeda> itens) {
		this.itens = itens;
	}
	
	@PostConstruct
	public void pesquisar() {
		try {
			BancoMoedaDAO bdao = new BancoMoedaDAO();
			ArrayList<BancoMoeda> listab = bdao.consultar();
			itens = new ListDataModel<BancoMoeda>(listab);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			MoedaUtil.MensagemErro(ex.getMessage());
		}		
	}		
}
