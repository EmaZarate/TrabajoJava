package Controlador;
import Data.*;
import Entidades.*;

public class ControladorJuego {
	Personaje personajeTurno,personajeNoTurno;
    DataPersonaje data = new DataPersonaje();
	
	
	
	public Personaje Buscar(Personaje p)
	{
		return data.getByID(p);
	}
	
	public void Seleccionar(Personaje p1,Personaje p2){
		personajeTurno=p1;
		personajeNoTurno=p2;
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
	
	public int ActualizarVida(){
		return personajeNoTurno.getVida();
	}
	
	public int ActualizarEnergia(){
		return personajeTurno.getEnergia();
	}
	
	public void Turno(){
		Personaje aux=personajeTurno;
		personajeTurno=personajeNoTurno;
		personajeNoTurno=aux;
	}
	
}
