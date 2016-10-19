package Controlador;
import Data.*;
import Entidades.*;

public class ControladorJuego {

	DataPersonaje data = new DataPersonaje();
	
	public Personaje Buscar(Personaje p)
	{
		return data.getByID(p);
	}
}
