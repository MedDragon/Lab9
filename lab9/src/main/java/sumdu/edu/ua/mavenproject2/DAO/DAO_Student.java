package sumdu.edu.ua.mavenproject2.DAO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sumdu.edu.ua.mavenproject2.model.Student;

@Repository("DAO_Student")
public interface DAO_Student extends JpaRepository<Student, Integer>{
    
    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Integer studentId);

    Student updateStudent(Student student);

    void deleteStudent(Integer studentId);

    public Student getOne(int parseInt);
}
