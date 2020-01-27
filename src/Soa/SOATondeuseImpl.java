package Soa;

import java.util.List;
import java.lang.Double;


import Classes.Tondeuse;
import Dao.DAOTondeuseImpl;
import Enumeration.CodeOrientation;
import Dao.DAOTondeuse;


public class SOATondeuseImpl implements SOATondeuse{
	
	final DAOTondeuse daoTondeuse = new DAOTondeuseImpl();

	@Override
	public void parcoursTondeuses(String NomDuFichier) {

		final List<Tondeuse> tondeuses = daoTondeuse.chargeTondeuses(NomDuFichier);
		Integer OrdoMax = daoTondeuse.recupereOrdoMax();
		Integer AbsMax = daoTondeuse.recupereAbsMax();
		
		traiterCommandesTondeuses(tondeuses, OrdoMax, AbsMax);
	
	}


	public void traiterCommandesTondeuses(List<Tondeuse> tondeuses, Integer OrdoMax,Integer AbsMax) {
		
		Integer idInstructionItem = 0;
		Integer ParcoursNbItems = 0;
		boolean isPriseEnCompteAutresTondeuses = false;

		for(Tondeuse tondeuseEnCours : tondeuses) {
			
			if (tondeuseEnCours.getParcours().length()>0) {
				
				idInstructionItem = 0;
				ParcoursNbItems = tondeuseEnCours.getParcours().length();
				
				while ((isAbsValid(tondeuseEnCours, AbsMax))&&(isOrdoValid(tondeuseEnCours, OrdoMax))&&(!tondeuseEnCours.isStop())&&(Double.compare(idInstructionItem, ParcoursNbItems)<0)) {
					
					if (!isPriseEnCompteAutresTondeuses) {
						tondeuseEnCours = avance(tondeuseEnCours,idInstructionItem);
					} else {
						tondeuseEnCours = avance(tondeuseEnCours,idInstructionItem, tondeuses);
					}
					
					idInstructionItem++;
					
				}
								
			}
			
			tondeuseEnCours.setStop(true);
			
			System.out.println("Tondeuse "+tondeuseEnCours.getNom()+" arrêtée à la position ("+tondeuseEnCours.getAbs()+","+tondeuseEnCours.getOrdo()+") "
					+ ", orientée "+ CodeOrientation.getByCode(tondeuseEnCours.getOrientation()));

			
		}
		
	}


	private Tondeuse avance(Tondeuse tondeuseEnCours, final Integer idInstruction) {

		tondeuseEnCours = avance (tondeuseEnCours,idInstruction, null);
		
		return tondeuseEnCours;
	}


	private Tondeuse avance(Tondeuse tondeuseEnCours, Integer idInstruction, List<Tondeuse> listeTondeuses) {
		
		final String parcours = tondeuseEnCours.getParcours();
		final Integer indexDeb = idInstruction;
		final Integer indexFin = ++idInstruction;
		final String instructionEnCours = parcours.substring(indexDeb,indexFin);
		
		switch (instructionEnCours)
		{
		
		case "A":
			
			monteOuDescendDuneCase(tondeuseEnCours);
			
			avanceOuReculeDuneCase(tondeuseEnCours);
			
			//TODO
			//Si le paramètre d'entrée "listeTondeuses" est renseigné, rechercher dans cette liste une tondeuse 
			//qui sera déjà présente à la position calculée. Si c'est le cas, setStop(true)	
			
			return tondeuseEnCours;
		
		case "D":
			
			tondeuseEnCours.setOrientation(unQuartDeTourDroite(tondeuseEnCours.getOrientation()));
			
			return tondeuseEnCours;
			
		case "G":
			
			tondeuseEnCours.setOrientation(unQuartDeTourGauche(tondeuseEnCours.getOrientation()));
			
			return tondeuseEnCours;
			
		default:
			tondeuseEnCours.setStop(true);
			
			return tondeuseEnCours;
		}

	}

	private void avanceOuReculeDuneCase(Tondeuse tondeuseEnCours) {
		
		Integer abscisse = tondeuseEnCours.getAbs();
		
		if (tondeuseEnCours.getOrientation().equals("E")) {
	
			tondeuseEnCours.setAbs(++abscisse);
		} else if (tondeuseEnCours.getOrientation().equals("W")) {
	
			tondeuseEnCours.setAbs(--abscisse);
		}	

	}

	private void monteOuDescendDuneCase(Tondeuse tondeuseEnCours) {
		
		Integer ordonnee = tondeuseEnCours.getOrdo();
		
		if (tondeuseEnCours.getOrientation().equals("N")) {
	
			tondeuseEnCours.setOrdo(++ordonnee);
		} else if (tondeuseEnCours.getOrientation().equals("S")) {
	
			tondeuseEnCours.setOrdo(--ordonnee);
		}	

	}

	private static String unQuartDeTourGauche(String orientation) {
		
		switch (orientation) {
		
		case "N":
			return "W";
		case "W":
			return "S";
		case "S":
			return "E";
		default:
			return "N";
		}
		
	}

	private static String unQuartDeTourDroite(String orientation) {
		
		switch (orientation) {
		
		case "N":
			return "E";
		case "E":
			return "S";
		case "S":
			return "W";
		default:
			return "N";
		}
		
	}


	private Boolean isAbsValid(Tondeuse tondeuseEnCours, Integer AbsMax) {
		

		
		if (tondeuseEnCours.getAbs().intValue() < 0) {
			return false;
		}

		if (tondeuseEnCours.getAbs().intValue() > AbsMax.intValue()) {
			return false;
		} else {
			return true;
		}

	}


	private Boolean isOrdoValid(Tondeuse tondeuseEnCours, Integer OrdoMax) {

		
		
		if (tondeuseEnCours.getOrdo().intValue() < 0) {
			return false;
		}

		if (tondeuseEnCours.getOrdo().intValue() > OrdoMax.intValue()) {
			return false;
		} else {
			return true;
		}
		
	}

}
