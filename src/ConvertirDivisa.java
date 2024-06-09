import java.util.Objects;
import java.util.Scanner;

public class ConvertirDivisa {
    public static void convertir(Solicitudes solicitud, Scanner lectura, String divisaBase, String codigoDivisa) {

        double cantidadAConvertir;
        double cantidadConvertida;
        Divisa divisa = solicitud.buscarDivisa();
        System.out.println("Ingrese el valor que deseas convertir: ");
        cantidadAConvertir = Double.parseDouble(lectura.nextLine());

        double tasaConversion = divisa.conversion_rates().get(codigoDivisa);


        if (Objects.equals(divisaBase, divisa.base_code())) {
            cantidadConvertida = cantidadAConvertir * tasaConversion;
            System.out.println("El valor  " + cantidadAConvertir + " [" + divisaBase + "] " +
                    " corresponde al valor final =>> " + cantidadConvertida + " [" + codigoDivisa + "]");
        } else {
            // Para convertir de cualquier divisa a Dólar
            double tasaConversionRetro = divisa.conversion_rates().get(divisaBase);
            cantidadConvertida = (cantidadAConvertir * tasaConversion) / tasaConversionRetro; // (cantidadAConvertir *1)/ Equivalente del dolar en pesos
            System.out.println("El valor  " + cantidadAConvertir + " [" + divisaBase + "] " +
                    " corresponde al valor final =>> " + cantidadConvertida + " [" + codigoDivisa + "]");
        }
    }
}