/**
 * \file Case.java
 * \brief La Classe Case
 * \author Teng FAN
 * \version 1.0
 * \date 3 decembre 2014
 *
 *
 */  

public class Case {

	protected double niveauContamination;

	protected int capacite;

	protected Point point = new Point();

	protected String nom;
	
	protected boolean existence = false;
	
	protected String fonction;
	
	protected boolean etatCitoyenBloque;

	/** @brief Constructeur
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */
	public Case() 
	{
		nom = "Anonyme";
		niveauContamination = 0;
		capacite = 0;
		point.setCoordonnees(0,0);
		existence = false;
		fonction = "Case";
		etatCitoyenBloque = false;
	}

	/** @brief Constructeur
	 *  @since 1.0.0
	 *  @param  String <b>nom</b> Le nom Point <b>point</b> Coordonnees de la case double <b>niveauContamination</b> Le niveau de contamination int <b>capacite</b> La capacite de la case
	 *  @return rien
	 */
	public Case(String nom, Point point, double niveauContamination, int capacite) 
	{
		this.nom = nom;

		this.point = point;
		
		this.niveauContamination = niveauContamination;

		this.capacite = capacite;
		existence = true;
		fonction = "Case";
		etatCitoyenBloque = false;
	}

	/** @brief Obtenir le nom de la case
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return String
	 */
	public String getNom()
	{
		return this.nom;
	}

    /** @brief Obtenir les coordonnees du citoyen
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return Point
	 */
	public Point getCoordonnees()
	{
		return point;
	}
	
	/** @brief Obtenir le niveau de contamination
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return double
	 */
	public double getNiveauContamination()
	{
		return niveauContamination;
	}
	
	/** @brief Obtenir la capacite
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return int
	 */
	public int getCapacite()
	{
		return capacite;
	}
	
	/** @brief Obtenir l'existence
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return boolean
	 */
	public boolean getExistence()
	{
		return existence;
	}
	
	/** @brief Obtenir la fonction de la case
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return String
	 */
	public String getFonction()
	{
		return fonction;
	}
	
	/** @brief Modifier le nom du citoyen
	 *  @since 1.0.0
	 *  @param  String <b>nom</b> Le nom du citoyen
	 *  @return rien
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	/** @brief Modifier les coordonnees
	 *  @since 1.0.0
	 *  @param  Point <b>point</b> Les coordonnees
	 *  @return rien
	 */
	public void setCoordonnees(Point point)
	{
		this.point = point;
	}
	
	/** @brief Modifier le niveau de contamination
	 *  @since 1.0.0
	 *  @param  double <b>niveauContamination</b> Le niveau de contamination
	 *  @return rien
	 */
	public void setNiveauContamination(double niveauContamination)
	{
		this.niveauContamination = niveauContamination;
	}
	
	/** @brief Modifier la capacite
	 *  @since 1.0.0
	 *  @param  int <b>capacite</b> La capacite
	 *  @return rien
	 */
	public void setCapacite(int capacite)
	{
		this.capacite = capacite;
	}
	
	/** @brief Modifier l'existence
	 *  @since 1.0.0
	 *  @param  boolean <b>etat</b> L'existence
	 *  @return rien
	 */
	public void setExistence(boolean etat)
	{
		this.existence = etat;
	}
	
	/** @brief Modifier la fonction de la case
	 *  @since 1.0.0
	 *  @param  String <b>fonction</b> Fonction de la case
	 *  @return rien
	 */
	public void setFonction(String fonction)
	{
		this.fonction = fonction;
	}
	
	
	/** @brief Obtenir l'etat si un citoyen n'a pas pu entrer dans l'hopital, s'il a ete bloque, on retourne true, sinon false
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return boolean
	 */
	public boolean getEtatCitoyenBloque()
	{
		return etatCitoyenBloque;
	}
	
	/** @brief Modifier l'etat si un citoyen n'a pas pu entrer dans l'hopital
	 *  @since 1.0.0
	 *  @param  boolean <b>etatCitoyenBloque</b> l'etat si un citoyen n'a pas pu entrer dans l'hopital
	 *  @return rien
	 */
	public void setEtatCitoyenBloque(boolean etatCitoyenBloque)
	{
		this.etatCitoyenBloque = etatCitoyenBloque;
	}

	/** @brief toString, transmettre toutes les informations aux chaines de caracteres
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return String
	 */
	public String toString()
	{
		String ret = "";
		ret += "NOM = [" + this.nom+"]";
		ret += " a ("+this.point.getLigne()+", "+this.point.getColonne()+")\n";
		ret += "Niveau de contamination = ["+this.niveauContamination+"]\n";
		ret += "Capacite = ["+this.capacite+"]\n";
		return ret;
	}
	
	
	
	/** @brief Verification de si sa capacite est correcte, si correcte, on retourne true, sinon, false
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return boolean
	 */
	public boolean verifCapacite()
	{
		int min = 0, max = 0;
		if(fonction.equals("Caserne"))
		{
			min = 4;
			max = 8;
		}
		
		if(fonction.equals("Maison"))
		{
			min = 3;
			max = 6;
		}
		
		if(fonction.equals("Hopital"))
		{
			min = 8;
			max = 12;
		}
		
		if(fonction.equals("TerrainVague"))
		{
			min = 4;
			max = 16;
		}
		
		
		if(this.getCapacite()>=min && this.getCapacite()<=max ) return true;
		else
		{
			return false;
		}
	}
	
	/** @brief Verification de si son niveau de contamination est correct si correct, on retourne true, sinon false
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return boolean
	 */
	public boolean verifNiveauContamination()
	{
		double min = 0, max = 1;
				
		if(this.getNiveauContamination()>=min && this.getNiveauContamination()<=max ) return true;
		else
		{
			if(this.getNiveauContamination()<min) this.setNiveauContamination(0);
			if(this.getNiveauContamination()>max) this.setNiveauContamination(1);
			return false;
		}
	}
	
	//======================== Test =======================================		
	//Programme Principal
	public static void main(String[] args)
	{
		Point point_test = new Point(2,2);
		double niveauContamination_test = 0;
		int capacite = 2;
		Case c = new Case("Chales",point_test,niveauContamination_test,capacite);		
		
		System.out.println("INFORMATIONS");
		System.out.println(c.toString());
	}
}
