import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Character> clave = new ArrayList<Character>();
        cargarDatos(clave);
        guardarDatos(clave);
        System.out.println("Clave generada: ");
        for (Character c : clave) {
            System.out.print(c);
        }

    }
    public static void cargarDatos(ArrayList<Character> clave) {
        try (BufferedReader reader = new BufferedReader(new
                FileReader("fichero.txt"))) {
            String linea;
            char caracter;
            while ((linea = reader.readLine()) != null) {
                    if (!linea.isEmpty()) {
                        caracter = linea.charAt(linea.length()-1);
                        clave.add(caracter);
                        if (clave.size() > 10) {
                            clave.remove(clave.size()-1);
                        }
                    }
            }
            System.out.println("Datos cargados");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " +
                    e.getMessage());
        }
    }

    public static void guardarDatos(ArrayList<Character> clave) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clave_cifrada.txt"))) {
            for (char caracter : clave) {
                writer.write(caracter);
            }
            System.out.println("Datos guardados");
        }catch (IOException e) {
            System.out.println("Ocurrió un error al escribir el archivo: " +
                    e.getMessage());
        }
    }
}