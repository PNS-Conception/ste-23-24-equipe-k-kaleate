package fr.unice.polytech.kaleate;

public class Localisation {
    private float Latitude;
    private float Longitude;

    public Localisation(float latitude, float longitude) {
        Latitude = latitude;
        Longitude = longitude;
    }

    public boolean estDansLeRayonDe(Localisation l, float rayon){
        return Math.abs(Math.sqrt(Math.pow(l.getLatitude()-getLatitude(),2)+Math.pow(l.getLongitude()-getLongitude(),2)))<rayon;
    }

    public float getLatitude() {
        return Latitude;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }
}
