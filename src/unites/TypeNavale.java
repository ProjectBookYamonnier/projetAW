package unites;

public abstract class TypeNavale extends Unite {

	public TypeNavale(int x, int y, int equipe, boolean dispo) {
		super(x, y, equipe, dispo);
		id_type = "TypeNavale";
		DifForet = 100; // terrain inacessible
		DifPlaine = 100; // terrain inacessible
		DifMontagne = 100; // terrain inacessible
		DifPlage = 100; // terrain inacessible
		DifEau = 1;
		DifPropriete = 100; // terrain inacessible
	}

}
