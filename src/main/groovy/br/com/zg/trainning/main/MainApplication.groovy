package br.com.zg.trainning.main

import br.com.zg.trainning.controller.CampeonatoController
import br.com.zg.trainning.controller.TimeController
import br.com.zg.trainning.model.business.CampeonatoBusiness
import br.com.zg.trainning.model.business.interfaces.Classificacao
import br.com.zg.trainning.model.business.interfaces.impl.Classificacao2015
import br.com.zg.trainning.model.dao.CampeonatoDAO
import br.com.zg.trainning.model.dao.impl.CampeonatoDAOImpl
import br.com.zg.trainning.view.CampeonatoLinhaDeComandoView
import br.com.zg.trainning.view.CampeonatoView
import br.com.zg.trainning.view.TimeLinhaDeComandoView
import br.com.zg.trainning.view.TimeView

class MainApplication {

	public static void main(String[] args) {

		TimeView timeView = new TimeLinhaDeComandoView()
		CampeonatoView campeonatoView = new CampeonatoLinhaDeComandoView()
		CampeonatoDAO campeonatoDAO = new CampeonatoDAOImpl()
		CampeonatoBusiness campeonatoBusiness = new CampeonatoBusiness(campeonatoDAO)
		Classificacao classificacao = new Classificacao2015()
		TimeController timeController = new TimeController(campeonatoBusiness, timeView)

		CampeonatoController campeonatoController = new CampeonatoController(campeonatoBusiness, timeController, campeonatoView, classificacao)

		campeonatoController.iniciaCampeonato()
	}
}
