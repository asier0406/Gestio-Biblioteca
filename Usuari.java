import java.util.ArrayList;
import java.util.List;

public class Usuari {
    private String nom;
    private List<Llibre> llibresPrestats;
    private int prestecsActius;
    private static List<Usuari> usuaris = new ArrayList<>();
    
    public Usuari(String nom) {
        this.nom = nom;
        this.llibresPrestats = new ArrayList<>();

        usuaris.add(this);
    }

    //Modifica el nom del usuari
    public void modificarUsuari(String nomMod) {
        this.nom = nomMod;
    }

    // Eliminar usuari
    public void eliminarUsuari() {
        usuaris.remove(this);
    }

     // Listar tots els usuaris
     public static void llistarUsuaris() {
        for (Usuari u : usuaris) {
            System.out.println("Usuari: " + u.getNom());
        }
    }

    // Buscar usuari per el seu nom
    public static Usuari cercarUsuari(String nom) {
        for (Usuari u : usuaris) {
            if (u.getNom().equalsIgnoreCase(nom)) {
                return u;
            }
        }
        return null; // Retorna null si no es troba el usuari
    }

    public String getNom() { return nom; }
    public int getPrestecsActius() { return prestecsActius; }
    public void setPrestecsActius(int prestecsActius) { this.prestecsActius = prestecsActius; }
    public List<Llibre> getLlibresPrestats() { return llibresPrestats; }
    public void afegirLlibre(Llibre llibre) { 
        
        if (!llibre.esPrestat()) {
            llibresPrestats.add(llibre);
            llibre.prestar();
        } else {
            System.out.println("El llibre ja està prestat.");
        }
    }
    public void retornarLlibre(Llibre llibre) { llibresPrestats.remove(llibre); }
}