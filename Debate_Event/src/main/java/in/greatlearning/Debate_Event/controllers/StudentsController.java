package in.greatlearning.Debate_Event.controllers;

import ch.qos.logback.core.CoreConstants;
import in.greatlearning.Debate_Event.entities.Student;
import in.greatlearning.Debate_Event.entities.User;
import in.greatlearning.Debate_Event.security.MyUserDetails;
import in.greatlearning.Debate_Event.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    public String listStudents(Model theModel){

        List<Student> students=studentService.findAll();
        theModel.addAttribute("Students",students);
        return "list-Students";
    }

    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Student theStudent=new Student();
        theModel.addAttribute("Student",theStudent);
        return "Student-Form";
    }

    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId,Model theModel){
        Student theStudent=studentService.findById(theId);
        theModel.addAttribute("Student",theStudent);
        return "Student-Form";
    }

    @PostMapping("/save")
    public String saveStudent(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("department") String department,@RequestParam("country") String country){
        System.out.println(id);
        Student theStudent;
        if(id!=0){
            theStudent=studentService.findById(id);
            theStudent.setName(name);
            theStudent.setDepartment(department);
            theStudent.setCountry(country);
        }
        else
            theStudent=new Student(name,department,country);
        studentService.save(theStudent);
        return "redirect:/students/list";
    }

    @RequestMapping("/delete")
    public  String deleteStudent(@RequestParam("studentId") int theId){
        studentService.deleteById(theId);
        return "redirect:/students/list";
    }

    @RequestMapping(value="/403")
    public ModelAndView accessDenied(Principal user){
        ModelAndView model=new ModelAndView();
        if (user!=null) {
            model.addObject("msg", "Hi" + user.getName() + ",You do not have permission to access this page!");
        }else {
            model.addObject("msg","You do not have permission to access this page!");
        }
        model.setViewName("403");
        return model;
    }
}
