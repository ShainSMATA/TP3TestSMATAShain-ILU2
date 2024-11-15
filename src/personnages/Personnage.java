package personnages;

public class Personnage {
	protected String nom;
	protected int force;

	public Personnage(String nom, int force) {
		this.nom = nom;
		this.force = force;
		// Invariant
		assert force > 0; //test asuusi = ou inf , peut pas completeter la brache acr faut null mais besoin de int
	}

	public int getForce() {
		return force;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "[nom=" + nom + ", force=" + force + "]";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	protected String prendreParole() {
		return nom + " : ";
	}
}