package com.au2020.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.au2020.model.Student;
import com.au2020.dao.*;


@Controller
public class HomeController {

	StudentDao dao = new StudentDao();
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("viewstudent");
	}


    @RequestMapping("/studentform")    
    public String showform(Model m){    
    	m.addAttribute("command", new Student());  
        return "studentform";   
    }    
    
    
   
    
  @RequestMapping(value="/save",method = RequestMethod.POST)    
    
    public String save(@ModelAttribute("student") Student student){    

    	dao.save(student);    
        return "redirect:/viewstudent";//will redirect to viewstudent request mapping    
    }    
    
    
    @RequestMapping("/viewstudent")    
    public String viewstudent(Model m){    
        List<Student> list=dao.getStudents();    
        m.addAttribute("list",list);
        return "viewstudent";    
    }    
  
    @RequestMapping(value="/editstudent/{id}")    
    public String edit(@PathVariable String id, Model m){    
        Student student=dao.getStudentById(id);    
        m.addAttribute("command",student);  
        return "studenteditform";    
    }    
  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("student") Student student){    
     
    	System.out.println("edit save");
    	dao.update(student);    
        return "redirect:/viewstudent";    
    }    
    
    @RequestMapping(value="/deletestudent/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable String id){    
        dao.delete(id);    
        return "redirect:/viewstudent";    
    } 

}
