/**
 * \file Ville.java
 * \brief La Classe Ville
 * \author Teng FAN
 * \version 1.0
 * \date 3 decembre 2014
 *
 *
 */  


public class Ville {
	protected Case tabCase[][] = new Case[7][7];
	protected Citoyen tabCitoyen[] = new Citoyen[70];
	
	/** @brief Constructeur de la ville, 1 Hopital, 2 Carsernes, 12 maisons et 34 TVs
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */	
	public Ville() 
	{
		//Initialisation des cases dans la ville
		initCases();
		initCitoyens();
		verifVilleCapacite();
		verifVilleNiveauContamination();
		verifVilleProbaTransmettre();
		verifVilleRisqueMaladie();
		verifVilleRisqueMortalite();
	}
	
	/** @brief Initialisation des cases dans la ville, 1 Hopital, 2 Carsernes, 12 maisons et 34 TVs
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */	
	public void initCases()
	{
		//Initialisation le tableau des points
		Point point[][] = new Point[7][7];
		int ligne,colonne;
		GeneAlea generateur = new GeneAlea();
		
		//Initialisation d'1 hopital (3,3) et 2 casernes (6,0) et (0,6)
		point[3][3] = new Point(3,3);
		tabCase[3][3] = new Hopital("CHU de Caen", point[3][3], 0, 8+(generateur.AleaInt()%5));
		
		point[0][6] = new Point(0,6);
		tabCase[0][6] = new Caserne("Caserne Sud-Ouest", point[0][6], 0, 4+(generateur.AleaInt()%5));
		
		point[6][0] = new Point(6,0);
		tabCase[6][0] = new Caserne("Caserne Nord-Est", point[6][0], 0, 4+(generateur.AleaInt()%5));

		//12 maisons et 34 terrains vagues en aleatoires		
		int nbreMaison = 12;
		int nbreTV = 34;
		int count=0; //Counter
		
		boolean occupee	= false;
		
		int inLigne = -1;
		int inColonne = -1;
		
		while(count<(nbreMaison + nbreTV))
		{
			//Creations des nouveaux coordonnees aleatoires
			inLigne = generateur.AleaInt()%7;
			inColonne = generateur.AleaInt()%7;

			//Verification si la place est deja occupee par une case
			for(ligne=0;ligne<7;ligne++)
			{
				for(colonne=0;colonne<7;colonne++)
				{										
					if(tabCase[inLigne][inColonne] == null)
					{
						occupee = false;
					}
					else
					{
						occupee = true;
					}
				}
			}
			
			//Creation de maisons et de TVs
			if(occupee == false)
			{
				if(point[inLigne][inColonne] == null)
				{
					point[inLigne][inColonne] = new Point(inLigne,inColonne);
				}
				
				if(count<nbreMaison)
				{
					String nom = "Maison "+count;
					tabCase[inLigne][inColonne] = new Maison(nom, point[inLigne][inColonne], 0, 3+(generateur.AleaInt()%4));
				}
				else
				{
					//Seulement 10% de TVs sont contamines
					if(count>=nbreMaison && count < nbreMaison+3)
					{
						String nom = "TerrainVague "+(count-nbreMaison);
						tabCase[inLigne][inColonne] = new TerrainVague(nom, point[inLigne][inColonne], 0.2+(generateur.AleaDouble()%0.2), 4+(generateur.AleaInt()%13));
					}
					//TVs non-contamines
					else
					{
						String nom = "TerrainVague "+(count-nbreMaison);
						tabCase[inLigne][inColonne] = new TerrainVague(nom, point[inLigne][inColonne], 0, 4+(generateur.AleaInt()%13));
					}
				}
				count++;
			}
			occupee = false;	
		}
	}
	
