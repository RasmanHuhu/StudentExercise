import jakarta.persistence.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Table(name = "student")
@Entity
public class Student {

    @Column(name = "firstName", nullable = false, length = 15)
    String firstName;

    @Column(name = "lastName", nullable = false, length = 15)
    String lastName;

    @Column(name = "email", unique = true)
    String email;


    int age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        if (isEmailValid(email)) {
            this.email = email;
        }
    }

    @PrePersist
    public void prePersisted() {
        if (!isEmailValid(email)) {
            throw new IllegalArgumentException("The email is not valid, bror");
        }
    }

    @PreUpdate
    public void preUpdate() {
        if (!isEmailValid(email)) {
            throw new IllegalArgumentException("The email is not valid, bror-bror");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student() {
    }

    private boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
}
