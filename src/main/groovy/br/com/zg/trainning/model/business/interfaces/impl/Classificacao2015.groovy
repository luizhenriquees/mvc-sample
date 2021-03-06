package br.com.zg.trainning.model.business.interfaces.impl

import br.com.zg.trainning.model.business.interfaces.Classificacao
import br.com.zg.trainning.model.entities.Campeonato
import br.com.zg.trainning.model.entities.Time

/**
 * Created by luizhenrique on 07/04/16.
 */
class Classificacao2015 implements Classificacao {

	List<Time> realizaClassificacao(Campeonato campeonato) {
		List<Time> timesOrdenadosMenorParaMaior = aplicaCriteriosDesempate(campeonato.timesParticipantes)

		return timesOrdenadosMenorParaMaior.reverse()
	}

	List<Time> aplicaCriteriosDesempate(List<Time> times) {
		CalculoPontuacao2015 calculoPontuacao2015 = new CalculoPontuacao2015()
		int saldoGolsTimeA, saldoGolsTimeB

		times = times.sort { timeA, timeB ->
			saldoGolsTimeA = timeA.quantidadeGolsPro - timeA.quantidadeGolsContra
			saldoGolsTimeB = timeB.quantidadeGolsPro - timeB.quantidadeGolsContra

			if (calculoPontuacao2015.calculaPontuacaoTotal(timeA) != calculoPontuacao2015.calculaPontuacaoTotal(timeB)) {
				calculoPontuacao2015.calculaPontuacaoTotal(timeA) <=> calculoPontuacao2015.calculaPontuacaoTotal(timeB)
			} else if (timeA.quantidadeVitorias != timeB.quantidadeVitorias) {
				timeA.quantidadeVitorias <=> timeB.quantidadeVitorias
			} else if (saldoGolsTimeA != saldoGolsTimeB) {
				saldoGolsTimeA <=> saldoGolsTimeB
			} else {
				timeA.quantidadeGolsPro <=> timeB.quantidadeGolsPro
			}
		}

		return times
	}

	Time obterTimeCampeao(Campeonato campeonato) {
		realizaClassificacao(campeonato).first()
	}

	Time obterTimeLanterna(Campeonato campeonato) {
		realizaClassificacao(campeonato).last()
	}
}