	/** @brief Initialisation des Citoyen dans la ville, 8 Medecin, 12 Pompier et 50 simples Citoyen
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */	
	public void initCitoyens()
	{
		//Initialisation le tableau des points
		Point point[][] = new Point[7][7];
		int ligne,colonne;
		GeneAlea generateur = new GeneAlea();
		
		//12 maisons et 34 terrains vagues en aleatoires		
		int nbreMedecin = 8;
		int nbrePompier = 12;
		int nbreSimpleCitoyen = 50;
		int count=0; //Counter
		
		boolean remplie	= false;
		
		int inLigne = -1;
		int inColonne = -1;
		
		while(count<(nbreMedecin + nbrePompier + nbreSimpleCitoyen))
		{
			//Creations des nouveaux coordonnees aleatoires
			inLigne = generateur.AleaInt()%7;
			inColonne = generateur.AleaInt()%7;

			//Verification si la case est deja remplie
			remplie = verifCaseRempliee(inLigne,inColonne);
			
			//Creation de maisons et de TVs
			if(remplie == false)
			{
				if(point[inLigne][inColonne] == null)
				{
					point[inLigne][inColonne] = new Point(inLigne,inColonne);
				}
				
				if(count<nbreMedecin)
				{
					String nom = "Medecin "+count;
					double niveauContamination = generateur.AleaDouble();
					double risqueMaladie = niveauContamination;
					double probaTransmettre = 0;
					double risqueMortalite = 0;
					String fonction = "Medecin";
					boolean existence = true;
					int nbreKits;
					
					if(point[inLigne][inColonne].equals(tabCase[3][3]))
					{
						nbreKits = 10;
						tabCitoyen[count] = new Medecin(nom,point[inLigne][inColonne],niveauContamination,risqueMaladie,probaTransmettre,risqueMortalite,fonction,existence,nbreKits);
					}
					else
					{
						nbreKits = 5;
						tabCitoyen[count] = new Medecin(nom,point[inLigne][inColonne],niveauContamination,risqueMaladie,probaTransmettre,risqueMortalite,fonction,existence,nbreKits);
					}
				}
				else
				{
					if(count>=nbreMedecin && count <(nbreMedecin+nbrePompier))
					{
						String nom = "Pompier "+count;
						double niveauContamination = generateur.AleaDouble();
						double risqueMaladie = niveauContamination;
						double probaTransmettre = 0;
						double risqueMortalite = 0;
						String fonction = "Pompier";
						boolean existence = true;
						int appareil = 1;
						double pulverisateur;
						
						if(point[inLigne][inColonne].equals(tabCase[0][6].getCoordonnees()) || point[inLigne][inColonne].equals(tabCase[6][0].getCoordonnees()))
						{
							pulverisateur = 10;
							tabCitoyen[count] = new Pompier(nom,point[inLigne][inColonne],niveauContamination,risqueMaladie,probaTransmettre,risqueMortalite,fonction,existence,pulverisateur);
						}
						else
						{
							pulverisateur = 5;
							tabCitoyen[count] = new Pompier(nom,point[inLigne][inColonne],niveauContamination,risqueMaladie,probaTransmettre,risqueMortalite,fonction,existence,pulverisateur);
						}	
					}
					else
					{
						String nom = "Simple Citoyens "+count;
						double niveauContamination = generateur.AleaDouble();
						double risqueMaladie = niveauContamination;
						double probaTransmettre = 0;
						double risqueMortalite = 0;
						boolean existence = true;
						
						tabCitoyen[count] = new Citoyen(nom,point[inLigne][inColonne],niveauContamination,risqueMaladie,probaTransmettre,risqueMortalite);
					}
				}
				count++;
			}
			remplie = false;	
		}
		
	}
	
	/** @brief Obtenir la case qu'on veut
	 *  @since 1.0.0
	 *  @param  int <b>ligne</b> La ligne  int <b>colonne</b> La colonne
	 *  @return Case
	 */
	public Case getCase(int ligne,int colonne)
	{
		return tabCase[ligne][colonne];
	}
	
	/** @brief Obtenir le tableau de toutes les cases
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return Case []
	 */
	public Case [][] getTabCase()
	{
		return tabCase;
	}
	
	/** @brief Obtenir le citoyen qu'on veut
	 *  @since 1.0.0
	 *  @param  int <b>count</b> Le numero du citoyen
	 *  @return Citoyen
	 */
	public Citoyen getCitoyenParNumero(int count)
	{
		return tabCitoyen[count];
	}
	
