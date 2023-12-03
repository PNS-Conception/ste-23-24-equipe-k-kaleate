package fr.unice.polytech.kaleate.outils;

import java.util.Date;

public class Creneau {

    private Date debut;
    private Date fin;

    public Creneau(Date debut, Date fin){
        this.debut = debut;
        this.fin = fin;
    }

    public Date getDebut(){
        return this.debut;
    }

    public Date getFin(){
        return this.fin;
    }

    public void setDebut(Date debut){
        this.debut = debut;
    }

    public void setFin(Date fin){
        this.fin = fin;
    }

    // Retourne la durée du créneau en secondes
    public float getDuree(){
        return (this.fin.getTime() - this.debut.getTime()) * 1000f;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Creneau){
            Creneau creneau = (Creneau) obj;
            return this.debut.equals(creneau.getDebut()) && this.fin.equals(creneau.getFin());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.debut.hashCode() + this.fin.hashCode();
    }

    public boolean estComprisDansCreneau(Creneau creneau){
        return (this.debut.after(creneau.getDebut()) || this.debut.equals(creneau.getDebut()))
                &&
                (this.fin.before(creneau.getFin()) || this.fin.equals(creneau.getFin()));
    }

    public boolean chevaucheCreneau(Creneau creneau) {
        return this.debut.before(creneau.getFin()) && this.fin.after(creneau.getDebut());
    }

    @Override
    public String toString() {
        return this.getDebut() + " - " + this.getFin();
    }
}
