
public class Llibre {
    private String titol;
    private String autor;
    private boolean prestat;
    private String categoria;
    
    public Llibre(String titol, String autor, String categoria) {
        this.titol = titol;
        this.autor = autor;
        this.categoria = categoria;
        this.prestat = false;
    }

    public String getTitol() { return titol; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }
    public boolean esPrestat() { return prestat; }
    public void prestar() { prestat = true; }
    public void retornar() { prestat = false; }
    
    //mejora
    public void disponible() {
        if (this.prestat == true) {
            System.out.println("El llibre no esta disponible");
        } else {
            System.out.println("El llibre esta disponible");
        }
    }
    
    //Funciones
    public void modificarLlibre(String titolMod, String autorMod, String categoriaMod) {
        this.titol = titolMod;
        this.autor = autorMod;
        this.categoria = categoriaMod;
    }

    //Posas la biblioteca on esta el llibre i utilitzant el titol el busquem i borrem
    public static void eliminarLlibre(Biblioteca biblioteca, String titol) {
        Llibre llibre = biblioteca.buscarLlibre(titol);
        if (llibre != null) {
            biblioteca.getLlibres().remove(llibre);
            System.out.println("Llibre eliminat: " + titol);
        } else {
            System.out.println("No s'ha trobat el llibre: " + titol);
        }
    }
    
    @Override
    public String toString() {
    return titol + " de " + autor + "(" + categoria + ")" + (prestat ? " (En préstec)" : " (Disponible)");
    }
}