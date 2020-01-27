package Dao;

import Classes.Tondeuse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.List;
import java.io.FileNotFoundException;


public class DAOTondeuseImpl implements DAOTondeuse{
	
	private static Integer ABS_MAX;
	private static Integer ORDO_MAX;
	
	private List<Tondeuse> lireFichierEntree(String NomDuFichier) throws IOException {
		
		List<Tondeuse> listeDesTondeuses = new ArrayList<Tondeuse>();

		try
		{
		   String chemin = NomDuFichier;
		   BufferedReader fichier_source = new BufferedReader(new FileReader(chemin));
		   String chaine;
		   int i = 1;
		   int nbTondeusesATraiter = 0;
		 
		   while((chaine = fichier_source.readLine())!= null)
		   {

		        String[] tabChaine = chaine.split(" ");
		        
		        if (i==1) {
		        	
		        	ABS_MAX = Integer.valueOf(tabChaine[0]);
		        	ORDO_MAX = Integer.valueOf(tabChaine[1]);
		        	
		        	
		        } else if (chaine.contains("A")||chaine.contains("G")||chaine.contains("D")) {
		        		
		        	int positionDerniereTondeuse = listeDesTondeuses.size() - 1;
		        	
		        	Tondeuse derniereTondeuse = listeDesTondeuses.get(positionDerniereTondeuse);
		        	
		        	derniereTondeuse.setParcours(tabChaine[0]);
				
		        } else {
		        	
		        	++nbTondeusesATraiter;
		        	
			 		Tondeuse uneTondeuse = new Tondeuse();
					
					uneTondeuse.setAbs(Integer.valueOf(tabChaine[0]));
					uneTondeuse.setOrdo(Integer.valueOf(tabChaine[1]));
					uneTondeuse.setNom(String.valueOf(nbTondeusesATraiter));
					
					uneTondeuse.setOrientation(tabChaine[2]);
					uneTondeuse.setStop(false);
					
					listeDesTondeuses.add(uneTondeuse);
		        }
		         
		      i++;
		   }
		   fichier_source.close();                 
		}
		catch (FileNotFoundException e)
		{
		   System.out.println("Le fichier est introuvable !");
		}
		
		return listeDesTondeuses;
			
	}

	@Override
	public List<Tondeuse> chargeTondeuses(String NomDuFichier) {
		//
		
		List<Tondeuse> listeDesTondeuses = new ArrayList<Tondeuse>();
		
		try {
			listeDesTondeuses = lireFichierEntree(NomDuFichier);
			
		} catch (IOException e) {
			
			System.out.println("Impossible de lire le fichier de données !");
		}
		
		return listeDesTondeuses;
	}
	
	public Integer recupereAbsMax() {
		return ABS_MAX;
	}
	
	public Integer recupereOrdoMax() {
		return ORDO_MAX;
	}

}
