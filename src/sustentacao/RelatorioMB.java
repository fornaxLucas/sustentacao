package sustentacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Classe responsavel pela comunicacao do modelo com a view
 * 
 * @author Lucas Henrique de Sousa
 * 
 * @version 1.0
 */

@ViewScoped
@ManagedBean
public class RelatorioMB implements Serializable {
	private static final long serialVersionUID = 1L;

	private Equipe equipe = new Equipe();

	// private String equipes = equipe.getDescricao().toString();

	private RelatorioSB relatorioSB = new RelatorioSB();

	private List<Relatorio> listaRelatorio = new ArrayList<Relatorio>();
	
	private List<Equipe> equipes = new ArrayList<Equipe>();

	private Relatorio relatorio = new Relatorio();

	private Date dataInicio;

	private Date dataFim;
	
	private List<String> listaDescricaoEquipes = new ArrayList<String>();
	
	@PostConstruct
	public void init () {
		EquipesEnum[] values = EquipesEnum.values();
		for (EquipesEnum equipe : values) {
			listaDescricaoEquipes.add(equipe.name());
		}
	}

	//private EquipeEnum[] equipes = equipe.getDescricao();

	/**
	 * @return listaRelatorio
	 */
	public List<Relatorio> getListaRelatorio() {
		return listaRelatorio;
	}

	/**
	 * @param listaRelatorio
	 */
	public void setListaRelatorio(List<Relatorio> listaRelatorio) {
		this.listaRelatorio = listaRelatorio;
	}

	/**
	 * @return relatorio
	 */
	public Relatorio getRelatorio() {
		return relatorio;
	}

	/**
	 * @param relatorio
	 */
	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}

	/**
	 * @return dataInicio
	 */
	public Date getDataInicio() {
		return dataInicio;
	}

	/**
	 * @param dataInicio
	 */
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	 * @return dataFim
	 */
	public Date getDataFim() {
		return dataFim;
	}

	/**
	 * @param dataFim
	 */
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

//	public EquipeEnum[] getEquipes() {
//		return equipes;
//	}
//
//	public void setEquipes(EquipeEnum[] equipes) {
//		this.equipes = equipes;
//	}

	public RelatorioSB getRelatorioSB() {
		return relatorioSB;
	}

	public void setRelatorioSB(RelatorioSB relatorioSB) {
		this.relatorioSB = relatorioSB;
	}

	/**
	 * Pesquisa no banco de acordo com filtro informado
	 * 
	 * @return lista de Relatorio
	 */
	public List<Relatorio> buscarRelatorio() {
		listaRelatorio = relatorioSB.find(dataInicio, dataFim, equipes);
		return listaRelatorio;
	}

	/**
	 * Recupera os dados da tela para armazena-los no banco
	 * 
	 */
	public void salvarRelatorio() {
		relatorioSB.insert(relatorio);

		msgSalvo();

		if (relatorio != null) {
			limparRelatorio();
		}
	}

	/**
	 * Exibe a mensagem "Salvo com sucesso"
	 */
	public void msgSalvo() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Salvo com sucesso", ""));
	}

	/**
	 * Limpa os dados do Relatorio que est�o na tela
	 */
	public void limparRelatorio() {
		relatorio = new Relatorio();
	}

	public String mostrarGrafico() {
		// Abrir o grafico em uma nova janela

		// JButton jb = new JButton();
		//
		// jb.addActionListener(new ActionListener() {
		//
		// public void actionPerformed(ActionEvent e) {
		// JFrame teste = new JFrame();
		// teste.setVisible(true);
		// }
		// });
		return "grafico";
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public List<String> getListaDescricaoEquipes() {
		return listaDescricaoEquipes;
	}

	public void setListaDescricaoEquipes(List<String> listaDescricaoEquipes) {
		this.listaDescricaoEquipes = listaDescricaoEquipes;
	}

}