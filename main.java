import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Clases interns
        class Llibre {
            private String titol;
            private String autor;
            private boolean prestat = false;
            private int vegadesPrestat = 0;

            public Llibre(String titol, String autor) {
                this.titol = titol;
                this.autor = autor;
            }

            public String getTitol() { return titol; }
            public boolean isPrestat() { return prestat; }
            public int getVegadesPrestat() { return vegadesPrestat; }

            public void prestar() {
                if (!prestat) {
                    prestat = true;
                    vegadesPrestat++;
                }
            }

            public void retornar() {
                prestat = false;
            }

            public String toString() {
                return titol + " - " + autor + (prestat ? " (PRESTAT)" : "");
            }
        }

        class Usuari {
            private String nom;
            private int totalPrestecs = 0;

            public Usuari(String nom) {
                this.nom = nom;
            }

            public String getNom() { return nom; }
            public int getTotalPrestecs() { return totalPrestecs; }

            public void afegirPrestec() {
                totalPrestecs++;
            }

            public void retornarLlibre(Llibre llibre) {
                llibre.retornar();
            }
        }

        class Biblioteca {
            private List<Llibre> llibres = new ArrayList<>();

            public void afegirLlibre(Llibre llibre) {
                llibres.add(llibre);
            }

            public Llibre buscarLlibre(String titol) {
                for (Llibre l : llibres) {
                    if (l.getTitol().equalsIgnoreCase(titol)) return l;
                }
                return null;
            }

            public void mostrarLlibresDisponibles() {
                for (Llibre l : llibres) {
                    System.out.println(l);
                }
            }

            public void mostrarEstadistiques() {
                System.out.println("Llibres més prestats:");
                for (Llibre l : llibres) {
                    System.out.println("- " + l.getTitol() + ": " + l.getVegadesPrestat() + " préstecs");
                }
            }
        }

        class GestorBiblioteca {
            public void prestarLlibre(Usuari usuari, Llibre llibre) {
                if (!llibre.isPrestat()) {
                    llibre.prestar();
                    usuari.afegirPrestec();
                    System.out.println("Llibre prestat correctament.");
                } else {
                    System.out.println("Aquest llibre ja està prestat.");
                }
            }
        }

        // Inici del programa
        Biblioteca biblioteca = new Biblioteca();
        Llibre llibre1 = new Llibre("1984", "George Orwell", "Ficción");
        Llibre llibre2 = new Llibre("El petit príncep", "Antoine de Saint-Exupéry", "Infantil");
        biblioteca.afegirLlibre(llibre1);
        biblioteca.afegirLlibre(llibre2);

        Usuari usuari = new Usuari("Carla");
        GestorBiblioteca gestor = new GestorBiblioteca();

        int opcio = 0;
        while (opcio != 7) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Prestar llibre");
            System.out.println("2. Retornar llibre");
            System.out.println("3. Mostrar llibres disponibles");
            System.out.println("4. Mostrar usuaris");
            System.out.println("5. Afegir nou llibre");
            System.out.println("6. Mostrar estadístiques");
            System.out.println("7. Sortir");
            System.out.print("Tria una opció: ");
            opcio = scanner.nextInt();


            if (opcio == 1) {
                System.out.print("Títol del llibre a prestar: ");
                String titol = scanner.nextLine();
                Llibre llibre = biblioteca.buscarLlibre(titol);
                if (llibre != null) {
                    gestor.prestarLlibre(usuari, llibre);
                } else {
                    System.out.println("Llibre no trobat.");
                }

            } else if (opcio == 2) {
                System.out.print("Títol del llibre a retornar: ");
                String titol = scanner.nextLine();
                Llibre llibre = biblioteca.buscarLlibre(titol);
                if (llibre != null) {
                    usuari.retornarLlibre(llibre);
                    System.out.println("Llibre retornat correctament.");
                } else {
                    System.out.println("Llibre no trobat.");
                }

            } else if (opcio == 3) {
                System.out.println("\nLlibres disponibles:");
                biblioteca.mostrarLlibresDisponibles();

            } else if (opcio == 4) {
                System.out.println("\nUsuaris:");
                System.out.println(usuari.getNom());

            } else if (opcio == 5) {
                System.out.print("Títol del nou llibre: ");
                String nouTitol = scanner.nextLine();
                System.out.print("Autor: ");
                String nouAutor = scanner.nextLine();
                biblioteca.afegirLlibre(new Llibre(nouTitol, nouAutor));
                System.out.println("Nou llibre afegit.");

            } else if (opcio == 6) {
                System.out.println("\nEstadístiques:");
                biblioteca.mostrarEstadistiques();
                System.out.println("Usuari " + usuari.getNom() + ": " + usuari.getTotalPrestecs() + " préstecs");

            } else if (opcio == 7) {
                System.out.println("Sortint...");

            } else {
                System.out.println("Opció no vàlida.");
            }
        }
    }
}
