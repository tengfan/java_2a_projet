/**
 * \file Citoyen.java
 * \brief La Classe Citoyen
 * \author Teng FAN
 * \version 1.0
 * \date 3 decembre 2014
 *
 *
 */  


public class Citoyen 
{
	protected String nom;	
	protected Point point = new Point();
	protected double niveauContamination;
	protected String fonction;
	protected int joursMalades;
	protected double probaTransmettre;
	protected boolean etatMortalite;
	protected double risqueMortalite;
	protected double risqueMaladie;
	protected int joursGueris;
	protected boolean etatChangeCase;
	protected boolean existence;
	protected int joursHopital;
	
	protected double pulverisateur;
	protected int nbreKits;
	
    /** @brief Constructeur
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */
	public Citoyen() 
	{
		nom = "Anonyme";
		point.setCoordonnees(0,0);
		niveauContamination = 0;
		fonction = "Citoyen";
		
		joursGueris = 0;
		
		risqueMaladie = 0;
		joursMalades = 0;
		
		probaTransmettre = 0;
		
		risqueMortalite = 0;
		etatMortalite = false;
		etatChangeCase = false;
		existence = true;
		
		pulverisateur = 0;
		nbreKits = 0;
	}

    /** @brief Constructeur
	 *  @since 1.0.0
	 *  @param  String <b>nom</b> Le nom Point <b>point</b> Coordonnees du citoyen double <b>niveauContamination</b> Le niveau de contamination double <b>risqueMaladie</b> Risque d'etre malade double <b>probaTransmettre</b> La probabilite de transmettre le virus double <b>risqueMortalite</b> Le risque d'etre mort
	 *  @return rien
	 */
	public Citoyen(String nom, Point point,double niveauContamination,double risqueMaladie,double probaTransmettre,double risqueMortalite) 
	{
		this.nom = nom;
		
		this.point = point;
		
		this.niveauContamination = niveauContamination;
		fonction = "Citoyen";
		
		joursGueris = 0;
		
		this.risqueMaladie = risqueMaladie;
		joursMalades = 0;
		
		this.probaTransmettre = probaTransmettre;
		
		this.risqueMortalite = risqueMortalite;
		etatMortalite = false;
		etatChangeCase = false;
		existence = true;
		
		pulverisateur = 0;
		nbreKits = 0;
	}
	
	/** @brief Obtenir le nom du citoyen
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
	
	/** @brief Obtenir sa fonction
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return String
	 */
	public String getFonction()
	{
		return fonction;
	}
	
