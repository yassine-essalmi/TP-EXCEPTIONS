package org.example.metier;

public class CompteEpargne extends CompteBancaire{
    private double tauxInteret;

    public CompteEpargne(long numCompte, double solde, String nomTitulaire, double tauxInteret) {
        super(numCompte, solde, nomTitulaire);
        this.tauxInteret = tauxInteret;
    }

    public CompteEpargne() {
    }

    public void calculInteret() {
        double interets = solde * tauxInteret / 100;
        solde += interets;
        System.out.println("Les intérêts de " + interets + " ont été ajoutés avec succès");
    }
}
