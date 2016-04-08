package br.com.zg.trainning.model.business.interfaces.impl

import br.com.zg.trainning.model.business.interfaces.Classificacao
import br.com.zg.trainning.model.entities.Campeonato
import br.com.zg.trainning.model.entities.Time

/**
 * Created by luizhenrique on 07/04/16.
 */
class Classificacao2015 implements Classificacao {
	List<Time> realizaClassificacao(Campeonato campeonato) {
		Map<Integer, Time> timesOrdenadosMenorParaMaior = aplicaCriteriosDesempate(campeonato.timesParticipantes)
		Map<Integer, Time> timesOrdenadoPorClassificacao
		timesOrdenadoPorClassificacao = timesOrdenadosMenorParaMaior.sort { timeA, timeB ->
			timeB.key <=> timeA.key
		}
		List<Time> listaTimesOrdenadosPorClassificacao = []
		timesOrdenadoPorClassificacao.each {
			listaTimesOrdenadosPorClassificacao += it.value
		}
		return listaTimesOrdenadosPorClassificacao
	}

	Map<Integer, Time> aplicaCriteriosDesempate(List<Time> times) {
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

		Map<Integer, Time> timesOrdenados = [:]
		times.eachWithIndex { time, i ->
			timesOrdenados.put(i, time)
		}
		return timesOrdenados
	}

	Time obterTimeCampeao(Map<Integer, Time> timesOrdenadosClassificacao) {
		timesOrdenadosClassificacao.get(timesOrdenadosClassificacao.size() - 1)
	}

	Time obterTimeLanterna(Map<Integer, Time> timesOrdenadosClassificacao) {
		timesOrdenadosClassificacao.get(0)
	}
}
