package br.com.zg.trainning.model.business.interfaces.impl

import br.com.zg.trainning.model.entities.Campeonato
import br.com.zg.trainning.model.entities.Time
import spock.lang.Specification

/**
 * Created by luizhenrique on 08/04/16.
 */
class Classificacao2015Spec extends Specification {
	def "aplica critérios de desempate nos times"() {
		setup:
		Classificacao2015 classificacao2015 = new Classificacao2015()
		List<Time> times = []
		/*7*/ times += new Time(nome: 'Corinthans', quantidadeVitorias: 10, quantidadeEmpates: 6, quantidadeGolsPro: 20, quantidadeGolsContra: 2)
		/*3*/ times += new Time(nome: 'Botafogo', quantidadeVitorias: 5, quantidadeEmpates: 3, quantidadeGolsPro: 15, quantidadeGolsContra: 7)
		/*2*/ times += new Time(nome: 'Palmeiras', quantidadeVitorias: 5, quantidadeEmpates: 3, quantidadeGolsPro: 10, quantidadeGolsContra: 2)
		/*1*/ times += new Time(nome: 'Fluminense', quantidadeVitorias: 2, quantidadeEmpates: 3, quantidadeGolsPro: 10, quantidadeGolsContra: 2)
		/*0*/ times += new Time(nome: 'São Paulo', quantidadeVitorias: 0, quantidadeEmpates: 5, quantidadeGolsPro: 10, quantidadeGolsContra: 2)
		/*4*/ times += new Time(nome: 'Barcelona', quantidadeVitorias: 6, quantidadeEmpates: 0, quantidadeGolsPro: 12, quantidadeGolsContra: 4)
		/*5*/ times += new Time(nome: 'Flamengo', quantidadeVitorias: 6, quantidadeEmpates: 0, quantidadeGolsPro: 11, quantidadeGolsContra: 2)
		/*6*/ times += new Time(nome: 'Real Madrid', quantidadeVitorias: 7, quantidadeEmpates: 1, quantidadeGolsPro: 22, quantidadeGolsContra: 2)

		when:
		Map<Integer, Time> timesOrdenados = classificacao2015.aplicaCriteriosDesempate(times)

		then:
		timesOrdenados.get(0).nome == 'São Paulo'
		timesOrdenados.get(1).nome == 'Fluminense'
		timesOrdenados.get(2).nome == 'Palmeiras'
		timesOrdenados.get(3).nome == 'Botafogo'
		timesOrdenados.get(4).nome == 'Barcelona'
		timesOrdenados.get(5).nome == 'Flamengo'
		timesOrdenados.get(6).nome == 'Real Madrid'
		timesOrdenados.get(7).nome == 'Corinthans'
	}
}
