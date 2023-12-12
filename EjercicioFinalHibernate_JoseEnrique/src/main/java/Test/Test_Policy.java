/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Data.PolicyJs15_DAO;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author joshue
 */
public class Test_Policy {
    
    
        public static void main() {

         PolicyJs15_DAO policy = new PolicyJs15_DAO();

        boolean si = true;
        int opcion = 0;
        while (si == true) {

            switch (Lista(opcion)) {

                case 0:

                    si = false;
                    break;

                case 1:

                    policy.select();

                    break;

                case 2:

                    policy.insert();

                    break;

                case 3:
                    
                    policy.delete();

                    break;
                    
               case 4:
                    
                    policy.contador();

                    break;

                default:

                    System.out.println("Esta opción no existe, ponga una opción que vea en pantalla");

            }
        }

    }

    public static int Lista(int menu) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("---Póliza---");
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
