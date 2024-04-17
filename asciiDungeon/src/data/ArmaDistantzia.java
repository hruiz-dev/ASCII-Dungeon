package data;

public class ArmaDistantzia extends Arma {

    private int munizioa;
    public ArmaDistantzia(Formak forma, Vector2 posizioa, String izena, int erabilerak, int atakea, int munizioa) {
        super(forma, posizioa, izena, erabilerak, atakea);
        this.munizioa = munizioa;
    }

    public int getMunizioa() {
        return munizioa;
    }

    public void setMunizioa(int munizioa) {
        this.munizioa = munizioa;
    }

    @Override
    void update() {
        //TODO: metodo honek armak munizioa badu bala bat disparatu du n direzioan
    }
}
