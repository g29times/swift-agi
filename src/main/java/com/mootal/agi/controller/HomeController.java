package com.mootal.agi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * . _________         .__   _____   __
 * ./   _____/__  _  __|__|_/ ____\_/  |_
 * .\_____  \ \ \/ \/ /|  |\   __\ \   __\
 * ./        \ \     / |  | |  |    |  |
 * /_______  /  \/\_/  |__| |__|    |__|
 * .       \/
 * <p>
 * <a href="www.google.com">google</a>
 *
 * @author li tong
 * @description:
 * @date 2025/02/25 15:19
 * @see Object
 * @since 1.0
 */
@Controller
@RequestMapping("/home")
public class HomeController {

	/**
	 * Return the name of the view to render.
	 * <p>
	 * Mapping to the root of the application.
	 *
	 * @return the name of the view to render
	 */
	@GetMapping("/")
	public String home() {
		return "index";
	}

}
