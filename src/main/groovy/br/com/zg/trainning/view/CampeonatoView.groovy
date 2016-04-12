package br.com.zg.trainning.view

import br.com.zg.trainning.model.entities.Time

/**
 * Created by luizhenrique on 11/04/16.
 */
interface CampeonatoView {

	String pergunteNomeCampeonato()

	String pergunteOperacao()

	void exibaCampeao(Time time)

	void exibaLanterna(Time time)

	void exibaTabela(List<Time> times)
}