	/** @brief Obtenir les citoyens dans la meme case qu'on veut
	 *  @since 1.0.0
	 *  @param  int <b>ligne</b> La ligne int <b>colonne</b> La colonne 
	 *  @return Citoyen []
	 */
	public Citoyen [] getCitoyenParCase(int ligne,int colonne)
	{
		Citoyen [] c_ret; //Numeros des citoyens
		int count = 0;
		Point p2 = tabCase[ligne][colonne].getCoordonnees();
		for(int i=0;i<70;i++)
		{
			Point p1 = tabCitoyen[i].getCoordonnees();
			if(p1.equals(p2)) 
			{
				count++;
			}
		}
		c_ret = new Citoyen[count];
		count = 0;
		for(int i=0;i<70;i++)
		{
			Point p1 = tabCitoyen[i].getCoordonnees();
			if(p1.equals(p2))
			{
				c_ret[count] = tabCitoyen[i];
				count++;
			}
		}
		
		return c_ret;
	}
	
	/** @brief Obtenir le tableau de tous les citoyens qu'on veut
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return Citoyen []
	 */
	public Citoyen [] getTabCitoyen()
	{
		return tabCitoyen;
	}
	
	/** @brief Verifier si toutes les cas ont les capacites correctes
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */
	public void verifVilleCapacite()
	{
		int i,j;
		for(i=0;i<7;i++)
		{
			for(j=0;j<7;j++)
			{
				if(tabCase[i][j]!=null)
				{
					if(!tabCase[i][j].verifCapacite()) System.out.println("ERREUR de capacite dans "+tabCase[i][j].getNom());
				}
			}
		}
	}
	
	/** @brief Verifier si tous les citoyens et toutes les cases ont les niveaux de contamination corrects
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */
	public void verifVilleNiveauContamination()
	{
		int i,j;
		for(i=0;i<7;i++)
		{
			for(j=0;j<7;j++)
			{
				if(tabCase[i][j]!=null)
				{
					if(!tabCase[i][j].verifNiveauContamination()) System.out.println("ERREUR de niveau de contamination dans la case"+tabCase[i][j].getNom());
				}
			}
		}
		
		for(i=0;i<70;i++)
		{
			if(tabCitoyen[i]!=null)
			{
				if(!tabCitoyen[i].verifNiveauContamination()) System.out.println("ERREUR de niveau de contamination dans le citoyen"+tabCitoyen[i].getNom());
			}
		}
	}
	
	/** @brief Verifier si tous les citoyens ont les probabilites de transmettre correctes
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */
	public void verifVilleProbaTransmettre()
	{
		int i;	
		for(i=0;i<70;i++)
		{
			if(tabCitoyen[i]!=null)
			{
				if(!tabCitoyen[i].verifProbaTransmettre()) System.out.println("ERREUR de probabilite de transmettre dans le citoyen"+tabCitoyen[i].getNom());
			}
		}
	}
	
	/** @brief Verifier si tous les citoyens ont les risques de maladie corrects
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */
	public void verifVilleRisqueMaladie()
	{
		int i;	
		for(i=0;i<70;i++)
		{
			if(tabCitoyen[i]!=null)
			{
				if(!tabCitoyen[i].verifRisqueMaladie()) System.out.println("ERREUR de risque de maladie dans le citoyen"+tabCitoyen[i].getNom());
			}
		}
	}
	
	/** @brief Verifier si tous les citoyens ont les risques de mortalite corrects
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */
	public void verifVilleRisqueMortalite()
	{
		int i;	
		for(i=0;i<70;i++)
		{
			if(tabCitoyen[i]!=null)
			{
				if(!tabCitoyen[i].verifRisqueMortalite()) System.out.println("ERREUR de risque de mortalite dans le citoyen"+tabCitoyen[i].getNom());
			}
		}
	}
	
	/** @brief Verifier si la case est deja remplie, si remplie, on retourne true, sinon false
	 *  @since 1.0.0
	 *  @param  int <b>ligne</b> La ligne  int <b>colonne</b> La colonne
	 *  @return rien
	 */
	public boolean verifCaseRempliee(int ligne, int colonne)
	{
		int capacite = tabCase[ligne][colonne].getCapacite();
		Point point = new Point(ligne,colonne);
		int count = 0;
		for(int i=0;i<70;i++)
		{
			if(tabCitoyen[i] != null && tabCitoyen[i].getExistence() == true)
			{
				if(tabCitoyen[i].getCoordonnees().equals(point) && tabCitoyen[i].getExistence()) count++;
			}
			
			if(count>=capacite) 
			{
				return true;
			}
		}
		return false;
	}
	
