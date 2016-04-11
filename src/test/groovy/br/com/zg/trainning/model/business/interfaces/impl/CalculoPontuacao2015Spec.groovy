package br.com.zg.trainning.model.business.interfaces.impl

import br.com.zg.trainning.model.entities.Time
import spock.lang.Specification

/**
 * Created by luizhenrique on 07/04/16.
 */
class CalculoPontuacao2015Spec extends Specification {

	def "Calcula pontuação total de um time"() {
		setup:
		Time time = new Time(nome : 'Corinthans', quantidadeVitorias : 5, quantidadeEmpates : 3)
		CalculoPontuacao2015 calculoPontuacao2015 = new CalculoPontuacao2015()
		int pontuacaoTime = 0

		when:
		pontuacaoTime = calculoPontuacao2015.calculaPontuacaoTotal(time)

		then:
		pontuacaoTime == 18

	}

	def "Calcula pontuação de vitórias de um time"() {
		setup:
		CalculoPontuacao2015 calculoPontuacao2015 = new CalculoPontuacao2015()
		int pontuacaoVitoria = 0

		when:
		pontuacaoVitoria = calculoPontuacao2015.calculaPontuacaoVitoria(5)

		then:
		pontuacaoVitoria == 15
	}

	def "Calcula pontuação de empates de um time"() {
		setup:
		CalculoPontuacao2015 calculoPontuacao2015 = new CalculoPontuacao2015()
		int pontuacaoEmpate = 0

		when:
		pontuacaoEmpate = calculoPontuacao2015.calculaPontuacaoEmpates(5)

		then:
		pontuacaoEmpate == 5
	}
}
