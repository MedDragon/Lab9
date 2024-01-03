package sumdu.edu.ua.mavenproject2.Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sumdu.edu.ua.mavenproject2.DAO.DAO_Student;
import sumdu.edu.ua.mavenproject2.DAO.DAO_Content;
import sumdu.edu.ua.mavenproject2.model.Content;
import sumdu.edu.ua.mavenproject2.model.Student;
@Controller
public class ControllContent {
    List<Content> marks;
    ApplicationContext factory;
     
    @Autowired
    DAO_Student student;
    
    @Autowired
    DAO_Content mark;
    
    @RequestMapping(value = "UserContent", method=RequestMethod.GET)
    public ModelAndView formContent(@RequestParam("id2") String id2,Model m,HttpServletRequest request,HttpServletResponse response)
            throws IOException, SQLException{ 
        ModelAndView modelNview = new ModelAndView();
        modelNview.setViewName("mark");
        response.setCharacterEncoding("UTF-8");
        ApplicationContext factory = new ClassPathXmlApplicationContext("/spring.xml");
        Student st=student.getOne(Integer.parseInt(id2));
        modelNview.addObject("user",st);
        marks=mark.getMarksByStId(st.getId());
        modelNview.addObject("marks",marks);
        return modelNview;
    }
}