	/** @brief Verifier si les deux cases sont voisines ou pas, si elles sont voisines, on retourne true, sinon false
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return boolean
	 */
	public boolean verifVoisinage2cases(Case c1,Case c2)
	{
		Point p1 = c1.getCoordonnees();
		Point p2 = c2.getCoordonnees();
	
		if(p1.distance(p2)<=(float)Math.sqrt(2))
		{
			if(p1.equals(p2)) return false;
			else return true;
		}
		return false;
	}
	
	/** @brief Deplacement des citoyens par un tour
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */
	public void deplacerCitoyensParTour()
	{
		GeneAlea generateur = new GeneAlea();
		int inLigne = -1,inColonne = -1;
		boolean remplie = false;
		int count = 0;
		while(count<70)
		{
			if(tabCitoyen[count].getExistence() == true)
			{
				Point p_Citoyen = tabCitoyen[count].getCoordonnees();
				
				//Dans le 60% des cas, il reste dans la meme case et dans 40% des cas, ils se deplaceront aleatoirement sur l'une des 8 cases voisines				
				do
				{
					if(generateur.AleaDouble()<0.60 && tabCitoyen[count].getJoursGueris()<5 && tabCase[p_Citoyen.getLigne()][p_Citoyen.getColonne()].getFonction() == "Hopital") //Si le citroyen sauf le medecin est gueri depuis 5 jours, il ne peut plus rester ид l'hopital
					{
						inLigne = p_Citoyen.getLigne();
						inColonne = p_Citoyen.getColonne();
						tabCitoyen[count].setEtatChangeCase(false);
						//S'il est gueri mais depuis moins de 5 jours(0<joursGueris<5), il peut rester mais le joursGueris augmente par tour
						if(tabCase[inLigne][inColonne].getFonction() == "Hopital" && tabCitoyen[count].getJoursGueris() > 0) 
						{
							tabCitoyen[count].setJoursGueris(tabCitoyen[count].getJoursGueris()+1);
						}
					}
					
					else
					{
						do
						{
							//A l'interieur
							if(p_Citoyen.getLigne()<6 && p_Citoyen.getLigne()>0 && p_Citoyen.getColonne()<6 && p_Citoyen.getColonne()>0)
							{
								inLigne = p_Citoyen.getLigne() + (generateur.AleaInt()%3 - 1);
								inColonne = p_Citoyen.getColonne() + (generateur.AleaInt()%3 - 1);
							}
							else
							{
								//Dans les 4 coins
								if(p_Citoyen.getLigne() == 0 && p_Citoyen.getColonne()==0)
								{
									inLigne = p_Citoyen.getLigne() + generateur.AleaInt()%2;
									inColonne = p_Citoyen.getColonne() + generateur.AleaInt()%2;
								}
								if(p_Citoyen.getLigne() == 6 && p_Citoyen.getColonne()==6)
								{
									inLigne = p_Citoyen.getLigne() - generateur.AleaInt()%2;
									inColonne = p_Citoyen.getColonne() - generateur.AleaInt()%2;
								}
								if(p_Citoyen.getLigne() == 0 && p_Citoyen.getColonne()==6)
								{
									inLigne = p_Citoyen.getLigne() + generateur.AleaInt()%2;
									inColonne = p_Citoyen.getColonne() - generateur.AleaInt()%2;
								}
								if(p_Citoyen.getLigne() == 6 && p_Citoyen.getColonne()==0)
								{
									inLigne = p_Citoyen.getLigne() - generateur.AleaInt()%2;
									inColonne = p_Citoyen.getColonne() + generateur.AleaInt()%2;
								}
								//Les restes
								if(p_Citoyen.getLigne() == 0 && p_Citoyen.getColonne()<6 && p_Citoyen.getColonne()>0)
								{
									inLigne = p_Citoyen.getLigne() + generateur.AleaInt()%2;
									inColonne = p_Citoyen.getColonne() + generateur.AleaInt()%3-1;
								}
								if(p_Citoyen.getLigne() == 6 && p_Citoyen.getColonne()<6 && p_Citoyen.getColonne()>0)
								{
									inLigne = p_Citoyen.getLigne() - generateur.AleaInt()%2;
									inColonne = p_Citoyen.getColonne() + generateur.AleaInt()%3-1;
								}
								if(p_Citoyen.getLigne() > 0 && p_Citoyen.getLigne() < 6 && p_Citoyen.getColonne()==6)
								{
									inLigne = p_Citoyen.getLigne() + generateur.AleaInt()%3-1;
									inColonne = p_Citoyen.getColonne() - generateur.AleaInt()%2;
								}
								if(p_Citoyen.getLigne() > 0 && p_Citoyen.getLigne() < 6 && p_Citoyen.getColonne()==0)
								{
									inLigne = p_Citoyen.getLigne() + generateur.AleaInt()%3-1;
									inColonne = p_Citoyen.getColonne() + generateur.AleaInt()%2;
								}
							}
						}while(inLigne == p_Citoyen.getLigne() && inColonne == p_Citoyen.getColonne());
						
						tabCitoyen[count].setEtatChangeCase(true);
						//Si on reste encore dans la meme case, nous re-choisira une autre case aleatoire
					}
					
					remplie = verifCaseRempliee(inLigne,inColonne);
					
					//Si le citoyen malade n'a pas pu d'entrer dans l'hopital, alors on note que l'etatCitoyenBoque soit true
					if(remplie == true && tabCase[inLigne][inColonne].getFonction() == "Hopital" && tabCitoyen[count].getJoursMalades() > 0)
					{
						tabCase[inLigne][inColonne].setEtatCitoyenBloque(true);
					}
					
					if(tabCitoyen[count].getEtatChangeCase() == false) remplie = false;
					
				}while(remplie);
				
				Point p_new_Citoyen = new Point(inLigne,inColonne);
				tabCitoyen[count].setCoordonnees(p_new_Citoyen);
				count++;
			}
		}
	}	
	
