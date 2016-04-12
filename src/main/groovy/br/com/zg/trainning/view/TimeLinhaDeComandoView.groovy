package br.com.zg.trainning.view

/**
 * Created by luizhenrique on 12/04/16.
 */
class TimeLinhaDeComandoView extends EntradaDadosView implements TimeView{
	String pergunteNomeTime() {
		pergunte("Qual o nome do time?")
	}

	String pergunteQuantidadeDeVitorias() {
		pergunte("Qual o número de vitórias?")
	}

	String pergunteQuantidadeDeEmpates() {
		pergunte("Qual o número de empates?")
	}

	String pergunteQuantidadeDeDerrotas() {
		pergunte("Qual o número de derrotas?")
	}

	String pergunteQuantidadeDeGolsPro() {
		pergunte("Qual o número de gols pró?")
	}

	String pergunteQuantidadeDeGolsContra() {
		pergunte("Qual o numero de gols contra?")
	}

	String pergunteSeMaisTimes() {
		pergunte("Deseja inserir outro time (s/n)?")
	}
}