	/** @brief Obtenir le nombre de jours d'etre gueri
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return int
	 */
	public int getJoursGueris()
	{
		return joursGueris;
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
	
	/** @brief Obtenir la risque d'etre malade
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return double
	 */
	public double getRisqueMaladie()
	{
		return risqueMaladie;
	}
	
	/** @brief Obtenir le nombre de jours d'etre malade
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return int
	 */
	public int getJoursMalades()
	{
		return joursMalades;
	}
	
	/** @brief Obtenir la probabilite de transmettre le virus
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return double
	 */
	public double getProbaTransmettre()
	{
		return probaTransmettre;
	}
	
	/** @brief Obtenir la risque de mortalite
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return double
	 */
	public double getRisqueMortalite()
	{
		return risqueMortalite;
	}
	
	/** @brief Obtenir l'etat de mortalite
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return boolean
	 */
	public boolean getEtatMortalite()
	{
		return etatMortalite;
	}
	
	/** @brief Obtenir l'etat si le citoyen change sa case ou pas par rapport au dernier tour
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return boolean
	 */
	public boolean getEtatChangeCase()
	{
		return etatChangeCase;
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
	
	/** @brief Obtenir le reste du pulvarisateur du pompier
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return double
	 */
	public double getPulverisateur()
	{
		return pulverisateur;
	}
	
	/** @brief Obtenir le nbre de kits du medecin
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return int
	 */
	public int getNbreKits()
	{
		return nbreKits;
	}
	
	/** @brief Obtenir le nbre de jours qu'il reste dans l'hopital
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return int
	 */
	public int getjoursHopital()
	{
		return joursHopital;
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
	
	/** @brief Modifier sa fonction
	 *  @since 1.0.0
	 *  @param String [] <b>fonction</b> Sa fonction
	 *  @return rien
	 */
	public void setFonction(String fonction)
	{
		this.fonction = fonction;
	}
	
	/** @brief Modifier le nombre des jours gueris
	 *  @since 1.0.0
	 *  @param  int <b>joursGueris</b> Le nombre des jours gueris
	 *  @return rien
	 */
	public void setJoursGueris(int joursGueris)
	{
		this.joursGueris = joursGueris;
	}
	
	/** @brief Modifier la risque d'etre malade
	 *  @since 1.0.0
	 *  @param  double [] <b>risqueMaladie</b> La risque d'etre malade
	 *  @return rien
	 */
	public void setRisqueMaladie(double risqueMaladie)
	{
		this.risqueMaladie = risqueMaladie;
	}
	
	
	/** @brief Modifier le nombre des jours d'etre malade
	 *  @since 1.0.0
	 *  @param  int [] <b>joursMalades</b> Le nombre des jours d'etre malade
	 *  @return rien
	 */
	public void setJoursMalades(int joursMalades)
	{
		this.joursMalades = joursMalades;
	}
	
	/** @brief Modifier la probabilite de transmettre le virus
	 *  @since 1.0.0
	 *  @param  double <b>probaTransmettre</b> La probabilite de transmettre le virus
	 *  @return rien
	 */
	public void setProbaTransmettre(double probaTransmettre)
	{
		this.probaTransmettre = probaTransmettre;
	}
	
	/** @brief Modifier le niveau de contamination
	 *  @since 1.0.0
	 *  @param  double <b>niveauContamination</b> Le niveau de contamination
	 *  @return rien
	 */
	public void setNiveauContamination(double niveauContamination)
	{
		this.niveauContamination = niveauContamination;
		this.risqueMaladie = niveauContamination;
	}
	
	/** @brief Modifier la risque de mortalite
	 *  @since 1.0.0
	 *  @param  double <b>risqueMortalite</b> La risque de mortalite
	 *  @return rien
	 */
	public void setRisqueMortalite(double risqueMortalite)
	{
		this.risqueMortalite = risqueMortalite;
	}
	
	/** @brief Modifier l'etat de mortalite
	 *  @since 1.0.0
	 *  @param  boolean <b>etatMortalite</b> L'etat de mortalite
	 *  @return rien
	 */
	public void setEtatMortalite(boolean etatMortalite)
	{
		this.etatMortalite = etatMortalite;
	}
	
	/** @brief Obtenir l'etat si le citoyen change sa case ou pas par rapport au dernier tour
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return boolean
	 */
	public void setEtatChangeCase(boolean etatChangeCase)
	{
		this.etatChangeCase = etatChangeCase;
	}
	
	/** @brief Modifier le reste du pulverisateur du pompier
	 *  @since 1.0.0
	 *  @param  double <b>pulverisateur</b> le reste du pulverisateur du pompier
	 *  @return rien
	 */
	public void setPulverisateur(double pulverisateur)
	{
		this.pulverisateur = pulverisateur;
	}
	
	/** @brief Modifier le nbre de kits du medecin
	 *  @since 1.0.0
	 *  @param  int <b>nbreKits</b> le nbre de kits du medecin
	 *  @return rien
	 */
	public void setNbreKits(int nbreKits)
	{
		this.nbreKits = nbreKits;
	}
	
	/** @brief Modifier le nbre de jours qui reste au
	 *  @since 1.0.0
	 *  @param  int <b>nbreKits</b> le nbre de kits du medecin
	 *  @return rien
	 */
	public void setJoursHopital(int joursHopital)
	{
		this.joursHopital = joursHopital;
	}
	
	/** @brief Modifier l'existence
	 *  @since 1.0.0
	 *  @param  boolean <b>existence</b> L'etat d'existence
	 *  @return rien
	 */
	public void setExistence(boolean existence)
	{
		this.existence = existence;
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
	
	/** @brief Verification de si sa probabilite de transmettre est correct si correcte, on retourne true, sinon false
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return boolean
	 */
	public boolean verifProbaTransmettre()
	{
		double min = 0, max = 1;
				
		if(this.getProbaTransmettre()>=min && this.getProbaTransmettre()<=max ) return true;
		else
		{
			if(this.getProbaTransmettre()<min) this.setNiveauContamination(0);
			if(this.getProbaTransmettre()>max) this.setNiveauContamination(1);
			return false;
		}
	}
	
	/** @brief Verification de si son risque de maladie est correct si correct, on retourne true, sinon false
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return boolean
	 */
	public boolean verifRisqueMaladie()
	{
		double min = 0, max = 1;
				
		if(this.getRisqueMaladie()>=min && this.getRisqueMaladie()<=max ) return true;
		else
		{
			if(this.getRisqueMaladie()<min) this.setNiveauContamination(0);
			if(this.getRisqueMaladie()>max) this.setNiveauContamination(1);
			return false;
		}
	}
	
	/** @brief Verification de si son risque de mortalite est correct si correct, on retourne true, sinon false
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return boolean
	 */
	public boolean verifRisqueMortalite()
	{
		double min = 0, max = 1;
				
		if(this.getRisqueMortalite()>=min && this.getRisqueMortalite()<=max ) return true;
		else
		{
			if(this.getRisqueMortalite()<min) this.setNiveauContamination(0);
			if(this.getRisqueMortalite()>max) this.setNiveauContamination(1);
			return false;
		}
	}
	
	/** @brief toString, transmettre toutes les informations aux chaines de caracteres
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return String
	 */
	public String toString()
	{
		String mor;
		String exi;
		
		if(etatMortalite) mor = "OUI";
		else mor = "NON";
		
		if(existence) exi = "OUI";
		else exi = "NON";
		
		String phrase = "";
		phrase += fonction +" [" + nom+ "] a ("+point.getLigne()+", "+point.getColonne()+")\n";
		phrase += "Niveau de contamination = ["+niveauContamination+"]\n";
		phrase += "La risque de maladie = ["+risqueMaladie+"]\n";
		phrase += "La proba de transmettre le virus = ["+probaTransmettre+"]\n";
		phrase += "Le nbre des jours gueris = ["+joursGueris+"]\n";
		
		phrase += "Le nbre des jours malades = ["+joursMalades+"]\n";
		phrase += "La risque de mortalite = ["+risqueMortalite+"]\n";
		
		phrase += "L'etat de mortalite = ["+mor+"]\n";
		phrase += "L'existence = ["+exi+"]\n";
		
		return phrase;
	}
	
	//======================== Test =======================================		
	//Programme Principal
	public static void main(String[] args)
	{
		Point point_test = new Point(2,2);
		double niveauContamination_test = 0;
		double probaTransmettre_test = 0;
		double risqueMortalite_test = 0;
		double risqueMaladie_test = 0;
		Citoyen c = new Citoyen("FAN",point_test,niveauContamination_test,risqueMaladie_test,probaTransmettre_test,risqueMortalite_test);
		
		Point coord = new Point();
		coord = c.getCoordonnees();
		System.out.println("x = "+coord.getLigne()+": y = "+coord.getColonne());
		
		point_test.setCoordonnees(8,8);
		c.setCoordonnees(point_test);
		coord = c.getCoordonnees();
		System.out.println("x = "+coord.getLigne()+": y = "+coord.getColonne()+"\n");
		System.out.println("INFORMATIONS du citoyen");
		System.out.println(c.toString());
	}
}