	/** @brief Calculer les niveaux de contamination de toutes les citoyens par un tour
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */
	public void calculNiveauContaminationCitoyenParTour()
	{
		for(int i=0;i<70;i++)
		{
			if(tabCitoyen[i].getFonction() == "Pompier")
			{
				Point p = tabCitoyen[i].getCoordonnees();
				if(tabCitoyen[i].getEtatChangeCase() == true)
				{
					tabCitoyen[i].setNiveauContamination(tabCitoyen[i].getNiveauContamination()+tabCase[p.getLigne()][p.getColonne()].getNiveauContamination()*0.02/10);
				}
				else
				{
					tabCitoyen[i].setNiveauContamination(tabCitoyen[i].getNiveauContamination()+tabCase[p.getLigne()][p.getColonne()].getNiveauContamination()*0.05/10);
				}
				
				if(tabCase[p.getLigne()][p.getColonne()].getFonction() == "Caserne")
				{
					tabCitoyen[i].setNiveauContamination(tabCitoyen[i].getNiveauContamination()-0.2);
				}
			}
			
			else
			{
				Point p = tabCitoyen[i].getCoordonnees();
				if(tabCitoyen[i].getEtatChangeCase() == true)
				{
					tabCitoyen[i].setNiveauContamination(tabCitoyen[i].getNiveauContamination()+tabCase[p.getLigne()][p.getColonne()].getNiveauContamination()*0.02);
				}
				else
				{
					tabCitoyen[i].setNiveauContamination(tabCitoyen[i].getNiveauContamination()+tabCase[p.getLigne()][p.getColonne()].getNiveauContamination()*0.05);
				}
				
				if(tabCase[p.getLigne()][p.getColonne()].getFonction() == "Caserne")
				{
					tabCitoyen[i].setNiveauContamination(tabCitoyen[i].getNiveauContamination()-0.2);
				}
			}
		}
	}

