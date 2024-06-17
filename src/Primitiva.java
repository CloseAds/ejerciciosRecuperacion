import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Primitiva {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int numeroVeces = s.nextInt();
        s.nextLine();
        if (numeroVeces < 1) {
            throw new IllegalArgumentException("No puede ser menor que 1.");
        }
        else {
            for (int i = 0; i < numeroVeces; i++) {
                String primitiva = s.nextLine();
                char [] Primitiva = String.valueOf(primitiva).toCharArray();
                if (!primitiva.matches("\\d{7}")){
                    throw new IllegalArgumentException("No puede ser mayor que 7 la longitud de la primitiva o contener caracteres.");
                }
                else {
                    String joker = s.nextLine();
                    char [] Joker = String.valueOf(joker).toCharArray();
                    if (!joker.matches("\\d{7}")){
                        throw new IllegalArgumentException("No puede ser mayor que 7 la longitud del joker o contener caracteres.");
                    }
                    else{
                        Arrays.sort(Primitiva);
                        Arrays.sort(Joker);
                        if (Arrays.equals(Primitiva,Joker)) {
                            System.out.println("GANA");
                        } else {
                            System.out.println("PIERDE");
                        }
                    }
                }
            }
        }
        s.close();
    }
}

