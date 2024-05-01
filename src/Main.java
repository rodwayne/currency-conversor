import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Converter converter = new Converter();
        int option = 0;
        double amount;

        String menu = """
                ********************************************
                     Bienvenido al Conversor de Monedas
                --------------------------------------------
                1) Dólar ==> Peso argentino
                2) Peso argentino ==> Dólar
                3) Dólar ==> Real brasileño
                4) Real brasileño ==> Dólar
                5) Dólar ==> Peso colombiano
                6) Peso colombiano ==> Dólar
                7) Dólar ==> Peso mexicano
                8) Peso mexicano ==> Dólar
                9) Salir
                """;

        do {
            System.out.println(menu);



            try {
                System.out.print("Selecciona una opción de la lista: ");
                option = userInput.nextInt();

                while (option <= 0 || option >= 10) {
                    System.out.println("La opción ingresada no es valida\n");
                    System.out.print("Selecciona una opción de la lista: ");
                    option = userInput.nextInt();
                }

                if (option == 9) {
                    System.out.println("Terminando programa...");
                    break;
                }

                System.out.print("Ingresa la cantidad que deseas convertir: ");
                amount = userInput.nextDouble();

                Currency currency = converter.convertRequest(option, amount);

                System.out.printf("$%.2f [%s] equivale a $%.2f [%s]\n\n", amount, currency.base_code(), currency.conversion_result(), currency.target_code());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (option != 9);
    }

}
