import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear una lista para almacenar los caracteres que formarán la clave
        ArrayList<Character> clave = new ArrayList<Character>();
        
        // Cargar los datos desde el archivo "fichero.txt" y procesarlos para generar la clave
        cargarDatos(clave);
        
        // Guardar la clave generada en un archivo llamado "clave_cifrada.txt"
        guardarDatos(clave);
        
        // Mostrar la clave generada por pantalla
        System.out.println("Clave generada: ");
        for (Character c : clave) {
            System.out.print(c);
        }
    }
    
    /**
     * Método que lee el archivo "fichero.txt" y extrae el último carácter de cada línea
     * para construir una clave. La clave tendrá un máximo de 10 caracteres.
     * 
     * @param clave ArrayList donde se almacenarán los caracteres de la clave
     */
    public static void cargarDatos(ArrayList<Character> clave) {
        // Try-with-resources para asegurar que el archivo se cierra correctamente
        try (BufferedReader reader = new BufferedReader(new FileReader("fichero.txt"))) {
            String linea;
            char caracter;
            
            // Leer el archivo línea por línea
            while ((linea = reader.readLine()) != null) {
                // Verificar que la línea no esté vacía
                if (!linea.isEmpty()) {
                    // Obtener el último carácter de la línea (posición length-1)
                    caracter = linea.charAt(linea.length() - 1);
                    
                    // Añadir el carácter a la lista que forma la clave
                    clave.add(caracter);
                    
                    // Verificar si la clave ya tiene más de 10 caracteres
                    if (clave.size() > 10) {
                        // Si supera los 10, eliminar el último carácter añadido
                        // Esto limita la clave a exactamente 10 caracteres
                        clave.remove(clave.size() - 1);
                    }
                }
            }
            System.out.println("Datos cargados");
            
        } catch (IOException e) {
            // Manejar posibles errores de lectura del archivo
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Método que guarda la clave generada en un archivo de texto llamado "clave_cifrada.txt"
     * 
     * @param clave ArrayList con los caracteres que forman la clave a guardar
     */
    public static void guardarDatos(ArrayList<Character> clave) {
        // Try-with-resources para escribir en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clave_cifrada.txt"))) {
            // Recorrer todos los caracteres de la clave
            for (char caracter : clave) {
                // Escribir cada carácter en el archivo
                writer.write(caracter);
            }
            System.out.println("Datos guardados");
            
        } catch (IOException e) {
            // Manejar posibles errores de escritura
            System.out.println("Ocurrió un error al escribir el archivo: " + e.getMessage());
        }
    }
}
