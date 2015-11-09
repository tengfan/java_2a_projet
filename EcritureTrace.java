/**
 * \file EcritureTrace.java
 * \brief La Classe Ecriture des Traces
 * \author Teng FAN
 * \version 1.0
 * \date 3 decembre 2014
 *
 *
 */  

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EcritureTrace
{
	File logFile;
	BufferedWriter out;
	/** @brief Constructeur
	 *  @since 1.0.0
	 *  @param  String nom
	 *  @return rien
	 */
	public EcritureTrace(String nom)
	{
		logFile = new File(nom+".txt");
		try {
			out = new BufferedWriter(new FileWriter(logFile));
		} catch (IOException e) {}
	}

	/** @brief Constructeur
	 *  @since 1.0.0
	 *  @param  String <b>nom</b> nom String <b>adresse</b> L'adresse de l'ecriture
	 *  @return rien
	 */
	public EcritureTrace(String nom, String adresse)
	{
		logFile = new File(adresse+"/"+nom+".txt");
		try {
			out = new BufferedWriter(new FileWriter(logFile));
		} catch (IOException e) {}
	}
	
	/** @brief Ecriture dans un fichier text
	 *  @since 1.0.0
	 *  @param  String <b>contenu</b>
	 *  @return rien
	 */
	public void WriteIn(String contenu)
	{
		try {
			out.write(contenu + "\n");
		}
		catch (IOException e) {}
	}
	
	/** @brief Fermeture de l'Ecriture dans un fichier text
	 *  @since 1.0.0
	 *  @param  rien
	 *  @return rien
	 */
	public void CloseWriteIn()
	{
		try {
			out.close();
		}
		catch (IOException e) {}
	}
}
