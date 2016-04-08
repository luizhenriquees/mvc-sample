package br.com.zg.trainning.view

import br.com.zg.trainning.controller.CampeonatoController
import br.com.zg.trainning.controller.ClassificacaoController
import br.com.zg.trainning.controller.TimeController
import br.com.zg.trainning.model.entities.Campeonato
import br.com.zg.trainning.model.entities.Time

/**
 * Created by luizhenrique on 08/04/16.
 */
class CampeonatoGUI {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
	static Campeonato campeonato;
	static List<Time> timesParticipantes = [];
	static List<Campeonato> listaCampeonatos = [];

	public static void main(String[] args) {
		executaPrograma()
	}

	public static void executaPrograma() {
		cadastrarCampeonato()
		cadastrarTimes()
		criaMenuSistema()
	}

	static void cadastrarCampeonato() {
		println "Seja bem vindo"
		print "Qual o nome do campeonato:"
		String nomeCampeonato = br.readLine()

		campeonato = new Campeonato(nome: nomeCampeonato, quantidadeRodadas: 38)
		CampeonatoController campeonatoController = new CampeonatoController()
		listaCampeonatos = campeonatoController.salvarCampeonato(listaCampeonatos, campeonato)
	}

	static void cadastrarTimes() {
		println "Insira a lista de times..."
		String continua = 's'
		TimeController timeController = new TimeController()
		while (continua == 's') {
			print "Qual o nome do time? "
			String nomeTime = br.readLine()
			print "Qual o numero de vitorias? "
			int qtdVitorias = br.readLine().toInteger()
			print "Qual o numero de empates? "
			int qtdEmpates = br.readLine().toInteger()
			print "Qual o numero de derrotas? "
			int qtdDerrotas = br.readLine().toInteger()
			print "Qual o numero de gols pro? "
			int qtdGolsPro = br.readLine().toInteger()
			print "Qual o numero de gols contra? "
			int qtdGolsContra = br.readLine().toInteger()

			Time time = new Time(nome: nomeTime, quantidadeVitorias: qtdVitorias, quantidadeEmpates: qtdEmpates, quantidadeDerrotas: qtdDerrotas,
					quantidadeGolsPro: qtdGolsPro, quantidadeGolsContra: qtdGolsContra)
			timesParticipantes = timeController.salvarTime(timesParticipantes, time)

			print "Deseja inserir outro time (s/n)?"
			continua = br.readLine()
		}
		campeonato.timesParticipantes = timesParticipantes
	}

	static void criaMenuSistema() {

		int opcaoEscolhida = 1

		while (opcaoEscolhida != 0) {
			println "Selecione uma operação"
			println "[1] Saber o campeão"
			println "[2] Saber o lanterna"
			println "[3] Exibir tabela"
			println "[0] Encerrar"

			opcaoEscolhida = br.readLine().toInteger()
			executarOperacao(opcaoEscolhida)
		}
	}

	private static executarOperacao(int opcaoEscolhida) {
		switch (opcaoEscolhida) {
			case 1:
				ClassificacaoController classificacaoController = new ClassificacaoController()
				println("O campeão é o ${classificacaoController.obterTimeCampeao(campeonato).nome}")
				break
			case 2:
				ClassificacaoController classificacaoController = new ClassificacaoController()
				println("O lanterna é o ${classificacaoController.obterTimeLanterna(campeonato).nome}")
				break
			case 3:
				ClassificacaoController classificacaoController = new ClassificacaoController()
				List<Time> listaOrdenada = classificacaoController.obterTabelaClassificacao(campeonato)
				imprimirTabela(listaOrdenada)
				break
			case 0:
				println('Programa encerrado')
				break
			default:
				println('Opção inválida')
				break
		}
	}

	private static void imprimirTabela(List<Time> listaOrdenada) {
		listaOrdenada.eachWithIndex { time, posicao ->
			println("${posicao+1} ${time.nome}")
		}
	}
}
