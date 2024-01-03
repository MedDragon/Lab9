package sumdu.edu.ua.mavenproject2.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import sumdu.edu.ua.mavenproject2.model.Student;

@Service
@Transactional
public class TransactionManager {
    private final DAO_Student userRepository;

    @Autowired
    public TransactionManager(DAO_Student userRepository) {
        this.userRepository = userRepository;
    }

    public Student addStudent(Student student) {
        return userRepository.save(student);
    }

    public List<Student> getAllStudent() {
        return userRepository.findAll();
    }

    public Student getStudentById(Integer StudentId) {
        return userRepository.findById(StudentId).orElse(null);
    }

    public Student updateStudent(Student student) {
        return userRepository.save(student);
    }

    public void deleteStudent(Integer StudentId) {
        userRepository.deleteById(StudentId);
    }
}
