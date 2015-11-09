/**
 * \file Point.java
 * \brief La Classe Point
 * \author Teng FAN
 * \version 1.0
 * \date 23 octobre 2014
 *
 *
 */
  
public class Point
{
	private int ligne;
	private int colonne;
	
	/** @brief Constructeur permettant de creer le point (0,0)
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */
	public Point() 
	{
		ligne=0;
		colonne=0;
	}
	
	/** @brief Constructeur permettant de creer le point (ligne,colonne)
	 *  @since 1.0.0
	 *  @param  int <b>ligne</b> Valeur de ligne int <b>colonne</b> Valeur de colonne
	 *  @return rien
	 */	
	public Point(int ligne, int colonne)
	{
		this.ligne = ligne;
		this.colonne = colonne;
	}
	    
	    /** @brief Obtenir la ligne
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return int
	 */
	public int getLigne() 
	{
		return ligne;
	}
	
	/** @brief Obtenir la colonne
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return int
	 */
	public int getColonne() 
	{
		return colonne;
	}
	
	/** @brief Modifier les coordonnees
	 *  @since 1.0.0
	 *  @param  int <b>ligne</b> La colonne int <b>colonne</b> La colonne
	 *  @return rien
	 */
	public void setCoordonnees(int ligne,int colonne)
	{
		this.ligne = ligne;
		this.colonne = colonne;
	}

	/** @brief Afficher ce point 
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */	
	public void afficher()
	{
		System.out.println("Abscisse ligne = " +ligne+"; Ordonne colonne = "+colonne);
	}

	/** @brief Donner la distance entre ce point et un autre point passe
	 *  @since 1.0.0
	 *  @param  Point <b>p</b> un autre point
	 *  @return float Distance
	 */		
	public float distance(Point p)
	{
		int dligne = ligne - p.getLigne();
		int dcolonne = colonne - p.getColonne();
		float d = (float)Math.sqrt(dligne*dligne+dcolonne*dcolonne);
		return d;
	}
	
	/** @brief identique
	 *  @since 1.0.0
	 *  @param  Point <b>p</b> un autre point
	 *  @return boolean s'ils sont pareils, on retourne true sinon false
	 */		
	public boolean identique(Point p)
	{
		int dligne = ligne - p.getLigne();
		int dcolonne = colonne - p.getColonne();
		if(dligne ==0 && dcolonne ==0) return true; // Les deux points sont les memes
		else return false; //Les deux points ne sont pas les memes
	}

	/** @brief milieu
	 *  @since 1.0.0
	 *  @param  Point <b>p1</b> point 1 Point <b>p2</b> point 2
	 *  @return rien
	 */		
	public void milieu(Point p1, Point p2)
	{
		ligne = (p1.getLigne()+p2.getLigne())/2;
		colonne = (p1.getColonne()+p2.getColonne())/2;
	}
	/** @brief Comparateur
	 *  @since 1.0.0
	 *  @param  Point <b>p1</b> point
	 *  @return boolean si equal, on retourne true, sinon false
	 */	
	public boolean equals(Point p) 
	{
		return this.identique(p);
	}
	/** @brief toString
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return String
	 */		
	public String toString() 
	{
		return "#Point(" + ligne + ";" + colonne + ")";
	}
}


