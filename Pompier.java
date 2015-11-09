/**
 * \file Pompier.java
 * \brief La Classe Pompier
 * \author Teng FAN
 * \version 1.0
 * \date 3 decembre 2014
 *
 *
 */  

public class Pompier extends Citoyen
{
	public int appareil;

	public double pulverisateur;

	/** @brief Constructeur
	 *  @since 1.0.0
	 *  @param  String <b>nom</b> Le nom Point <b>point</b> Coordonnees du citoyen double <b>niveauContamination</b> Le niveau de contamination double <b>risqueMaladie</b> Risque d'etre malade double <b>probaTransmettre</b> La probabilite de transmettre le virus double <b>risqueMortalite</b> Le risque d'etre mort
	 *  @return rien
	 */
	public Pompier(String nom, Point point,double niveauContamination,double risqueMaladie,double probaTransmettre,double risqueMortalite) 
	{
		super(nom, point,niveauContamination,risqueMaladie,probaTransmettre,risqueMortalite);
		super.setFonction("Pompier");
		super.setExistence(true);
		super.setEtatChangeCase(false);
		super.setPulverisateur(0.5);
	}

	/** @brief Constructeur
	 *  @since 1.0.0
	 *  @param  String <b>nom</b> Le nom Point <b>point</b> Coordonnees du citoyen double <b>niveauContamination</b> Le niveau de contamination double <b>risqueMaladie</b> Risque d'etre malade double <b>probaTransmettre</b> La probabilite de transmettre le virus double <b>risqueMortalite</b> Le risque d'etre mort <b>fonction</b> Sa fonction boolean <b>existence</b> L'existence du pompier double <b>pulverisateur</b> Le reste du pulverisateur
	 *  @return rien
	 */
	public Pompier(String nom, Point point,double niveauContamination,double risqueMaladie,double probaTransmettre,double risqueMortalite, String fonction,boolean existence, double pulverisateur) 
	{
		super(nom, point,niveauContamination,risqueMaladie,probaTransmettre,risqueMortalite);
		super.setFonction(fonction);
		super.setExistence(true);
		super.setEtatChangeCase(false);
		super.setPulverisateur(pulverisateur);
	}
	
	/** @brief ToString, transmettre toutes les informations aux chaines de caracteres
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return String
	 */
	public String ToString()
	{
		String phrase = "";
		phrase += super.toString();
		phrase += "Le numbre d'appaeil = ["+appareil+"]\n";
		phrase += "Le reste du pulverisateur = ["+pulverisateur+"]\n";
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
		Citoyen c1 = new Pompier("FAN",point_test,niveauContamination_test,risqueMaladie_test,probaTransmettre_test,risqueMortalite_test);
		Citoyen c2 = new Pompier("JIANG",point_test,niveauContamination_test,risqueMaladie_test,probaTransmettre_test,risqueMortalite_test,"Pompier",true,0.8);
		Point coord = new Point();
		coord = c1.getCoordonnees();
		System.out.println("x = "+coord.getLigne()+": y = "+coord.getColonne());
		
		point_test.setCoordonnees(8,8);
		c2.setCoordonnees(point_test);
		coord = c2.getCoordonnees();
		System.out.println("x = "+coord.getLigne()+": y = "+coord.getColonne());
		
		System.out.println("INFORMATIONS");
		System.out.println(c2.toString());
	}
	
}
