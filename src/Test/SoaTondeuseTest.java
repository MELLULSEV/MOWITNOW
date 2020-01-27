package Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Classes.Tondeuse;
import Soa.SOATondeuseImpl;

public class SoaTondeuseTest {
	
	// SOA
	private SOATondeuseImpl			soaTondeuse;
	
	@Test
	public void testParcoursTondeuseNonReconnu() {
		
		soaTondeuse = new SOATondeuseImpl();
		
		List<Tondeuse> listeDesTondeuses = new ArrayList<Tondeuse>();
		
		initListeTondeuse(listeDesTondeuses,1,1,"TondeuseHorsParcours","N","FFFF");
		
		soaTondeuse.traiterCommandesTondeuses(listeDesTondeuses, 5, 5);
		
	}
	
	@Test
	public void testTondeuseSortDuTerrainParOuest() {
		
		soaTondeuse = new SOATondeuseImpl();
		
		List<Tondeuse> listeDesTondeuses = new ArrayList<Tondeuse>();
		
		initListeTondeuse(listeDesTondeuses,1,1,"TondeuseSortie1","N","GAA");
		
		soaTondeuse.traiterCommandesTondeuses(listeDesTondeuses, 5, 5);
		
	}
	
	@Test
	public void testTondeuseSortDuTerrainParSud() {
		
		soaTondeuse = new SOATondeuseImpl();
		
		List<Tondeuse> listeDesTondeuses = new ArrayList<Tondeuse>();
		
		initListeTondeuse(listeDesTondeuses,1,1,"TondeuseSortie2","N","DDAA");
		
		soaTondeuse.traiterCommandesTondeuses(listeDesTondeuses, 5, 5);	
		
	}
	
	private void initListeTondeuse(List<Tondeuse>listeDesTondeuses,Integer Abs, Integer Ordo, String Nom ,String Orientation, String Parcours ) {
		
		Tondeuse uneTondeuse = new Tondeuse();

		uneTondeuse.setAbs(Abs);
		uneTondeuse.setOrdo(Ordo);
		uneTondeuse.setNom(Nom);
		uneTondeuse.setParcours(Parcours);
		uneTondeuse.setOrientation(Orientation);
		uneTondeuse.setStop(false);

		listeDesTondeuses.add(uneTondeuse);
				
	}
	

}
