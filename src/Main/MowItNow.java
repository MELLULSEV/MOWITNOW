package Main;

import Soa.SOATondeuse;
import Soa.SOATondeuseImpl;

public class MowItNow {
	
	public static void main(String[] args)
	{
		final SOATondeuse soaTondeuse = new SOATondeuseImpl();
		
		soaTondeuse.parcoursTondeuses(args[0]);
		
	}

}
