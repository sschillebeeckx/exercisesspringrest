package be.abis.exercise.controller;

import be.abis.exercise.model.Person;
import be.abis.exercise.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
     
	@Autowired
    TrainingService trainingService;
	
	@GetMapping("/")
	public String printCourse(Model model){
		String title = trainingService.getCourseService().findCourse(7900).getShortTitle();
		model.addAttribute("coursetitle", title);
		Person p = trainingService.getPersonService().findPerson(3);
		model.addAttribute("fullName",p.getFirstName()+" "+p.getLastName());
		return "course";
	}
}
