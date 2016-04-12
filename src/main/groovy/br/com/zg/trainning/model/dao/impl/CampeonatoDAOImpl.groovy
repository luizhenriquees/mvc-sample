package br.com.zg.trainning.model.dao.impl

import br.com.zg.trainning.model.entities.Campeonato
import br.com.zg.trainning.model.entities.Time
import br.com.zg.trainning.model.dao.CampeonatoDAO

/**
 * Created by luizhenrique on 07/04/16.
 */
class CampeonatoDAOImpl implements CampeonatoDAO{

	List<Campeonato> salvar(List<Campeonato> listaDeCampeonatos, Campeonato campeonato) {
		listaDeCampeonatos += campeonato
		return listaDeCampeonatos
	}

	Campeonato adicionaTime(Campeonato campeonato, Time time) {
		campeonato.timesParticipantes += time
		return campeonato
	}
}
