
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Solicitudes {

   public Divisa buscarDivisa(){

       URI direccion = URI.create("https://v6.exchangerate-api.com/" +
                  "v6/414df5c9211bceb7f43d3162/latest/USD");

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Divisa.class);


        } catch (Exception e) {
            throw new RuntimeException("No encontre la Divisa" + e.getMessage());
        }
    }
}

/*  // 7 Analizando la respuesta en formato JSON

            //Parsear la respuesta JSON a JsonObject: Esto convierte la respuesta JSON en un JsonObject
            JsonObject jsonObjecto = JsonParser.parseString(response.body()).getAsJsonObject();

            // Extraer el objeto 'conversion_rates': Esto obtiene a los JsonObject (recuerda que cada objeto es un par de {obj1}{obj2}) que contiene las tasas de conversión.
            JsonObject conversionTasaJson = jsonObjecto.getAsJsonObject("conversion_rates");

            //String baseCode = jsonObjecto.get("base_code").getAsString(); //el valor asociado con la clave "base_code" NO es un
            // objeto JSON completo (como si lo es conversion_rate) por eso se aplica el metodo getString()

            //8. Filtrando monedas
            double dolar = conversionTasaJson.get("USD").getAsDouble();
            double pesoArgentino = conversionTasaJson.get("ARS").getAsDouble();
            double realBrasileño = conversionTasaJson.get("BRL").getAsDouble();
            double pesoColombiano = conversionTasaJson.get("COP").getAsDouble();

           */