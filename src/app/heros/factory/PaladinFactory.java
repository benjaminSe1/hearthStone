package app.heros.factory;

import app.effect.Renfort;
import app.heros.Heros;
import app.heros.Paladin;

public class PaladinFactory implements HerosFactory{

	@Override
	public Heros creerHeros() {
		return new Paladin(30, 0, 1, new Renfort());
	}

}
