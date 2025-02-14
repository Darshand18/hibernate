package entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainApp {
    public static void main(String[] args) {
        // Obtain session factory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // Obtain session
        Session session = sessionFactory.getCurrentSession();

        try {
            // Create new Student object
            Student student = new Student("John Doe");

            // Begin transaction
            session.beginTransaction();

            // Save the Student object
            session.save(student);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Student saved: " + student);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the session factory
            HibernateUtil.shutdown();
        }
    }
}
