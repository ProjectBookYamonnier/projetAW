package unites;

public abstract class TypeChenilles extends Unite {
	
	public static int DifPlaineApresMeteo;
	public static void setDifPlaineApresMeteo(int difPlaineApresMeteo) {DifPlaineApresMeteo = difPlaineApresMeteo;}

	public static int DifForetApresMeteo;
	public static void setDifForetApresMeteo(int difForetApresMeteo) {DifForetApresMeteo = difForetApresMeteo;}


	public TypeChenilles(int x, int y, int equipe, boolean dispo) {
        super(x, y, equipe, dispo);
        id_type = "TypeChenilles";
		DifForet = DifForetApresMeteo;
		DifPlaine = DifPlaineApresMeteo;
		DifPlage = 100; //terrain inacessible
		DifMontagne = 100; // terrain inacessible
		DifEau = 100; // terrain inacessible
		DifPropriete = 1;
	}

}
