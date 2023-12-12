package Data;

import Domain.AccidentJs15;
import Domain.CarJs15;
import Domain.PersonJs15;
import Util.HibernateUtil;
import jakarta.persistence.TypedQuery;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AccidentJs15_DAO {

    //El 3

    public void insert() {
        Scanner scanner = new Scanner(System.in);
        boolean si = true;
        while (si) {

            System.out.println("Pon el id del accidente");
            String reportNumber = scanner.nextLine();
            if (reportNumber.equalsIgnoreCase("0")) {
                break;
            }
            System.out.println("Pon la dirección");
            String location = scanner.nextLine();
            System.out.println("Pon la licencia del coche");
            String licencia = scanner.nextLine();

            Session session = HibernateUtil.factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                CarJs15 car = session.get(CarJs15.class, licencia);
                if (car == null) {
                    System.out.println("No se encontró un coche con la licencia especificada");
                    continue;
                }
                Collection<CarJs15> collection = new ArrayList<CarJs15>();
                collection.add(car);
                AccidentJs15 accident = new AccidentJs15(reportNumber, location, collection);
                session.persist(accident);
                tx.commit();
                System.out.println("***** Accident añadido *****");
            } catch (Exception e) {
                if (tx != null) {
                    tx.rollback();
                }
                System.out.println("Error: " + e.getMessage());
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
            TypedQuery<AccidentJs15> query = session.createNativeQuery("select * FROM accident_js15", AccidentJs15.class);
            List<AccidentJs15> list = query.getResultList();
            if (list.isEmpty()) {
                System.out.println("******** No hay ningun accident ********");
            }
            for (Iterator<AccidentJs15> iterator = list.iterator(); iterator.hasNext(); ) {
                AccidentJs15 person = (AccidentJs15) iterator.next();
                System.out.println(person.toString1());
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
            TypedQuery<AccidentJs15> query = session.createNativeQuery("select * FROM accident_js15", AccidentJs15.class);
            List<AccidentJs15> list = query.getResultList();
            if (list.isEmpty()) {
                System.out.println("");
            }
            for (Iterator<AccidentJs15> iterator = list.iterator(); iterator.hasNext(); ) {
                AccidentJs15 person = (AccidentJs15) iterator.next();
                contador++;
            }
            System.out.println("Hay " + contador + " accidentes");
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

        System.out.println("Pon el el numero de accidente que quieres borrar");
        String borrar = scanner.nextLine();

        Session session = HibernateUtil.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            AccidentJs15 accident = (AccidentJs15) session.get(AccidentJs15.class, borrar);
            session.remove(accident);
            tx.commit();
            System.out.println("EL accidente  " + borrar + " ha sido borrado.\n");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("El accidente  " + borrar + " no existe.");
        } finally {
            session.close();
        }
    }

    public void deleteTodo() {

        Session session = HibernateUtil.factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            TypedQuery<AccidentJs15> query = session.createNativeQuery("select * FROM accident_js15", AccidentJs15.class);
            List<AccidentJs15> lista = query.getResultList();
            if (lista.isEmpty()) {

            }
            for (Iterator<AccidentJs15> iterator = lista.iterator(); iterator.hasNext(); ) {
                AccidentJs15 item = iterator.next();
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
