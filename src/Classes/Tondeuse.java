package Classes;

public class Tondeuse {
	
	private String	Nom;

	private Integer	Abs;
	private Integer	Ordo;
	private String	Orientation;
	private String	Parcours;
	private boolean	Stop;
	
	public Tondeuse() {}
	

	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		this.Nom = nom;
	}
	public Integer getAbs() {
		return Abs;
	}
	public void setAbs(Integer abs) {
		this.Abs = abs;
	}
	public Integer getOrdo() {
		return Ordo;
	}
	public void setOrdo(Integer ordo) {
		this.Ordo = ordo;
	}
	public String getOrientation() {
		return Orientation;
	}
	public void setOrientation(String orientation) {
		this.Orientation = orientation;
	}
	public String getParcours() {
		return Parcours;
	}
	public void setParcours(String parcours) {
		this.Parcours = parcours;
	}
	public boolean isStop() {
		return Stop;
	}
	public void setStop(boolean stop) {
		this.Stop = stop;
	}
	

}
