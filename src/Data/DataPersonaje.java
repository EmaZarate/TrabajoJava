package Data;

import java.sql.*;



import Entidades.*;
import Utils.ApplicationException;

public class DataPersonaje {
	
	
	public DataPersonaje(){
		
	}
	
	public void add(Personaje p){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into personas(id,nombre,vida,energia,ataque,defensa,evasion)"+
					" values(?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			// PreparedStatement.RETURN_GENERATED_KEYS to be able to retrieve id generated on the db
			// by the autoincrement column. Otherwise don't use it
						
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getNombre());
			stmt.setInt(3, p.getVida());
			stmt.setInt(4, p.getEnergia());
			stmt.setInt(5, p.getAtaque());
			stmt.setInt(6, p.getDefensa());
			stmt.setInt(7, p.getEvasion());
			stmt.execute();
			
			//after executing the insert use the following lines to retrieve the id
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void update(Personaje p){
		PreparedStatement stmt=null;
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(
					"update personas set id=?, nombre=?, vida=?, energia=?,ataque=?,defensa=?,evasion=?"+
					" where id=?");
			
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getNombre());
			stmt.setInt(3, p.getVida());
			stmt.setInt(4, p.getEnergia());
			stmt.setInt(5, p.getAtaque());
			stmt.setInt(6, p.getDefensa());
			stmt.setInt(7, p.getEvasion());
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void delete(Personaje p){
		PreparedStatement stmt=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from personaje where id=?");
			stmt.setInt(1, p.getId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public Personaje getByID(Personaje per){
		Personaje p=null;
		
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id, nombre, vida, energia, ataque, defensa ,evasion from personaje where id=?");
			stmt.setInt(1, per.getId());
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Personaje();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setVida(rs.getInt("vida"));
				p.setEnergia(rs.getInt("energia"));
				p.setAtaque(rs.getInt("ataque"));
				p.setDefensa(rs.getInt("defensa"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return p;
	}
	
}