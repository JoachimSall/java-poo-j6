package fr.diginamic.recensement.services;

import java.util.Scanner;

import fr.diginamic.exception.DepartementInconnuException;
import fr.diginamic.exception.MinAboveMaxException;
import fr.diginamic.exception.NotNumberException;
import fr.diginamic.exception.RegionInconnueException;
import fr.diginamic.exception.UnderZeroException;
import fr.diginamic.exception.VilleInconnueException;
import fr.diginamic.recensement.entites.Recensement;

/**
 * Classe représentant un service
 * 
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/**
	 * Méthode abstraite de traitement que doivent posséder toutes les méthodes de
	 * services
	 * 
	 * @param lignes  lignes du fichier
	 * @param scanner scanner
	 * @throws UnderZeroException 
	 * @throws MinAboveMaxException 
	 * @throws DepartementInconnuException 
	 * @throws VilleInconnueException 
	 * @throws RegionInconnueException 
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) throws NotNumberException, UnderZeroException, MinAboveMaxException, DepartementInconnuException, VilleInconnueException, RegionInconnueException;
}
