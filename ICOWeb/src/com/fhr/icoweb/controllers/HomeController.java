package com.fhr.icoweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 主页及通用页面控制器
 * @author fhr
 * @date 2017/06/04 
 */
@Controller
public class HomeController {
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping("")
	public String index(){
		return "index";
	}
	
}
