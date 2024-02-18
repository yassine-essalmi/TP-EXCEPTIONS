package org.example.metier;

import org.example.Exceptions.FondsInsuffisantsException;

public class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    public CompteCourant(long numCompte, double solde, String nomTitulaire, double decouvertAutorise) {
        super(numCompte, solde, nomTitulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    public CompteCourant() {
    }

    public void autoriserDecouvert(double montant) throws FondsInsuffisantsException {
        if (montant > decouvertAutorise + solde) {
            throw new FondsInsuffisantsException("Le montant demandé est supérieur au découvert autorisé");
        } else {
            solde -= montant;
            System.out.println("Le découvert de " + montant + " a été autorisé avec succès");
        }
    }


}
