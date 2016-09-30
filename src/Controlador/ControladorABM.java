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
		
			
	}	
	
	public void agregar(Personaje p){
		arrayPer.add(p);
	}
	
	
	public Personaje Buscar(Personaje per)
	{
		Personaje personaje=null;
		for(Personaje p: arrayPer)
			{
				if(per.getId()==p.getId()){
					personaje=p;
				}
			}
		return personaje;
	}
	
	public void Modificar(Personaje per){
		if(arrayPer.contains(per)){
		Personaje perEnc=this.Buscar(per);
		perEnc.setId(per.getId());
		perEnc.setNombre(per.getNombre());
		perEnc.setEnergia(per.getEnergia());
		perEnc.setAtaque(per.getAtaque());
		perEnc.setDefensa(per.getDefensa());
		perEnc.setEvasion(per.getEvasion());
		//perEnc.setTotalRestante(per.getTotalRestante());
		
		}
	}
	
	public void Eliminar(Personaje p)
	{
		/*if(arrayPer.contains(per)){
		Personaje perEnc=this.Buscar(per);
		arrayPer.delete(p);
		}*/
	}
}





