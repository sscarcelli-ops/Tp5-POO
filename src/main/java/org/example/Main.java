package org.example;
//Desafío 3
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBag<String> miBolsa = new DataBag<>(3); // Creamos una bolsa con capacidad 3
        int opcion = 0;

        do {
            System.out.println("\n--- Menú de Opciones para DataBag ---");
            System.out.println("1. Agregar un elemento");
            System.out.println("2. Remover un elemento");
            System.out.println("3. Mostrar el estado de la bolsa");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                switch (opcion) {
                    case 1:
                        System.out.print("Introduce el elemento a agregar: ");
                        String elemento = scanner.nextLine();
                        miBolsa.add(elemento);
                        System.out.println("Elemento agregado con éxito.");
                        miBolsa.printElements();
                        break;
                    case 2:
                        String elementoRemovido = miBolsa.remove();
                        System.out.println("Elemento removido: " + elementoRemovido);
                        miBolsa.printElements();
                        break;
                    case 3:
                        miBolsa.printElements();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intenta de nuevo.");
                        break;
                }
            } catch (FullDataBagException | EmptyDataBagException e) {
                System.out.println("¡Error! " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                scanner.nextLine(); // Limpiar el buffer del scanner
                opcion = 0; // Para que el bucle continúe
            }

        } while (opcion != 4);

        scanner.close();
    }
}