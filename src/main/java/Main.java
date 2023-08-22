import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Main {

    private static EntityManagerFactory _emf = HibernateConfig.getEntityManagerFactoryConfig();

    public static void main(String[] args) {


        //Entity er i transient state
        /* Student newStudent = new Student();
        newStudent.setFirstName("Viggo");
        newStudent.setLastName("Mortensen");
        newStudent.setAge(35);
        newStudent.setEmail("Viggomortensen@Aragorn.dk");
        createStudent(newStudent, _emf); */

        Student newStudent1 = new Student();
        newStudent1.setFirstName("Viggo1");
        newStudent1.setLastName("Hansen");
        newStudent1.setAge(35);
        newStudent1.setEmail("Viggohansen@Aragorn.dk");
        createStudent(newStudent1, _emf);

        Student newStudent2 = new Student();
        newStudent2.setFirstName("Lars");
        newStudent2.setLastName("Hansen");
        newStudent2.setAge(35);
        newStudent2.setEmail("LarsHansen@Aragorn.dk");
        createStudent(newStudent2, _emf);

        Student newStudent3 = new Student();
        newStudent3.setFirstName("Jens  ");
        newStudent3.setLastName("Hansen");
        newStudent3.setAge(10);
        newStudent3.setEmail("Jenshansen@Aragorn.dk");
        createStudent(newStudent3, _emf);

        Student newStudent4 = new Student();
        newStudent4.setFirstName("Finn");
        newStudent4.setLastName("Jensen");
        newStudent4.setAge(35);
        newStudent4.setEmail("Finnjensen@Aragorn.dk");
        createStudent(newStudent4, _emf);

        Student newStudent5 = new Student();
        newStudent5.setFirstName("Tom");
        newStudent5.setLastName("Jensen");
        newStudent5.setAge(35);
        newStudent5.setEmail("Tomjensen@Aragorn.dk");
        createStudent(newStudent5, _emf);

        Student newStudent6 = new Student();
        newStudent6.setFirstName("Pik");
        newStudent6.setLastName("Jensen");
        newStudent6.setAge(35);
        newStudent6.setEmail("Pikjensen@Aragorn.dk");
        createStudent(newStudent6, _emf);

        Student newStudent7 = new Student();
        newStudent7.setFirstName("Bøv");
        newStudent7.setLastName("Jensen");
        newStudent7.setAge(90);
        newStudent7.setEmail("Bøvjensen@Aragorn.dk");
        createStudent(newStudent7, _emf);

        Student newStudent8 = new Student();
        newStudent8.setFirstName("Lorte");
        newStudent8.setLastName("Opgave");
        newStudent8.setAge(35);
        newStudent8.setEmail("Lorteopgave@Aragorn.dk");
        createStudent(newStudent8, _emf);

        Student newStudent9 = new Student();
        newStudent9.setFirstName("Bæ");
        newStudent9.setLastName("Fjæs");
        newStudent9.setAge(35);
        newStudent9.setEmail("Bæfjæs@Aragorn.dk");
        createStudent(newStudent9, _emf);

        Student newStudent10 = new Student();
        newStudent10.setFirstName("Færdig");
        newStudent10.setLastName("Færdigsen");
        newStudent10.setAge(35);
        newStudent10.setEmail("Færdigfærdigsen@Aragorn.dk");
        createStudent(newStudent10, _emf);

        _emf.close();


    }

    public static void createStudent(Student student, EntityManagerFactory emf) {

        try (EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();
            // entity is in managed state (after persist)
            em.persist(student);
            // entity is in detached state after the transaction is committed
            em.getTransaction().commit();


        } finally {

        }

    }

    public static Student findById(int id, EntityManagerFactory emf) {

        try (EntityManager em = emf.createEntityManager()) {

            Student foundStudent = em.find(Student.class, id);
            return foundStudent;


        } finally {

        }

    }

    public Student update(Student student, EntityManagerFactory emf) {

        try (EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();
            Student updatedStudent = em.merge(student);
            // entity is in detached state after the transaction is committed
            em.getTransaction().commit();
            return updatedStudent;


        } finally {

        }

    }

    public static void deleteStudent(int id, EntityManagerFactory emf) {

        try (EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();
            Student student = findById(id,emf);
            if (student != null) {
                em.remove(student);
            }
            // entity is in detached state after the transaction is committed
            em.getTransaction().commit();

        }

    }

    public static List<Student> readAllStudents(EntityManagerFactory emf) {

        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Student> query = em.createQuery("Select s FROM Student s", Student.class);
            List<Student> students = query.getResultList();
            return students;

        }

    }

    public static float readAllStudentsAvg(EntityManagerFactory emf) {

        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Student> query = em.createQuery("Select s FROM Student s", Student.class);
            List<Student> students = query.getResultList();
            float Avg = 0;
            float sum = 0;
            for (Student s : students) {
                sum += s.getAge();
            }
            Avg = sum / students.size();

            return Avg;
        }

    }

    public static float readAllStudentsAvgWithName(String name, EntityManagerFactory emf) {

        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Student> query = em.createQuery("Select s FROM Student s WHERE lastName = " + name, Student.class);
            List<Student> students = query.getResultList();
            float Avg = 0;
            float sum = 0;
            for (Student s : students) {
                sum += s.getAge();
            }
            Avg = sum / students.size();

            return Avg;
        }

    }

    public static List<Student> readAllStudentsWithName(String name, EntityManagerFactory emf) {

        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Student> query = em.createQuery("Select s FROM Student s WHERE lastName = " + name, Student.class);
            List<Student> students = query.getResultList();
            return students;
        }
    }
}