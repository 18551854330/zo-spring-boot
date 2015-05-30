package cn.org.guhao.zospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tiles")
public class TilesSampleController {

	@RequestMapping("/sample")
    String list() {
        return "sample";
    }
	
}
