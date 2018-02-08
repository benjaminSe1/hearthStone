package app.heros.factory;

import app.effect.BouleFeu;
import app.heros.Heros;
import app.heros.Mage;

public class MageFactory implements HerosFactory {

	@Override
	public Heros creerHeros() {
		return new Mage(30, 0, 1, new BouleFeu());
	}

}
