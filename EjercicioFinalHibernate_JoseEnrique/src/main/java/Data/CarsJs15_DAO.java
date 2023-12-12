package Data;

import Domain.CarJs15;
import Domain.PersonJs15;
import Util.HibernateUtil;
import jakarta.persistence.TypedQuery;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarsJs15_DAO {

    //El 3
    public void insert() {
        Scanner scanner = new Scanner(System.in);
        boolean si = true;
        Integer year = 0;

        while (si) {

            System.out.println("Pon el id del coche");
            String licenseId = scanner.nextLine();
            if (licenseId.equalsIgnoreCase("0")) {
                break;
            }
            System.out.println("Pon el modelo");
            String model = scanner.nextLine();
            System.out.println("Pon la persona que lo tiene (Su carnet de coche)");
            String id_persona = scanner.nextLine();
            System.out.println("Pon el año");
            try {
                 year = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Porfavor ponga un año válido");
                break;
            }
            scanner.nextLine();

            PersonJs15 person = new PersonJs15(id_persona);

            Session session = HibernateUtil.factory.openSession();
            Transaction tx = null;
            CarJs15 car = new CarJs15(licenseId, model, year, person);
            try {
                tx = session.beginTransaction();
                session.persist(car);
                tx.commit();
                System.out.println("***** Coche añadido *****");
            } catch (Exception e) {
                if (tx != null) {
                    System.out.println("No se ha encontrado la persona que has introducido");
                    tx.rollback();
                }
            } finally {
                session.close();
            }
        }
    }

    //El 4
    public void select() {

        Session session = HibernateUtil.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            TypedQuery<CarJs15> query = session.createNativeQuery("select * FROM car_js15", CarJs15.class);
            List<CarJs15> car = query.getResultList();
            if (car.isEmpty()) {
                System.out.println("******** No hay ninguna coche ********");
            }
            for (Iterator<CarJs15> iterator = car.iterator(); iterator.hasNext(); ) {
                CarJs15 caar = (CarJs15) iterator.next();
                System.out.println(caar.toString2());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //El 1
    public void contador() {

        Session session = HibernateUtil.factory.openSession();
        Transaction tx = null;
        int contador = 0;
        try {
            tx = session.beginTransaction();
            TypedQuery<CarJs15> query = session.createNativeQuery("select * FROM car_js15", CarJs15.class);
            List<CarJs15> car = query.getResultList();
            if (car.isEmpty()) {
                System.out.println("");
            }
            for (Iterator<CarJs15> lista = car.iterator(); lista.hasNext(); ) {
                CarJs15 caar = (CarJs15) lista.next();
                contador++;
            }
            System.out.println("Hay " + contador + " coches");
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //El 5
    public void delete() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pon el id del coche que quieras borrar");
        String borrar = scanner.nextLine();

        Session session = HibernateUtil.factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            CarJs15 car = (CarJs15) session.get(CarJs15.class, borrar);
            session.remove(car);
            tx.commit();
            System.out.println("El coche  " + borrar + " ha sido borrado.\n");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("El coche  " + borrar + " no existe.");
        } catch (Exception e) {
            System.out.println("El coche tiene pólizas, borralas para borrar el coche.");
        } finally {
            session.close();
        }
    }

    public void deleteTodo() {

        Session session = HibernateUtil.factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            TypedQuery<CarJs15> query = session.createNativeQuery("select * FROM car_js15", CarJs15.class);
            List<CarJs15> lista = query.getResultList();
            if (lista.isEmpty()) {

            }
            for (Iterator<CarJs15> iterator = lista.iterator(); iterator.hasNext(); ) {
                CarJs15 item = iterator.next();
                session.remove(item);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
