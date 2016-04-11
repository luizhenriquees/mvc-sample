package br.com.zg.trainning.model.dao.impl

import br.com.zg.trainning.model.entities.Time
import br.com.zg.trainning.model.dao.TimeDAO

/**
 * Created by luizhenrique on 07/04/16.
 */
class TimeDAOImpl implements TimeDAO{

	List<Time> salvar(List<Time> times, Time time) {
		times += time
		return times
	}
}
