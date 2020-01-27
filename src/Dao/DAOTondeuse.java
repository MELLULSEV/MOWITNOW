package Dao;

import java.util.List;

import Classes.Tondeuse;

public interface DAOTondeuse {

	public List<Tondeuse>chargeTondeuses(String NomDuFichier);
	
	public Integer recupereAbsMax();
	
	public Integer recupereOrdoMax();
	
}
