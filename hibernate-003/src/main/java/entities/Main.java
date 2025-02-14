package entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        // Get the session factory
        SessionFactory factory = HibernateUtil.getSessionFactory();

        // Get a session from the factory
        Session session = factory.getCurrentSession();

        try {
            // Create a new student object
            Student student = new Student("John Doe");

            // Start a transaction
            session.beginTransaction();

            // Save the student object
            session.save(student);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Student saved with roll number: " + student.getRollNumber());
        } finally {
            factory.close();
        }
    }
}
