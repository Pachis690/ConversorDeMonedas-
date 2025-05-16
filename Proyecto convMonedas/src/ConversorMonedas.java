import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ConversorMonedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] monedasValidas = {"USD", "MXN", "BRL"};

        System.out.print("¿Qué moneda tienes? (USD, MXN, BRL): ");
        String monedaOrigen = scanner.nextLine().toUpperCase();

        if (!esValida(monedaOrigen, monedasValidas)) {
            System.out.println("Moneda no válida.");
            return;
        }

        System.out.print("¿Cuánto tienes en " + monedaOrigen + "?: ");
        double cantidadDisponible = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("¿A qué moneda deseas cambiar? (USD, MXN, BRL): ");
        String monedaDestino = scanner.nextLine().toUpperCase();

        if (!esValida(monedaDestino, monedasValidas)) {
            System.out.println("Moneda no válida.");
            return;
        }

        System.out.print("¿Cuánto deseas cambiar?: ");
        double cantidadACambiar = scanner.nextDouble();

        if (cantidadACambiar > cantidadDisponible) {
            System.out.println("No tienes suficiente dinero para cambiar esa cantidad.");
            return;
        }

        double tasa = obtenerTasa(monedaOrigen, monedaDestino);
        if (tasa == -1) {
            System.out.println("Error obteniendo tasa de cambio.");
            return;
        }

        double resultado = cantidadACambiar * tasa;

        System.out.printf("Recibirás: %.2f %s\n", resultado, monedaDestino);
    }

    public static boolean esValida(String moneda, String[] validas) {
        for (String m : validas) {
            if (m.equals(moneda)) return true;
        }
        return false;
    }
    public static double obtenerTasa(String from, String to) {
    try {
        String apiKey = "7a186dadcd970b521cddc6c1";
        String urlStr = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", apiKey, from);
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
            System.out.println("Error: respuesta HTTP " + responseCode);
            return -1;
        }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            Gson gson = new Gson();
            TasaCambio tasa = gson.fromJson(br, TasaCambio.class);
            br.close();

            if (tasa.conversion_rates == null || !tasa.conversion_rates.containsKey(to)) {
            System.out.println("Error: no se encontró la tasa para " + to);
            return -1;
            }

        return tasa.conversion_rates.get(to);
        } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        return -1;
        }
        }

    
    }
