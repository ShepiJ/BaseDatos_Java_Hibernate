package Data;

import Domain.PolicyJs15;
import Domain.CarJs15;
import Util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PolicyJs15_DAO {
    
    
    //El 3
    public void insert() {
        Scanner scanner = new Scanner(System.in);
        boolean si = true;

        while (si) {

            System.out.println("Pon el id de la póliza");
            String policy_id = scanner.nextLine();
            if (policy_id.equalsIgnoreCase("0")) {
                break;
            }
            System.out.println("Pon la licencia del coche");
            String license = scanner.nextLine();

            CarJs15 license_id = new CarJs15(license);

            Session session = HibernateUtil.factory.openSession();
            Transaction tx = null;
            PolicyJs15 policy = new PolicyJs15(policy_id, license_id);
            try {
                tx = session.beginTransaction();
                session.persist(policy);
                tx.commit();
                System.out.println("***** Póliza añadida *****");
            } catch (Exception e) {
                if (tx != null) {
                    System.out.println("***** La licencia del coche introducida no ha sido encontrada *****");
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
            TypedQuery<PolicyJs15> query = session.createNativeQuery("select * FROM policy_js15", PolicyJs15.class);
            List<PolicyJs15> list = query.getResultList();
            if (list.isEmpty()) {
                System.out.println("******** No hay ninguna póliza ********");
            }
            for (Iterator<PolicyJs15> iterator = list.iterator(); iterator.hasNext();) {
                PolicyJs15 policy = (PolicyJs15) iterator.next();
                System.out.println(policy.toString1());
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
            TypedQuery<PolicyJs15> query = session.createNativeQuery("select * FROM policy_js15", PolicyJs15.class);
            List<PolicyJs15> list = query.getResultList();
            if (list.isEmpty()) {
                System.out.println("");
            }
            for (Iterator<PolicyJs15> iterator = list.iterator(); iterator.hasNext();) {
                PolicyJs15 policy = (PolicyJs15) iterator.next();
                contador++;
            }
            System.out.println("Hay " + contador + " pólizas");
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

        System.out.println("Pon el id de la póliza que quieras borrar");
        String borrar = scanner.nextLine();

        Session session = HibernateUtil.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            PolicyJs15 policy = (PolicyJs15) session.get(PolicyJs15.class, borrar);
            session.remove(policy);
            tx.commit();
            System.out.println("La póliza " + borrar + " ha sido borrada.\n");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("La póliza  " + borrar + " no existe.");
        } finally {
            session.close();
        }
    }
    
        public void deleteTodo() {

        Session session = HibernateUtil.factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            TypedQuery<PolicyJs15> query = session.createNativeQuery("select * FROM policy_js15", PolicyJs15.class);
            List<PolicyJs15> lista = query.getResultList();
            if (lista.isEmpty()) {

            }
            for (Iterator<PolicyJs15> iterator = lista.iterator(); iterator.hasNext();) {
                PolicyJs15 item = iterator.next();
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
    

