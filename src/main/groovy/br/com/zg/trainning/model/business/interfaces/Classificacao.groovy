package br.com.zg.trainning.model.business.interfaces

import br.com.zg.trainning.model.entities.Campeonato
import br.com.zg.trainning.model.entities.Time

/**
 * Created by luizhenrique on 07/04/16.
 */
interface Classificacao {

	Map<Integer, Time> realizaClassificacao(Campeonato campeonato)
	Map<Integer, Time> aplicaCriteriosDesempate(List<Time> times)
 }