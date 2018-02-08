package app.heros.factory;

import app.effect.Armure;
import app.heros.Guerrier;
import app.heros.Heros;

public class GuerrierFactory implements HerosFactory {

	@Override
	public Heros creerHeros() {
		return new Guerrier(30, 0, 1, new Armure());
	}

}
