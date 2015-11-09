/**
 * \file GeneAlea.java
 * \brief La Classe GenerateurAleatoire
 * \author Teng FAN
 * \version 1.0
 * \date 3 decembre 2014
 *
 *
 */ 

import java.util.Random;

public class GeneAlea {
    protected Random randnum;

    public GeneAlea() 
    {
        randnum = new Random();
    }
    
	public int AleaInt() 
	{
		randnum.setSeed(System.nanoTime());
		return randnum.nextInt(1000);
	}
	
	public double AleaDouble() 
	{
		randnum.setSeed(System.nanoTime());
		return (double)(randnum.nextInt(1000))/1000;
	}
    
    //======================== Test =======================================		
	//Programme Principal
	public static void main(String[] args)
	{
		GeneAlea nbreAlea = new GeneAlea();
		double randnum = 0;
		for(int i=0;i<10;i++)
		{
			randnum = nbreAlea.AleaDouble();
			System.out.println(randnum);
		}
	}
}
