package br.com.zg.trainning.controller

import br.com.zg.trainning.model.business.CampeonatoBusiness
import br.com.zg.trainning.model.business.interfaces.CalculoPontuacao
import br.com.zg.trainning.model.business.interfaces.Classificacao
import br.com.zg.trainning.model.entities.Campeonato
import br.com.zg.trainning.model.entities.Time
import br.com.zg.trainning.view.CampeonatoView

/**
 * Created by luizhenrique on 08/04/16.
 */
class CampeonatoController {

	public static final int SABER_CAMPEAO = 1
	public static final int SABER_LANTERNA = 2
	public static final int EXIBIR_TABELA = 3
	public static final int ENCERRAR = 0

	private CampeonatoBusiness campeonatoBusiness
	private TimeController timeController
	private CampeonatoView campeonatoView
	private Classificacao classificacao

	public CampeonatoController(CampeonatoBusiness campeonatoBusiness, TimeController timeController, CampeonatoView campeonatoView, Classificacao classificacao) {
		this.campeonatoBusiness = campeonatoBusiness
		this.timeController = timeController
		this.campeonatoView = campeonatoView
		this.classificacao = classificacao
	}

	void iniciaCampeonato() {
		Campeonato campeonato = criaCampeonato()
		pergunteOperacao(campeonato)
	}

	private Campeonato criaCampeonato() {
		String nome = campeonatoView.pergunteNomeCampeonato()
		Campeonato campeonato = new Campeonato(nome: nome)

		timeController.adicioneTimes(campeonato)

		return campeonato
	}

	private void pergunteOperacao(Campeonato campeonato) {
		int operacao = campeonatoView.pergunteOperacao().toInteger()

		switch (operacao) {
			case SABER_CAMPEAO:
				Time campeao = classificacao.obterTimeCampeao(campeonato)
				campeonatoView.exibaCampeao(campeao)

				pergunteOperacao(campeonato)
				break
			case SABER_LANTERNA:
				Time lanterna = classificacao.obterTimeLanterna(campeonato)
				campeonatoView.exibaLanterna(lanterna)

				pergunteOperacao(campeonato)
				break
			case EXIBIR_TABELA:
				List<Time> times = classificacao.realizaClassificacao(campeonato)
				campeonatoView.exibaTabela(times)

				pergunteOperacao(campeonato)
				break
			case ENCERRAR:
				break
		}
	}
}
