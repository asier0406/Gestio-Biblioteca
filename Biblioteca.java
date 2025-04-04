import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // Propietats
    private List<Llibre> llibres;

    // Constructors
    public Biblioteca() {
        this.llibres = new ArrayList<>();
    }

    // Metodes
    /**
     * Afegeix un llibre a la biblioteca.
     * @param Llibre llibre
     */
    public void afegirLlibre(Llibre llibre) { llibres.add(llibre); }

    /**
     * Busca un llibre tenint en compte accents.
     * @param String titol
     */
    public Llibre buscarLlibre(String titol) {
        // Per cada llibre mira si es el llibre que busquem i el retorna.
        for (Llibre llibre : llibres) {
            if (llibre.getTitol().equalsIgnoreCase(titol)) {
                return llibre;
            }
        }
        return null;
    }

    /**
     * Retorna els llibres que hi ha.
     */
    public List<Llibre> getLlibres() { return llibres; }

    /**
     * Busca un llibre sense tindre en compte els accents.
     * @param String titol
     */
    public Llibre buscarLlibreSenseAccents(String titol) {
        buscarLlibre(eliminarAccents(titol));
    }

    /**
     * Elimina els accents del text.
     * @param String text
     */
    private void eliminarAccents(String text) {
        // El normalize separa els accents de les lleters
        // i el replace all elimina els accents separats.
        Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    }

    /**
     * Llista els llibres en la biblioteca.
     */
    public void llistarLlibres() {
        System.out.println("Llibres Biblioteca:");

        for (Llibre llibre : llibres) {
            System.out.println(llibre);
        }
    }
}