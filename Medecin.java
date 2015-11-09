/**
 * \file Medecin.java
 * \brief La Classe Medecin
 * \author Teng FAN
 * \version 1.0
 * \date 3 decembre 2014
 *
 *
 */  

public class Medecin extends Citoyen 
{
	protected int nbreKits;
	
	/** @brief Constructeur
	 *  @since 1.0.0
	 *  @param  String <b>nom</b> Le nom Point <b>point</b> Coordonnees du citoyen double <b>niveauContamination</b> Le niveau de contamination double <b>risqueMaladie</b> Risque d'etre malade double <b>probaTransmettre</b> La probabilite de transmettre le virus double <b>risqueMortalite</b> Le risque d'etre mort
	 *  @return rien
	 */
	public Medecin(String nom, Point point,double niveauContamination,double risqueMaladie,double probaTransmettre,double risqueMortalite) 
	{
		super(nom,point,niveauContamination,risqueMaladie,probaTransmettre,risqueMortalite);
		super.setFonction("Medecin");
		super.setEtatChangeCase(false);
		super.setExistence(true);
		super.setNbreKits(5);
	}

	/** @brief Constructeur
	 *  @since 1.0.0
	 *  @param  String <b>nom</b> Le nom Point <b>point</b> Coordonnees du citoyen double <b>niveauContamination</b> Le niveau de contamination double <b>risqueMaladie</b> Risque d'etre malade double <b>probaTransmettre</b> La probabilite de transmettre le virus double <b>risqueMortalite</b> Le risque d'etre mort String <b>fonction</b> Sa fonction boolean <b>existence</b> L'existence du medicin int <b>nbreKits</b> le nombre de kits
	 *  @return rien
	 */
	public Medecin(String nom, Point point,double niveauContamination,double risqueMaladie,double probaTransmettre,double risqueMortalite, String fonction,boolean existence, int nbreKits) 
	{
		super(nom,point,niveauContamination,risqueMaladie,probaTransmettre,risqueMortalite);
		super.setFonction(fonction);
		super.setEtatChangeCase(false);
		super.setExistence(existence);
		super.setNbreKits(nbreKits);
	}
	
	/** @brief toString, transmettre toutes les informations aux chaines de caracteres
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return String
	 */
	public String toString()
	{
		String phrase = "";
		phrase += super.toString();
		phrase += "Le nbre de kits = ["+nbreKits+"]\n";
		
		return phrase;
	}
	
	//======================== Test =======================================		
	//Programme Principal
	public static void main(String[] args)
	{
		Point point_test = new Point(2,2);
		double niveauContamination_test = 0;
		String fonction_test = "Citoyens";
		int joursMalades_test = 0;
		double probaTransmettre_test = 0;
		boolean etatMortalite_test = false;
		double risqueMortalite_test = 0;
		double risqueMaladie_test = 0;
		int joursGueris_test = 0;
		boolean etatMaladie_test = false;
		boolean existence_test = false;
		Citoyen c1 = new Medecin("FAN",point_test,niveauContamination_test,risqueMaladie_test,probaTransmettre_test,risqueMortalite_test);
		Citoyen c2 = new Medecin("JIANG",point_test,niveauContamination_test,risqueMaladie_test,probaTransmettre_test,risqueMortalite_test,"Medecin",true,10);
		Point coord = new Point(2,2);
		coord = c1.getCoordonnees();
		System.out.println("x = "+coord.getLigne()+": y = "+coord.getColonne());
		
		point_test.setCoordonnees(8,8);
		c2.setCoordonnees(point_test);
		coord = c2.getCoordonnees();
		System.out.println("x = "+coord.getLigne()+": y = "+coord.getColonne());
		if(c2.getExistence())	System.out.println("L'existence = true.");
		else	System.out.println("L'existence = false.");
		
		System.out.println("INFORMATIONS");
		System.out.println(c2.toString());
	}	
}
