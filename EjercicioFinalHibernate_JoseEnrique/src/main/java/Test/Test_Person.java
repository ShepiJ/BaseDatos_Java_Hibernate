package Test;

import Data.PersonJs15_DAO;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test_Person {

    public static void main() {

        PersonJs15_DAO person = new PersonJs15_DAO();

        boolean si = true;
        int opcion = 0;
        while (si == true) {

            switch (Lista(opcion)) {

                case 0:

                    si = false;
                    break;

                case 1:

                    person.select();

                    break;

                case 2:

                    person.insert();

                    break;

                case 3:

                    person.delete();

                    break;

                case 4:

                    person.contador();

                    break;

                default:

                    System.out.println("Esta opción no existe, ponga una opción que vea en pantalla");

            }
        }

    }

    public static int Lista(int menu) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("---Persona---");
            System.out.println("1.Select_All");
            System.out.println("2.Insert");
            System.out.println("3.Delete");
            System.out.println("4.Contador");
            System.out.println("0.Salir");

            int respueta = scanner.nextInt();
            return respueta;
        } catch (InputMismatchException e) {
            return 420;
        }
    }
}
