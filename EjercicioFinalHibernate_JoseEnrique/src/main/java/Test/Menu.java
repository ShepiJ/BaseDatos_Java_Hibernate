package Test;

import Data.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        PersonJs15_DAO person = new PersonJs15_DAO();
        CarsJs15_DAO car = new CarsJs15_DAO();
        PolicyJs15_DAO policy = new PolicyJs15_DAO();
        AccidentJs15_DAO accident = new AccidentJs15_DAO();

        boolean si = true;
        int opcion = 0;
        while (si == true) {

            switch (Lista(opcion)) {

                case 0:

                    si = false;
                    break;

                case 1:

                    person.deleteTodo();
                    car.deleteTodo();
                    policy.deleteTodo();
                    accident.deleteTodo();

                    System.out.println("Todas las tablas borradas sin problemas");

                    break;

                case 2:

                    person.contador();
                    car.contador();
                    policy.contador();
                    accident.contador();

                    break;

                case 3:

                    Test_Person.main();

                    break;

                case 4:

                    Test_Car.main();

                    break;
                case 5:

                    Test_Accident.main();

                    break;
                case 6:

                    Test_Policy.main();

                    break;

                default:

                    System.out.println("Esta opción no existe, ponga una opción que vea en pantalla");

            }
        }

    }

    public static int Lista(int menu) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("---Menu_Principal---");
            System.out.println("1.Vaciar todo");
            System.out.println("2.Contador de todo");
            System.out.println("3.Persona");
            System.out.println("4.Coche");
            System.out.println("5.Accidente");
            System.out.println("6.Póliza");
            System.out.println("0.Salir");

            int respueta = scanner.nextInt();
            return respueta;
        } catch (InputMismatchException e) {
            return 420;
        }
    }
}