	/** @brief Calculer les niveaux de contamination de toutes les cases par un tour
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */
	public void calculNiveauContaminationCaseParTour()
	{
		double tau = 0;
		GeneAlea generateur = new GeneAlea();
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{
				if(tabCase[i][j].getFonction() == "Maison")
				{
					Citoyen[] c_ret = getCitoyenParCase(i,j);
					for(int k=0;k<c_ret.length;k++)
					{
						tabCase[i][j].setNiveauContamination(tabCase[i][j].getNiveauContamination()+0.01*c_ret[k].getNiveauContamination());
					}
				}
				if(tabCase[i][j].getFonction() == "Hopital")
				{
					Citoyen[] c_ret = getCitoyenParCase(i,j);
					for(int k=0;k<c_ret.length;k++)
					{
						tabCase[i][j].setNiveauContamination(tabCase[i][j].getNiveauContamination()+0.01/4*c_ret[k].getNiveauContamination());
					}
				}
				if(tabCase[i][j].getFonction() == "TerrainVague")
				{
					for(int ligne=0;ligne<7;ligne++)
					{
						for(int colonne=0;colonne<7;colonne++)
						{
							if(verifVoisinage2cases(tabCase[i][j],tabCase[ligne][colonne]) && tabCase[ligne][colonne].getFonction() == "TerrainVague")
							{
								if(generateur.AleaDouble()<0.15 && tabCase[i][j].getNiveauContamination()>tabCase[ligne][colonne].getNiveauContamination())
								{
									tau = generateur.AleaDouble()%0.19+0.01;
									tabCase[ligne][colonne].setNiveauContamination(tabCase[ligne][colonne].getNiveauContamination()+tau*tabCase[i][j].getNiveauContamination());
								}
							}
						}
					}
				}
			}
		}
	}


	
	//======================== Test =======================================		
	//Programme Principal
	public static void main(String[] args)
	{
		EcritureTrace CaenInfo = new EcritureTrace("CaenInfo");
		Ville Caen = new Ville();
		int ligne = 0, colonne = 0;
		CaenInfo.WriteIn("La list des cases");
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{
				ligne= i;
				colonne=j;
				System.out.println(Caen.getCase(i,j).toString());
				CaenInfo.WriteIn(Caen.getCase(i,j).toString());	
			}
		}
		
		
		System.out.println("Test de la modification de niveau de contamination");
		Caen.getCase(ligne,colonne).setNiveauContamination(0.25);
		System.out.println(Caen.getCase(ligne,colonne).toString()+"\n\n");
		
		System.out.println("Test du voisinage");
		if(Caen.verifVoisinage2cases(Caen.getCase(1,1),Caen.getCase(0,1))) System.out.println("Voisinage : oui");
		else System.out.println("Voisinage : non\n");
		
		if(Caen.verifVoisinage2cases(Caen.getCase(0,0),Caen.getCase(0,0))) System.out.println("Voisinage : oui");
		else System.out.println("Voisinage : non\n");
		
		if(Caen.verifVoisinage2cases(Caen.getCase(1,1),Caen.getCase(0,0))) System.out.println("Voisinage : oui");
		else System.out.println("Voisinage : non\n");
		
		if(Caen.verifVoisinage2cases(Caen.getCase(2,2),Caen.getCase(0,0))) System.out.println("Voisinage : oui");
		else System.out.println("Voisinage : non\n");
		
		System.out.println("Test du getTabCitoyen");
		CaenInfo.WriteIn("\n\nLa liste des citoyens");
		for(int i=0;i<70;i++)
		{
			System.out.println(Caen.getTabCitoyen()[i].toString());
			CaenInfo.WriteIn(Caen.getTabCitoyen()[i].toString());
		}
		CaenInfo.CloseWriteIn();
		
		System.out.println("Test du getCitoyenParCase");
		Citoyen c_ret[] = Caen.getCitoyenParCase(1, 0);
		for(int i=0;i<c_ret.length;i++)
		{
			System.out.println(c_ret[i].getNom());
		}
		
		
		Caen.deplacerCitoyensParTour();
		
		Caen.calculNiveauContaminationCaseParTour();
		Caen.calculNiveauContaminationCitoyenParTour();
		
		System.out.println("Test du getCitoyenParCase");
		Citoyen c_ret2[] = Caen.getCitoyenParCase(1, 0);
		for(int i=0;i<c_ret2.length;i++)
		{
			System.out.println(c_ret2[i].toString());
		}
	}
}
