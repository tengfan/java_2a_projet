/**
 * \file Hopital.java
 * \brief La Classe Hopital
 * \author Teng FAN
 * \version 1.0
 * \date 3 decembre 2014
 *
 *
 */  

public class Hopital extends Case {
	
	/** @brief Constructeur
	 *  @since 1.0.0
	 *  @param  String <b>nom</b> Le nom Point <b>point</b> Coordonnees de la case double <b>niveauContamination</b> Le niveau de contamination int <b>capacite</b> La capacite de la case 
	 *  @return rien
	 */	
	public Hopital(String nom, Point point, double niveauContamination, int capacite) 
	{
		super(nom, point, niveauContamination, capacite);
		super.setFonction("Hopital");
		super.setEtatCitoyenBloque(false);
	}
	
	/** @brief Constructeur
	 *  @since 1.0.0
	 *  @param  String <b>nom</b> Le nom Point <b>point</b> Coordonnees de la case double <b>niveauContamination</b> Le niveau de contamination int <b>capacite</b> La capacite de la case String <b>fonction</b> Fonction de la case
	 *  @return rien
	 */
	public Hopital(String nom, Point point, double niveauContamination, int capacite, String fonction) 
	{
		super(nom, point, niveauContamination, capacite);
		super.setFonction(fonction);
		super.setEtatCitoyenBloque(false);
	}
	
	/** @brief toString, transmettre toutes les informations aux chaines de caracteres
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return String
	 */
	public String toString()
	{
		String ret = "";
		ret+= "INFORMATIONS de ["+ this.getFonction()+"]\n"+super.toString();
		return ret;
	}
	
	//======================== Test =======================================		
	//Programme Principal
	public static void main(String[] args)
	{
		Point point_test = new Point(2,2);
		double niveauContamination_test = 0;
		int capacite = 2;
		Case c = new Hopital("Chales",point_test,niveauContamination_test,capacite);		
		
		System.out.println("INFORMATIONS");
		System.out.println(c.toString());
	}
}
