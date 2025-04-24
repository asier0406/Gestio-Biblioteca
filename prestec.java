import java.time.LocalDate;

public class Prestec {
    public static final int MAX_PRESTECS = 5; // Número màxim de préstecs per usuari
    private Usuari usuari;
    private Llibre llibre;
    private LocalDate dataPrestec;
    private LocalDate dataRetorn;
    private boolean retornat;

    public Prestec(Usuari usuari, Llibre llibre, LocalDate dataPrestec) {
        validarPrestec(usuari, llibre); // Validem si es pot fer el préstec

        this.usuari = usuari;
        this.llibre = llibre;
        this.dataPrestec = dataPrestec;
        this.dataRetorn = dataPrestec.plusWeeks(2); // Data de retorn automàtica (2 setmanes)
        this.retornat = false;

        incrementarPrestecs(usuari); // Incrementem el nombre de préstecs actius
        llibre.prestar();           // Marquem el llibre com prestat
    }

    private void validarPrestec(Usuari usuari, Llibre llibre) {
        if (!llibre.estaDisponible()) {
            throw new RuntimeException("El llibre " + llibre.getTitol() + " no està disponible.");
        }

        if (usuari.getNumPrestecsActius() >= MAX_PRESTECS) {
            throw new RuntimeException("L'usuari " + usuari.getNom() + " ha assolit el màxim de préstecs permès: " + MAX_PRESTECS);
        }
    }

    private void incrementarPrestecs(Usuari usuari) {
        usuari.setNumPrestecsActius(usuari.getNumPrestecsActius() + 1);
    }

    private void decrementarPrestecs(Usuari usuari) {
        if (usuari.getNumPrestecsActius() > 0) {
            usuari.setNumPrestecsActius(usuari.getNumPrestecsActius() - 1);
        }
    }

    public void returnarLlibre() {
        if (!retornat) {
            this.retornat = true; // Marquem el préstec com retornat
            decrementarPrestecs(usuari); // Reduïm el nombre de préstecs actius
            llibre.devolver();           // Marquem el llibre com disponible
        }
    }

    // Getters
    public Usuari getUsuari() { return usuari; }
    public Llibre getLlibre() { return llibre; }
    public LocalDate getDataRetorn() { return dataRetorn; }
    public boolean esRetornat() { return retornat; }
}