package cn.org.guhao.zospringboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.org.guhao.zospringboot.domain.Example;
import cn.org.guhao.zospringboot.repository.ExampleRepository;

@Controller
@RequestMapping("/example")
public class ExampleController {

	@Autowired
	private ExampleRepository repo;

	@RequestMapping("/list")
    String list(Model model) {
		Iterable<Example> examples = repo.findAll();
		model.addAttribute("examples", examples);
        return "example/list";
    }
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	String edit(Model model, HttpServletRequest request){
		String id = request.getParameter("id");
		Example example = null;
		String returnString = "example/add";
		if(id != null){
			Long idL = Long.parseLong(id);
			example = repo.findOne(idL);
		}
		if(example != null){
			model.addAttribute("example", example);
			returnString = "example/edit";
		}
		return returnString;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	String save(Model model, @ModelAttribute("example") Example example){
		// update
		if(example.getId()!=null && repo.exists(example.getId())){
			repo.save(example);
		}else{
		// create
			repo.save(example);
		}
		return "redirect:/example/list";
	}
	
	@RequestMapping(value="example/delete")
	String remove(@RequestParam("id") Long id){
		if(repo.exists(id)){
			repo.delete(id);
		}
		return "redirect:/example/list";
	}
	
}
