package org.example.presentation;

import org.example.Exceptions.CompteInexistantException;
import org.example.Exceptions.FondsInsuffisantsException;
import org.example.metier.CompteBancaire;
import org.example.metier.CompteCourant;
import org.example.metier.CompteEpargne;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        ArrayList<CompteBancaire> comptes = new ArrayList<>();

        // Ajout de comptes
        CompteBancaire compteBancaire = new CompteBancaire(1, 1000, "Toto");
        CompteBancaire compteCourant = new CompteCourant(2, 2000, "Titi", 500);
        CompteBancaire compteEpargne = new CompteEpargne(3, 3000, "Tutu", 2);
        comptes.add(compteBancaire);
        comptes.add(compteCourant);
        comptes.add(compteEpargne);

        // Suppression de compte
        //comptes.remove(compteBancaire);

        // Opérations sur les comptes
        try {
            compteBancaire.depot(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            compteBancaire.retrait(200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            CompteBancaire.transferer(30000, compteCourant, compteEpargne);
        } catch (FondsInsuffisantsException | CompteInexistantException e) {
            System.out.println(e.getMessage());
        }

        ((CompteEpargne) compteEpargne).calculInteret();
        try {
            ((CompteCourant) compteCourant).autoriserDecouvert(2500);
        } catch (FondsInsuffisantsException e) {
            System.out.println(e.getMessage());
        }
    }
}
