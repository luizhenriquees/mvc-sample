package br.com.zg.trainning.view

/**
 * Created by luizhenrique on 11/04/16.
 */
interface TimeView {
	String pergunteNomeTime()

	String pergunteQuantidadeDeVitorias()

	String pergunteQuantidadeDeEmpates()

	String pergunteQuantidadeDeDerrotas()

	String pergunteQuantidadeDeGolsPro()

	String pergunteQuantidadeDeGolsContra()

	void notifiqueAdicaoDeTimes()

	String pergunteSeMaisTimes()
}
