package sumdu.edu.ua.mavenproject2.Controllers;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sumdu.edu.ua.mavenproject2.DAO.DAO_Student;
import sumdu.edu.ua.mavenproject2.model.Student;

@Controller
public class StudentController {
    List<Student> students;
    ApplicationContext factory;
    
    @Autowired
    private DAO_Student dao;
    
    @ModelAttribute
    public void modelData(Model m){
        if(students==null){ students = new LinkedList<Student>();}
        factory = new ClassPathXmlApplicationContext("/spring.xml");
    }
    
    @RequestMapping("/")
    public String home(Model m) {
        students=dao.getAllStudents();
        m.addAttribute("students", dao.findAll());
	return "student";
    }
    
    @RequestMapping(value = "/StudentAdd")
    public String addStudent(HttpServletRequest request,Model m){              
        if (request.getParameter("name") != "" && request.getParameter("surname") != "") {
            Student student = (Student) factory.getBean("Student");
            
            student.setName(request.getParameter("name"));
            student.setSurname(request.getParameter("surname"));
            student.setAge(Integer.parseInt(request.getParameter("age")));
            student.setEmail(request.getParameter("email"));
            student.setGroup(request.getParameter("group"));
            student.setFaculty(request.getParameter("faculty"));
            dao.save(student);
        }
        
        students=dao.findAll();
    
        m.addAttribute("students", students);
        return "student";
    }     
}
