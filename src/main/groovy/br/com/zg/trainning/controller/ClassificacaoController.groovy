package br.com.zg.trainning.controller

import br.com.zg.trainning.model.business.interfaces.impl.Classificacao2015
import br.com.zg.trainning.model.entities.Campeonato
import br.com.zg.trainning.model.entities.Time

/**
 * Created by luizhenrique on 08/04/16.
 */
class ClassificacaoController {

	Classificacao2015 classificacao2015 = new Classificacao2015()

	Time obterTimeLanterna(Campeonato campeonato){
		Map<Integer, Time> timesOrdenados = classificacao2015.aplicaCriteriosDesempate(campeonato.timesParticipantes)
		return classificacao2015.obterTimeLanterna(timesOrdenados)
	}

	Time obterTimeCampeao(Campeonato campeonato){
		Map<Integer, Time> timesOrdenados = classificacao2015.aplicaCriteriosDesempate(campeonato.timesParticipantes)
		return classificacao2015.obterTimeCampeao(timesOrdenados)
	}

	List<Time> obterTabelaClassificacao(Campeonato campeonato){
		return classificacao2015.realizaClassificacao(campeonato)
	}
}
