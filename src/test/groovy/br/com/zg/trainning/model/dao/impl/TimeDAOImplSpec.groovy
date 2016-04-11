package br.com.zg.trainning.model.dao.impl

import br.com.zg.trainning.model.dao.TimeDAO
import br.com.zg.trainning.model.entities.Time
import spock.lang.Specification

/**
 * Created by luizhenrique on 07/04/16.
 */
class TimeDAOImplSpec extends Specification {

	def "Salvar time na lista"() {
		setup:
		TimeDAO timeDAO = new TimeDAOImpl()
		Time time = new Time()
		List<Time> times = []

		when:
		time.nome = 'Corinthans'
		time.quantidadeVitorias = 4
		time.quantidadeDerrotas = 3
		time.quantidadeEmpates = 3
		time.quantidadeGolsPro = 20
		time.quantidadeGolsContra = 5
		times = timeDAO.salvar(times, time)

		then:
		times.size() == 1
	}
}
