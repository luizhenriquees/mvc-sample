package br.com.zg.trainning.model.business.interfaces

import br.com.zg.trainning.model.entities.Campeonato
import br.com.zg.trainning.model.entities.Time

/**
 * Created by luizhenrique on 07/04/16.
 */
interface Classificacao {

	List<Time> realizaClassificacao(Campeonato campeonato)

	List<Time> aplicaCriteriosDesempate(List<Time> times)

	Time obterTimeCampeao(Campeonato campeonato)

	Time obterTimeLanterna(Campeonato campeonato)
}