ppackage com.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Gender;
import com.entity.Person;

@Controller
public class PersonController {
	@RequestMapping("/register.htm")
	public ModelAndView load(ModelMap map) {
		Person p = new Person();
		ModelAndView mv = new ModelAndView();
		map.addAttribute(p);
		mv.setViewName("register");
		return mv;
	}

	@RequestMapping("/add.htm")
	public ModelAndView add(Person p, ModelMap map) {

		ModelAndView mv = new ModelAndView();
		map.addAttribute("Name", p.getName());
		map.addAttribute("Address", p.getAddress());
		map.addAttribute("Age", p.getAge());
		map.addAttribute("Gender", p.getGender());
		mv.setViewName("result");
		return mv;
	}

	@ModelAttribute("genderList")
	public ArrayList<Gender> populate() {
		ArrayList<Gender> list = new ArrayList<Gender>();
		Gender g1 = new Gender();
		g1.setGender("gender");
		Gender g2 = new Gender();
		g2.setGender("Female");
		list.add(g1);
		list.add(g2);
		return list;
	}
}
