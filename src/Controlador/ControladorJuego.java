package Controlador;
import Data.*;
import Entidades.*;

public class ControladorJuego {
	Personaje personajeTurno,personajeTurnoOriginal,personajeNoTurno,personajeNoTurnoOriginal;
    DataPersonaje data = new DataPersonaje();
	
	
	
	public Personaje Buscar(Personaje p)
	{
		return data.getByID(p);
	}
	
	public void Seleccionar(Personaje p1,Personaje p2){
		personajeTurno=p1;
		personajeTurnoOriginal=data.getByID(personajeTurno);
		personajeNoTurno=p2;
		personajeNoTurnoOriginal=data.getByID(personajeNoTurno);
	}
	
	public boolean Atacar(int puntosDeEnergia){
		boolean semurio=false;
		if(personajeNoTurno.RecibirAtaque(puntosDeEnergia))
		{
			semurio=true;
		}
		else{
		personajeTurno.Atacar(puntosDeEnergia);	
		}
		
		return semurio;
	}
	
	public void Defender(){
		personajeTurno.Defender(personajeTurnoOriginal.getEnergia(),personajeTurnoOriginal.getVida());
	}
	
	
	public Personaje DevolverPerosnajeTurno(){
		return personajeTurno;
	}
	
	public Personaje DevolverPersonajeNoTurno(){
		return personajeNoTurno;
	}
	
	
	public void Turno(){
		Personaje aux=personajeTurno;
		personajeTurno=personajeNoTurno;
		personajeNoTurno=aux;
		aux=personajeTurnoOriginal;
		personajeTurnoOriginal=personajeNoTurnoOriginal;
		personajeNoTurnoOriginal=aux;
	}
	
}
