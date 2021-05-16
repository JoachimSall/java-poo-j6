package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.exception.DepartementInconnuException;
import fr.diginamic.exception.MinAboveMaxException;
import fr.diginamic.exception.NotNumberException;
import fr.diginamic.exception.UnderZeroException;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws NotNumberException, UnderZeroException, MinAboveMaxException, DepartementInconnuException {
			
		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();
		
		List<Ville> villes = rec.getVilles();
		int compteur = 0;
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equals(choix)) {
				compteur++;
			}
		}
		
		if (compteur == 0) {
			throw new DepartementInconnuException("Le code département n'a pas été trouvé");
		}

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine(); 
		
		if( !NumberUtils.isNumber(saisieMin)) {
			throw new NotNumberException("Vous devez rentrer un nombre !");
		} else if(Integer.parseInt(saisieMin) < 0) {
			throw new UnderZeroException("Vous devez rentrer un nombre supérieur à 0 !");
		}
		
		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();
		
		if(!NumberUtils.isNumber(saisieMax)) {
			throw new NotNumberException("Vous devez rentrer un nombre !");
		} else if(Integer.parseInt(saisieMax) < 0) {
			throw new UnderZeroException("Vous devez rentrer un nombre supérieur à 0 !");
		} else if(Integer.parseInt(saisieMax) < Integer.parseInt(saisieMin)) {
			throw new MinAboveMaxException("Le nombre maximum doit être supérieur au nombre minimum !");
		}

		int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;
		
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}
	}

}
