package br.com.zg.trainning.controller

import br.com.zg.trainning.model.business.TimeBusiness
import br.com.zg.trainning.model.entities.Time

/**
 * Created by luizhenrique on 08/04/16.
 */
class TimeController {

	TimeBusiness timeBusiness = new TimeBusiness()

	List<Time> salvarTime(List<Time> times, Time time){
		timeBusiness.salvar(times, time)
	}
}
