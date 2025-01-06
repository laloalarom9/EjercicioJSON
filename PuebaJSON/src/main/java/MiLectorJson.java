import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;//importar la libreria para poder leer un array MIAAAA
import java.util.Scanner;//importar la libreria para poder leer lo que ingresa el usuario
import java.time.LocalDate;//importar la libreria para poder obtener el año actual
public class MiLectorJson {
    public static void main(String[] args) {
        String filePath = "src/main/java/datosUsuario.json"; // Ruta del archivo JSON

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject objetoJSON = new JSONObject(content);

            // Acceder al elemento "nombre" y mostrarlo:
            String nombre = objetoJSON.getString("nombre");
            System.out.println("El nombre en el JSON es: " + nombre);
            JSONArray habilidades = objetoJSON.getJSONArray("habilidades");//leer el array de habilidades
            habilidades.put("Gestión de proyectos");//1.gregar una habilidad
            System.out.println("Habilidades de " + nombre + ":");
            for (int i = 0; i < habilidades.length(); i++) {
                System.out.println("- " + habilidades.getString(i));
            }
            //2.Imprimir trabajos de Yennerfer
            JSONArray trabajos = objetoJSON.getJSONArray("trabajos");
            System.out.println("Trabajos de " + nombre + ":");
            for (int i = 0; i < trabajos.length(); i++) {
                JSONObject trabajo = trabajos.getJSONObject(i);
                System.out.println("- " + trabajo.getString("puesto") + " en " + trabajo.getString("empresa"));
            }
            //Obetener el parametro edad y comprobar que es un numero
            Object edadObj = objetoJSON.get("edad");
            if (edadObj instanceof Integer) {
                int edad = objetoJSON.getInt("edad");
                System.out.println("Edad: " + edad);
            } else {
                System.out.println("La edad no es un número");
            }

            //Obtener una habilidad ingresada por el usuairo y si Yennerfer la tiene decir que si la tiene
            Scanner scanner = new Scanner(System.in);
            System.out.print("Comprueba si " + nombre + " tiene una habilidad, ingresa la habilidad: ");
            String habilidadUsuario = scanner.nextLine();
            boolean tieneHabilidad = false;
            for (int i = 0; i < habilidades.length(); i++) {
                if (habilidades.getString(i).equals(habilidadUsuario)) {
                    tieneHabilidad = true;
                    break;
                }

            }
            if (tieneHabilidad) {
                System.out.println(nombre + " tiene la habilidad " + habilidadUsuario);
            } else {
                System.out.println(nombre + " no tiene la habilidad " + habilidadUsuario);
            }
            //3.Calcular la experiencia de Yennerfer
            int experiencia = calcularExperiencia(objetoJSON);
            System.out.println("Experiencia de " + nombre + ": " + experiencia + " años");

        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
    public static int calcularExperiencia(JSONObject jsonObject) {
        int experiencia = 0;
        JSONArray trabajos = jsonObject.getJSONArray("trabajos");
        int añoActual = LocalDate.now().getYear();
        for (int i = 0; i < trabajos.length(); i++) {
            JSONObject trabajo = trabajos.getJSONObject(i);
            int añoInicio = trabajo.getInt("añoInicio");
            Object añoFinObj = trabajo.get("añoFin");
            int añoFin = 0;
            if (añoFinObj instanceof Integer) {
                añoFin =  trabajo.getInt("añoFin");
            } else {
                añoFin = añoActual;
            }
            experiencia += añoFin - añoInicio;
        }

        return experiencia;
    }

}
