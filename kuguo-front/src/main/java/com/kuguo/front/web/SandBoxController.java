package com.kuguo.front.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SandBoxController {
	@RequestMapping("")
	public String sandBox(){
		return "sandbox";
	}
}
