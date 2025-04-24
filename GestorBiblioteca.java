import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorBiblioteca {
    // Propietats
    private List<Prestec> prestecs;

    // Constructors
    public GestorBiblioteca() {
        this.prestecs = new ArrayList<>();
    }

    // Metodes
    /**
     * Presta un llibre a un usuari.
     * @param Usuari usuari
     * @param Llibre llibre
     */
    public void prestarLlibre(Usuari usuari, Llibre llibre) {
        // Si el llibre no está prestat, es posa prestat, s'asigna l'usuari,
        // s'afegeix el llibre al usuari i s'imprimeix per pantalla el resultat.
        if (!llibre.esPrestat()) {
            llibre.prestar();
            Prestec prestec = new Prestec(usuari, llibre, LocalDate.now());
            prestecs.add(prestec);
            usuari.afegirLlibre(llibre);
            System.out.println(usuari.getNom() + " ha agafat el llibre: " + llibre.getTitol());
        } else {
            System.out.println("Aquest llibre ja està prestat.");
        }
    }

    /**
     * Comprova si hi ha estoc disponible del llibre.
     * @param llibreComprovar llibre
     * @return true si hi ha més d'una còpia, false altrament.
     */
    public boolean estocDisponible(Llibre llibreComprovar) {
        // Biblioteca i contador de quantitat disponible.
        List<Llibre> biblioteca = Biblioteca.getLlibres();
        int quantitat = 0;

        // Per cada llibre en la biblioteca, mirem si es el que busquem
        // i está disponible. Si es cumpleix, quantitat +1.
        for (Llibre llibre : biblioteca) {
            if (llibreComprovar.getTitol().equalsIgnoreCase(llibre) &&
                llibre.esPrestat == false) {

                quantitat++;
            }
        }

        // Imprimim la quantitat.
        System.out.println(llibreComprovar.getTitol() +  " Stock: " + quantitat);

        // La tornem.
        return quantitat;
    }
}