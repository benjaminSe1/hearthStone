package card.minion;

import card.Card;
import card.minion.state.State;
import card.minion.state.StateAttack;
import card.minion.state.StateDormir;

public abstract class Minion implements Card {

    private int PM;
    private String nom;
    private int PV;
    private int PD;

    private State stateSleep;
    private State stateAttack;
    private State stateCurrent;

    public Minion(String nom, int PM, int PD, int PV){
        this.PM = PM;
        this.nom = nom;
        //init du state
        this.stateAttack = new StateAttack(this);
        this.stateSleep = new StateDormir(this);
        this.stateCurrent = this.stateSleep;
        setDonnees(PV, PD);
    }

    public Minion() {
        this.PM = PM;
        this.nom = nom;
        //init du state
        this.stateAttack = new StateAttack(this);
        this.stateSleep = new StateDormir(this);
        this.stateCurrent = this.stateSleep;
        setDonnees(PV, PD);
    }

    public int getPV() {
        return PV;
        }

    public int getPD() {
        return PD;
        }

    public int getPM() {
        return PM;
        }

    public String getNom() {
        return nom;
        }

    public void setPM(int PM) {
        this.PM = PM;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    public void setPD(int PD) {
        this.PD = PD;
    }

    public boolean estReveille() {
        return stateCurrent.peutAttaquer();
        }

    public String toString() {
        return "Minion [" + nom + " - " + PM + "/" + PD + "/" + PV + " - " + stateCurrent + "]";
        }

    public void supprimerPV(int PV) {
        setDonnees(this.PV - PV, this.PD);
        }

    public void ajouterPV(int PV) {
        setDonnees(this.PV + PV, this.PD);
        }

    public void supprimerPD(int PD) {
        setDonnees(this.PV, (this.PD - PD >= 0 ? this.PD - PD : 0));
        }

    public void ajouterPD(int PD) {
        setDonnees(this.PV, this.PD + PD);
        }

    //méthodes du state

    public void changerEtatAttaquer() {
        stateCurrent = stateAttack;
        }

    public void changerEtatDormir() {
        stateCurrent = stateSleep;
        }

    public void setDonnees(int PV, int PD) {
        this.PV = PV;
        this.PD = PD;
    }

    public boolean charger() {
        return false;
    }

    public boolean volerVie() {
        return false;
    }

    public boolean encourager() {
        return false;
    }

    public boolean provoquer() {
        return false;
    }

    public boolean isSort() {
        return false;
    }

    public boolean isServiteur() {
        return true;
    }
}
