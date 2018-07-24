package com.pragmaticplay.tictactoe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/gamePage/{idGame}")
	public String gamePage(@PathVariable String idGame) {
		return "game.html";
	}
	
}
