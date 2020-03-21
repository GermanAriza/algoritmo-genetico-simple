package service;

import java.util.Comparator;

import model.Individuo;

public class CompararIndividuos implements Comparator<Individuo> {

	@Override
	public int compare(Individuo i1, Individuo i2) {
		if (i1.getDesempenio() > i2.getDesempenio()) {
			return -1;
		} else if (i1.getDesempenio() < i2.getDesempenio()) {
			return 0;
		} else {
			return 1;
		}
	}

	}