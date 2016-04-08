package br.com.zg.trainning

import br.com.zg.trainning.view.CampeonatoGUI
import spock.lang.Specification

class CampeonatoAppConsoleSpec extends Specification {

    void 'Aplicativo deve retornar o campeao do campeonato quando executar operação 1'() {
        setup:
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        System.out = new PrintStream(outputStream)
        System.in = input

        when:
        CampeonatoGUI.executaPrograma()

        then:
        outputStream.toString().contains 'O campeão é o Corinthians'

        where:
        input = this.class.getResourceAsStream('/inputComCampeao.txt')
    }

    void 'Aplicativo deve retornar o lanterna do campeonato quando executar operação 2'() {
        setup:
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        System.out = new PrintStream(outputStream)
        System.in = input

        when:
        CampeonatoGUI.executaPrograma()

        then:
        outputStream.toString().contains 'O lanterna é o Grêmio'

        where:
        input = this.class.getResourceAsStream('/inputComEmpate.txt')
    }
}
