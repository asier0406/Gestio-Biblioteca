import java.time.LocalDate;

public class prestec {
    public static final int MAX_PRESTECS = 5; // Número màxim de préstecs per usuari
    private Usuari usuari;
    private Llibre llibre;
    private LocalDate dataPrestec;
    private LocalDate dataRetorn;
    private boolean retornat;

    public prestec(Usuari usuari, Llibre llibre, LocalDate dataPrestec) {
        validarPrestec(usuari, llibre); // Validem si es pot fer el préstec

        this.usuari = usuari;
        this.llibre = llibre;
        this.dataPrestec = dataPrestec;
        this.dataRetorn = dataPrestec.plusWeeks(2); // Data de retorn automàtica (2 setmanes)
        this.retornat = false;

        // Afegeix el préstec a l'historial de l'usuari
        usuari.afegirPrestecAlHistorial(this); 

        incrementarPrestecs(usuari); // Incrementem el nombre de préstecs actius
        llibre.prestar();           // Marquem el llibre com prestat
    }

    private void validarPrestec(Usuari usuari, Llibre llibre) {
        if (llibre.esPrestat()) {
            throw new RuntimeException("El llibre " + llibre.getTitol() + " no està disponible.");
        }

        if (usuari.getLlibresPrestats().size() >= MAX_PRESTECS) {
            throw new RuntimeException("L'usuari " + usuari.getNom() + " ha assolit el màxim de préstecs permès: " + MAX_PRESTECS);
        }
    }

    private void incrementarPrestecs(Usuari usuari) {
        usuari.setPrestecsActius(usuari.getPrestecsActius() + 1);
    }

    private void decrementarPrestecs(Usuari usuari) {
        if (usuari.getPrestecsActius() > 0) {
            usuari.setPrestecsActius(usuari.getPrestecsActius() - 1);
        }
    }

    public void retornarLlibre() {
        if (!retornat) {
            this.retornat = true; // Marquem el préstec com retornat
            decrementarPrestecs(usuari); // Reduïm el nombre de préstecs actius
            llibre.retornar();           // Marquem el llibre com disponible
        }
    }

    // Getters
    public Usuari getUsuari() { return usuari; }
    public Llibre getLlibre() { return llibre; }
    public LocalDate getDataRetorn() { return dataRetorn; }
    public boolean esRetornat() { return retornat; }
    public LocalDate getDataPrestec() { return dataPrestec; }
}