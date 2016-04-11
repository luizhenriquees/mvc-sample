package br.com.zg.trainning.model.dao.impl

import br.com.zg.trainning.model.dao.CampeonatoDAO
import br.com.zg.trainning.model.entities.Campeonato
import br.com.zg.trainning.model.entities.Time
import spock.lang.Specification

/**
 * Created by luizhenrique on 07/04/16.
 */
class CampeonatoDAOImplSpec extends Specification {

	def "Salvar"() {
		setup:
		Campeonato campeonato = new Campeonato()
		CampeonatoDAO campeonatoDAO = new CampeonatoDAOImpl()
		List<Campeonato> campeonatos = []

		when:
		campeonato.nome = 'Campeonato Brasileiro 2015'
		campeonato.quantidadeRodadas = 38
		campeonatos = campeonatoDAO.salvar(campeonatos, campeonato)

		then:
		campeonatos.size() == 1
	}

	def "SalvarTimes"() {
		setup: "criação do campeonato e dos times que irão fazer parte do mesmo"
		Campeonato campeonato = new Campeonato()
		CampeonatoDAO campeonatoDAO = new CampeonatoDAOImpl()
		List<Time> timesParticipantes = []
		Time time, time2
		time = new Time(nome : 'Corinthans', quantidadeVitorias : 7)
		time2 = new Time(nome : 'Palmeiras', quantidadeVitorias : 5)
		timesParticipantes = [time, time2]

		when: "dois times são inseridos no campeonato"
		campeonato = campeonatoDAO.salvarTimes(campeonato, timesParticipantes)

		then: "o campeonato possui dois times participantes"
		campeonato.timesParticipantes.size() == 2
	}
}
