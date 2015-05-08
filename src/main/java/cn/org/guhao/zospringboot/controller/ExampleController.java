package cn.org.guhao.zospringboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.org.guhao.zospringboot.domain.Example;
import cn.org.guhao.zospringboot.repository.ExampleRepository;

@Controller
public class ExampleController {

	@Autowired
	private ExampleRepository repo;

	@RequestMapping("example/list")
    String list(Model model) {
		Iterable<Example> examples = repo.findAll();
		model.addAttribute("examples", examples);
        return "example/list";
    }
	
	@RequestMapping(name="example/edit", method=RequestMethod.GET)
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
	
	@RequestMapping(name="example/update",method=RequestMethod.POST)
	String update(Model model, @ModelAttribute("example") Example example){
		if(repo.exists(example.getId())){
			repo.save(example);
		}else{
			repo.save(example);
		}
		return "example/list";
	}
	
}
