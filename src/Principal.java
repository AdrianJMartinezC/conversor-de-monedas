import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {


        Scanner lectura = new Scanner(System.in);
        Solicitudes solicitud = new Solicitudes();
        Divisa divisa = solicitud.buscarDivisa();

        var opcion = 0;
        while (opcion!=7){
            System.out.println("""
                *******************************************
                1- Dolar =>> peso Argentino
                2- Peso Argentino =>> Dólar
                3- Dólar =>> Real Brasileño
                4- Real Brasileño =>> Dólar
                5- Dólar =>> Peso Colombiano
                6- Peso Colombiano =>> Dólar
                7- Salir
                Elija una opción válida """);

            opcion = lectura.nextInt();
            lectura.nextLine();

            switch (opcion){
                case 1:
                    ConvertirDivisa.convertir(solicitud, lectura, "USD","ARS");
                    break;
                case 2:
                    ConvertirDivisa.convertir(solicitud, lectura, "ARS","USD");
                    break;
                case 3:
                    ConvertirDivisa.convertir(solicitud, lectura, "USD","BRL");
                    break;
                case 4:
                    ConvertirDivisa.convertir(solicitud, lectura, "BRL","USD");
                    break;
                case 5:
                    ConvertirDivisa.convertir(solicitud, lectura, "USD","COP");
                    break;
                case 6:
                    ConvertirDivisa.convertir(solicitud, lectura, "COP","USD");
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
