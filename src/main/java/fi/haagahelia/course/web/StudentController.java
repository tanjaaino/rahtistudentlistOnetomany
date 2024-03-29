package fi.haagahelia.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.domain.DepartmentRepository;
import fi.haagahelia.course.domain.Student;
import fi.haagahelia.course.domain.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	private StudentRepository studentRepository; 

	@Autowired
	private DepartmentRepository departmentReposository; 
	
	// Show all students
    @RequestMapping(value="/studentlist")
    public String studentList(Model model) {	
        model.addAttribute("students", studentRepository.findAll());
        return "studentlist";
    }
  
    // Add new student
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addStudent(Model model){
    	model.addAttribute("student", new Student());
    	model.addAttribute("departments", departmentReposository.findAll());
        return "addstudent";  //.html
    }     
    
    // Save new student
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Student student){
        studentRepository.save(student);
        return "redirect:/studentlist";
    }    

    // Delete student
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long studentId, Model model) {
    	studentRepository.deleteById(studentId);
        return "redirect:/studentlist";
    }     
}
