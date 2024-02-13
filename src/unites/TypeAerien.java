package unites;

public abstract class TypeAerien extends Unite {

	public TypeAerien(int x, int y, int equipe, boolean dispo) {
        super(x, y, equipe, dispo);
        id_type = "TypeAerien";
		DifForet = 1;
		DifPlaine = 1;
		DifMontagne = 1;
		DifPlage = 1;
		DifEau = 1;
		DifPropriete = 1;
	}
}
