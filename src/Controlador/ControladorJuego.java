package Controlador;
import Data.*;
import Entidades.*;

public class ControladorJuego {
	Personaje personajeTurno,personajeNoTurno;
    DataPersonaje data = new DataPersonaje();
	
	/*public ControladorJuego(Personaje personaje1,Personaje personaje2){
		personajeTurno=personaje1;
		personajeNoTurno=personaje2;
	}*/
	
	
	public Personaje Buscar(Personaje p)
	{
		return data.getByID(p);
	}
	
	public void Atacar(int puntosDeEnergia){
		personajeNoTurno.RecibirAtaque(puntosDeEnergia);
		Turno();
	}
	
	public void Turno(){
		Personaje aux=personajeTurno;
		personajeTurno=personajeNoTurno;
		personajeNoTurno=aux;
	}
	
}
