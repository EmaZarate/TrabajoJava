package Controlador;
import java.util.ArrayList;

import Entidades.*;

public class ControladorABM {
	
	ArrayList<Personaje> arrayPer = new ArrayList<Personaje>();
	public ControladorABM()
	{   
	    	
	
		Personaje p = new Personaje();
		p.setAtaque(3);
		p.setDefensa(4);
		p.setEnergia(13);
		p.setEvasion(2);
		p.setNombre("Super Man");
		p.setId(1);
		arrayPer.add(p);
		
		p.setAtaque(3);
		p.setDefensa(4);
		p.setEnergia(13);
		p.setEvasion(2);
		p.setNombre("Super Man");
		p.setId(1);
		arrayPer.add(p);
		
	}	
	
	public void agregar(Personaje p){
		arrayPer.add(p);
	}

}
