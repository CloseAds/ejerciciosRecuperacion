import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContadoPendientes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            int p = scanner.nextInt();
            if (p < 1 || p > 200000) break;

            Map<Integer, Integer> pendientes = new HashMap<>();

            for (int i = 0; i < p; i++) {
                int pen = scanner.nextInt();
                pendientes.put(pen, pendientes.getOrDefault(pen, 0) + 1);//.put propiedad de los mapas
            }

            //inicializar las parejas;
            int parejas = 0;

            for (int cantidad : pendientes.values()) {
                parejas += cantidad / 2;
            }

            System.out.println("El nº de parejas es de " + parejas);
        }

        scanner.close();
    }

}
