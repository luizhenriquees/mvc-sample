package br.com.zg.trainning.model.dao

import br.com.zg.trainning.model.entities.Campeonato
import br.com.zg.trainning.model.entities.Time


/**
 * Created by luizhenrique on 07/04/16.
 */
interface CampeonatoDAO {

	List<Campeonato> salvar(List<Campeonato> listaDeCampeonatos, Campeonato campeonato)
	Campeonato salvarTimes(Campeonato campeonato, List<Time> timesParticipantes)
}
