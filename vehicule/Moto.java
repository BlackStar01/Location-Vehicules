package vehicule;

public class Moto extends Vehicule {
    
    private String cylindre;

    public Moto(String cylindre, String marque)
    {
        super(marque);
        this.cylindre = cylindre;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCylindre : " + this.cylindre;
    }
}
