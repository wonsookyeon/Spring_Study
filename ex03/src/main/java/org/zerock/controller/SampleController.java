package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")
public class SampleController {
	
	@GetMapping("/map2")
	public void mapTest(Model model) {
		
		Map<String, String> map = new HashMap<String, String>();
		Map<String, Map<String, String>> map2 = new HashMap();
		
		map.put("name", "조조");
		map.put("age", "20");
		map.put("address", "장안");
		map2.put("a1", map);
		
		map = new HashMap<String, String>();
		map.put("name", "유비");
		map.put("age", "40");
		map.put("address", "안중");
		map2.put("a2", map);
		
		map = new HashMap<String, String>();
		map.put("name", "손권");
		map.put("age", "30");
		map.put("address", "오나라");
		map2.put("a3", map);
		
		
		
		model.addAttribute("map", map);
		model.addAttribute("map2", map2);
	}

}
