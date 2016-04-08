package br.com.zg.trainning.controller

import br.com.zg.trainning.model.business.CampeonatoBusiness
import br.com.zg.trainning.model.entities.Campeonato

/**
 * Created by luizhenrique on 08/04/16.
 */
class CampeonatoController {

	CampeonatoBusiness campeonatoBusiness = new CampeonatoBusiness()

	List<Campeonato> salvarCampeonato(List<Campeonato> campeonatos, Campeonato campeonato){
		campeonatoBusiness.salvar(campeonatos, campeonato)
	}
}
