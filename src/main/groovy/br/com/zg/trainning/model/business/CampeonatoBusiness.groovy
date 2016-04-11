package br.com.zg.trainning.model.business

import br.com.zg.trainning.model.dao.CampeonatoDAO
import br.com.zg.trainning.model.dao.impl.CampeonatoDAOImpl
import br.com.zg.trainning.model.entities.Campeonato
import br.com.zg.trainning.model.entities.Time

/**
 * Created by luizhenrique on 07/04/16.
 */
class CampeonatoBusiness {

	private campeonatoDAO

	CampeonatoBusiness(CampeonatoDAO campeonatoDAO) {
		this.campeonatoDAO = campeonatoDAO
	}

	List<Campeonato> salvar(List<Campeonato> listaDeCampeonatos, Campeonato campeonato) {
		campeonatoDAO.salvar(listaDeCampeonatos, campeonato)
	}

	Campeonato adicionarTime(Campeonato campeonato, Time time) {
		campeonatoDAO.adicionaTime(campeonato, time)
	}
}
