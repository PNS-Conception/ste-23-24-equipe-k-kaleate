package fr.unice.polytech.kaleate.Evaluation;

import java.util.HashMap;
import java.util.Map;

public abstract class Evaluable {
    Map<Evalueur, Avis> avis = new HashMap<>();

    public double getNote(){
        double res=0;
        for (Evalueur a : avis.keySet()){
            res+=avis.get(a).getNote();
        }
        return res/avis.size();
    }

    public Map<Evalueur, Avis> getAvis(){
        return avis;
    }

    public void nouvelAvis(Evalueur e, Avis a){
        avis.put(e,a);
    }
}
