package br.com.zg.trainning.model.business.interfaces.impl

import br.com.zg.trainning.model.business.interfaces.CalculoPontuacao
import br.com.zg.trainning.model.entities.Time

/**
 * Created by luizhenrique on 07/04/16.
 */
class CalculoPontuacao2015 implements CalculoPontuacao {

	private final int PONTOS_POR_VITORIA = 3
	private final int PONTOS_POR_EMPATE = 1

	int calculaPontuacaoTotal(Time time) {
		int pontuacaoFinal = 0
		pontuacaoFinal += calculaPontuacaoVitoria(time.quantidadeVitorias)
		pontuacaoFinal += calculaPontuacaoEmpates(time.quantidadeEmpates)
		return pontuacaoFinal
	}

	int calculaPontuacaoVitoria(int quantidadeVitorias) {
		quantidadeVitorias * PONTOS_POR_VITORIA
	}

	int calculaPontuacaoEmpates(int quantidadeEmpates) {
		quantidadeEmpates * PONTOS_POR_EMPATE
	}
}
