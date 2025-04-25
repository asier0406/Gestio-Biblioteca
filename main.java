import java.util.Scanner;

public class main {
    public main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Llibre llibre1 = new Llibre("1984", "George Orwell", "Ficción");
        Llibre llibre2 = new Llibre("El petit príncep", "Antoine de Saint-Exupéry", "Infantil");
        biblioteca.afegirLlibre(llibre1);
        biblioteca.afegirLlibre(llibre2);

        Usuari usuari = new Usuari("Carla");
        GestorBiblioteca gestor = new GestorBiblioteca();

        // Crear Scanner per a la interacció per teclat
        Scanner scanner = new Scanner(System.in);

        // Menú d'opcions
        int opcio = 0;
        while (opcio != 5) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Prestar llibre");
            System.out.println("2. Retornar llibre");
            System.out.println("3. Mostrar llibres disponibles");
            System.out.println("4. Mostrar usuaris");
            System.out.println("5. Sortir");
            System.out.print("Tria una opció: ");
            opcio = scanner.nextInt();

            if (opcio == 1) {
                // Prestar llibre
                System.out.print("Introdueix el títol del llibre a prestar: ");
                scanner.nextLine();  // Consumir el salt de línia
                String titolPrestat = scanner.nextLine();
                Llibre llibrePrestat = biblioteca.buscarLlibre(titolPrestat);
                if (llibrePrestat != null) {
                    gestor.prestarLlibre(usuari, llibrePrestat);
                } else {
                    System.out.println("Llibre no trobat.");
                }
            } else if (opcio == 2) {
                // Retornar llibre
                System.out.print("Introdueix el títol del llibre a retornar: ");
                scanner.nextLine();  // Consumir el salt de línia
                String titolRetornat = scanner.nextLine();
                Llibre llibreRetornat = biblioteca.buscarLlibre(titolRetornat);
                if (llibreRetornat != null) {
                    usuari.retornarLlibre(llibreRetornat);
                    llibreRetornat.retornar();
                    System.out.println("Llibre retornat correctament.");
                } else {
                    System.out.println("Llibre no trobat.");
                }
            } else if (opcio == 3) {
                // Mostrar llibres disponibles
                System.out.println("\nLlibres disponibles:");
                for (Llibre llibre : biblioteca.getLlibres()) {
                    System.out.println(llibre);
                }
            } else if (opcio == 4) {
                // Mostrar usuaris
                System.out.println("\nUsuaris:");
                System.out.println(usuari.getNom());
            } else if (opcio != 5) {
                System.out.println("Opció no vàlida. Torna a intentar-ho.");
            }
        }

        System.out.println("Sortint...");
    }
}
