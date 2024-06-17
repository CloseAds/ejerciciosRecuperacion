import java.util.*;

public class Potitos {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Introduce el nº de potitos para el bebe:");
            int numPotitos = scanner.nextInt();
            if (numPotitos > 25 || numPotitos < 1) break; //para comprobar que no se mata al bebe;
            scanner.nextLine();

            Set<String> ingredientesGustados = new HashSet<>();
            Set<String> ingredientesNoGustados = new HashSet<>();

            for (int i = 0; i < numPotitos; i++) {
                String[] inputLine = scanner.nextLine().split(" ");
                String resultado = inputLine[0];//para mostrar la posición con el inputLine;
                Set<String> ingredientes = new HashSet<>(Arrays.asList(inputLine).subList(1, inputLine.length - 1));

                if (resultado.equals("SI:")) {
                    ingredientesGustados.addAll(ingredientes);
                } else if (resultado.equals("NO:")) {
                    ingredientesNoGustados.addAll(ingredientes);
                } else {
                    throw new IllegalArgumentException("El listado debe comenzar por SI: o NO: .");
                }
            }

            //para limpiar el listado una vez que se hayan insertado todos los potitos de esa comida;
            ingredientesNoGustados.removeAll(ingredientesGustados);
            List<String> ingredientesNoGustadosList = new ArrayList<>(ingredientesNoGustados);
            Collections.sort(ingredientesNoGustadosList); //para ordenar los ingredientes por orden alfabético;

            //para mostrar los ingredientes no gustados separados por un delimitador
            //en este caso se trata de un espacio
            if (ingredientesNoGustadosList.isEmpty()) {
                System.out.println();
            } else {
                System.out.println(String.join(" ", ingredientesNoGustadosList));
            }
        }

        scanner.close();

    }
}
