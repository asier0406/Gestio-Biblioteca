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

    /**
     * Presta un llibre si no esta prestat i crea un objecte prestec.
     * @param Usuari usuari
     * @param Llibre llibre
     */
    public void prestarLlibre(Usuari usuari, Llibre llibre) {
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

    public void controlarEstoc(String titol) {
        int contadorLlibresDisponibles = 0;

        for (Llibre llibre : getLlibres()) {
            if (llibre.getTitol().equalsIgnoreCase(titol) && !llibre.esPrestat()) {
                contadorLlibresDisponibles++;
            }
        }

        System.out.println("Hi han " + contadorLlibresDisponibles + " llibres disponibles del llibre [" + titol + "]");
    }
}