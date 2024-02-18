package org.example.metier;

import org.example.Exceptions.CompteInexistantException;
import org.example.Exceptions.FondsInsuffisantsException;

public class CompteBancaire {
    private long numCompte;
    protected double solde;
    private String nomTitulaire;

    public CompteBancaire(long numCompte, double solde, String nomTitulaire) {
        this.numCompte = numCompte;
        this.solde = solde;
        this.nomTitulaire = nomTitulaire;
    }

    public CompteBancaire() {
    }

    public void depot(double montant) {
        solde += montant;
        System.out.println("Le montant " + montant + " a été déposé avec succès");
    }

    public void afficherSolde() {
        System.out.println("Le solde du compte est de " + solde);
    }

    public void retrait(double montant) throws FondsInsuffisantsException {
        if (montant <= solde) {
            solde -= montant;
            System.out.println("Le montant " + montant + " a été retiré avec succès");
        } else {
            throw new FondsInsuffisantsException("Fonds insuffisants");
        }
    }

    public static void transferer(double montant, CompteBancaire compteDebuteur, CompteBancaire compteCrediteur) throws FondsInsuffisantsException, CompteInexistantException {
        if (compteCrediteur == null || compteDebuteur == null) {
            throw new CompteInexistantException("Compte inexistant");
        }
        System.out.println("Debut de transfert de " + montant + " entre les comptes " + compteDebuteur.numCompte + " et " + compteCrediteur.numCompte);
        compteDebuteur.retrait(montant);
        compteCrediteur.depot(montant);
        System.out.println("Le montant " + montant + " a été transféré avec succès entre les comptes "
                + compteDebuteur.numCompte + " et " + compteCrediteur.numCompte);
    }
}
