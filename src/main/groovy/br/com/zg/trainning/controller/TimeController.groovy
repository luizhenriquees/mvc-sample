package br.com.zg.trainning.controller

import br.com.zg.trainning.model.business.CampeonatoBusiness

import br.com.zg.trainning.model.entities.Campeonato
import br.com.zg.trainning.model.entities.Time
import br.com.zg.trainning.view.TimeView

/**
 * Created by luizhenrique on 08/04/16.
 */
class TimeController {

	CampeonatoBusiness campeonatoBusiness
	TimeView timeView

	TimeController(CampeonatoBusiness campeonatoBusiness, TimeView timeView) {
		this.campeonatoBusiness = campeonatoBusiness
		this.timeView = timeView
	}

	Campeonato adicioneTimes(Campeonato campeonato) {
		adicioneTime(campeonato)
	}

	private Campeonato adicioneTime(Campeonato campeonato) {
		String nome = timeView.pergunteNomeTime()
		int vitorias = timeView.pergunteQuantidadeDeVitorias().toInteger()
		int empates = timeView.pergunteQuantidadeDeEmpates().toInteger()
		int derrotas = timeView.pergunteQuantidadeDeDerrotas().toInteger()
		int golsPro = timeView.pergunteQuantidadeDeGolsPro().toInteger()
		int golsContra = timeView.pergunteQuantidadeDeGolsContra().toInteger()

		Time time = new Time(
				nome: nome,
				vitorias: vitorias,
				empates: empates,
				derrotas: derrotas,
				golsPro: golsPro,
				golsContra: golsContra
		)

		campeonato = campeonatoBusiness.adicionarTime(campeonato, time)
		String maisTimes = timeView.pergunteSeMaisTimes()

		if (maisTimes == 'S') {
			adicioneTime(campeonato)
		}

		return campeonato
	}

}
