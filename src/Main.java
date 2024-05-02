import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Converter converter = new Converter();
        int option = 0;
        double amount = 0;
        List<History> history = new ArrayList<>();

        do {
            System.out.println(converter.menu());

            try {
                System.out.print("Selecciona una opción de la lista: ");
                option = userInput.nextInt();

                while (option < 0 || option >= 10) {
                    System.out.println("La opción ingresada no es valida\n");
                    System.out.print("Selecciona una opción de la lista: ");
                    option = userInput.nextInt();
                }

                if (option == 0) {
                    if (history.isEmpty()) {
                        System.out.println("No se ha hecho ninguna conversión por el momento\n");
                    } else {
                        System.out.println("Historial de conversiones:");
                        for (History record : history) {
                            System.out.println(record);
                        }
                    }
                } else if (option == 9) {
                    System.out.println("Terminando programa...");
                    break;
                } else {
                    System.out.print("Ingresa la cantidad que deseas convertir: ");
                    amount = userInput.nextDouble();
                    Currency currency = converter.convertRequest(option, amount);
                    History record = new History(option, amount, currency.base_code(), currency.target_code(), currency.conversion_rate(), currency.conversion_result());
                    history.add(record);
                    System.out.printf("$%.2f [%s] equivale a $%.2f [%s]\n\n", amount, currency.base_code(), currency.conversion_result(), currency.target_code());
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero válido\n");
                userInput.next();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (option != 9);


    }

}
