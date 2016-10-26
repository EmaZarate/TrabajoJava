package Entidades;

public class Personaje {
	String nombre;
	int energia,vida,defensa,evasion,id,puntos;
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	
	public int getEvasion() {
		return evasion;
	}
	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public boolean RecibirAtaque(int PuntosDeEnergia){
		boolean semuirio=false;
		this.vida=this.vida-PuntosDeEnergia;
		if(this.vida<=0){
			semuirio=true;
		}
		return semuirio;
	}
	
	public void Atacar(int PuntosDeEnergia)
	{
		this.energia=this.energia-PuntosDeEnergia;
	}
	
	@Override
	public boolean equals(Object per){
		return per instanceof Personaje && ((Personaje)per).getId() == this.getId();
	}
	public void Defender(int energia,int vida) {
		this.energia=this.energia+(energia*this.defensa/100);
		if(this.energia>energia){
			this.energia=energia;
		}
		
		this.vida=this.vida+(vida*this.defensa/100);
		if(this.vida>vida){
			this.vida=vida;
		}
		
	}

}
