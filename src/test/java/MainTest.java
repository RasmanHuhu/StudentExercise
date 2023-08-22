import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private EntityManagerFactory _emf = HibernateTestConfig.getEntityManagerFactoryConfig();

    @Test
    void createStudent() {

        int amountOfStudentsBeforeCreation = Main.readAllStudents(_emf).size();
        Student student = new Student();
        student.setFirstName("Viggo");
        student.setLastName("Mortensen");
        student.setAge(35);
        student.setEmail("Viggomortensen@aragorn.dk");
        Main.createStudent(student, _emf);

        int amountOfStudentsAfterCreation = Main.readAllStudents(_emf).size();
        assertEquals(amountOfStudentsBeforeCreation +1, amountOfStudentsAfterCreation);
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void readAllStudents() {
    }
}