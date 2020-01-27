package Dao;

import java.util.Collection;
import java.util.List;

import Classes.Tondeuse;

public interface DAOTondeuse {

	public List<Tondeuse> chargeTondeuses();
	
	public Integer recupereAbsMax();
	
	public Integer recupereOrdoMax();
	
}
