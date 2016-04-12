package br.com.zg.trainning.view

import br.com.zg.trainning.model.entities.Time

class CampeonatoLinhaDeComandoView extends EntradaDadosView implements CampeonatoView {

	String pergunteNomeCampeonato() {
		pergunte 'Qual o nome do Campeonato?'
	}

	String pergunteOperacao() {
		println ''
		println 'Selecione uma operação'
		println '[1] Saber o campeão'
		println '[2] Saber o lanterna'
		println '[3] Exibir tabela'
		println '[0] Encerrar'

		pergunte ''
	}

	void exibaCampeao(Time time) {
		println "O campeão é o $time.nome!"
	}

	void exibaLanterna(Time time) {
		println "O lanterna é o $time.nome."
	}

	void exibaTabela(List<Time> times) {
		times.eachWithIndex { Time entry, int i ->
            println("${i+1} ${entry.nome}")
		}
	}
}
