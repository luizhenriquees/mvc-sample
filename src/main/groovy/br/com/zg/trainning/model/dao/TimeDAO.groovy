package br.com.zg.trainning.model.dao

import br.com.zg.trainning.model.entities.Time

/**
 * Created by luizhenrique on 07/04/16.
 */
interface TimeDAO {

	List<Time> salvar(List<Time> times, Time time)
}