package Data;

import Domain.PersonJs15;
import jakarta.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;
import java.util.Scanner;

import org.hibernate.query.Query;

/**
 *
 * @author joshue
 */
public class PersonJs15_DAO {

    //El 3
    public void insert() {
        Scanner scanner = new Scanner(System.in);
        boolean si = true;

        while (si) {

            System.out.println("Pon el carnet de coche");
            String driver_id = scanner.nextLine();
            if (driver_id.equalsIgnoreCase("0")) {
                break;
            }
            System.out.println("Pon la dirección");
            String adress = scanner.nextLine();
            System.out.println("Pon el nombre");
            String name = scanner.nextLine();

            Session session = HibernateUtil.factory.openSession();
            Transaction tx = null;
            PersonJs15 person = new PersonJs15(driver_id, adress, name);
            try {
                tx = session.beginTransaction();
                session.persist(person);
                tx.commit();
                System.out.println("***** Persona añadida *****");
            } catch (Exception e) {
                if (tx != null) {
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
            TypedQuery<PersonJs15> query = session.createNativeQuery("select * FROM Person_js15", PersonJs15.class);
            List<PersonJs15> list = query.getResultList();
            if (list.isEmpty()) {
                System.out.println("******** No hay ninguna persona ********");
            }
            for (Iterator<PersonJs15> iterator = list.iterator(); iterator.hasNext();) {
                PersonJs15 person = (PersonJs15) iterator.next();
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
            TypedQuery<PersonJs15> query = session.createNativeQuery("select * FROM Person_js15", PersonJs15.class);
            List<PersonJs15> list = query.getResultList();
            if (list.isEmpty()) {
                System.out.println("");
            }
            for (Iterator<PersonJs15> iterator = list.iterator(); iterator.hasNext();) {
                PersonJs15 person = (PersonJs15) iterator.next();
                contador++;
            }
            System.out.println("Hay " + contador + " personas");
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
            PersonJs15 person = (PersonJs15) session.get(PersonJs15.class, borrar);
            session.remove(person);
            tx.commit();
            System.out.println("La persona " + borrar + " ha sido borrada.\n");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("La persona  " + borrar + " no existe.");
        } catch (Exception e) {
            System.out.println("Esta persona tiene un coche con pólizas, borralas para borrar a la persona.");
        } finally {
            session.close();
        }
    }

    //El 2
    public void deleteTodo() {

        Session session = HibernateUtil.factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            TypedQuery<PersonJs15> query = session.createNativeQuery("select * FROM Person_js15", PersonJs15.class);
            List<PersonJs15> lista = query.getResultList();
            if (lista.isEmpty()) {

            }
            for (Iterator<PersonJs15> iterator = lista.iterator(); iterator.hasNext();) {
                PersonJs15 item = iterator.next();
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
