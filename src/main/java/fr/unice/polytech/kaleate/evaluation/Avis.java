package fr.unice.polytech.kaleate.evaluation;

public class Avis {
    private int note;
    private String commentaire;
    public Avis(int note, String commentaire){
        this.note=note;
        this.commentaire=commentaire;
    }

    public int getNote() {
        return note;
    }

    public String getCommentaire() {
        return commentaire;
    }
}
