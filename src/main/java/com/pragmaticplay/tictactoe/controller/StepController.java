package com.pragmaticplay.tictactoe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragmaticplay.tictactoe.db.dao.StepDAO;
import com.pragmaticplay.tictactoe.db.entity.Step;
import com.pragmaticplay.tictactoe.db.enums.Status;
import com.pragmaticplay.tictactoe.service.StepService;

@RestController
@RequestMapping("step/")
public class StepController {
	
	@Autowired
	private StepDAO stepDAO;
	
	@Autowired
	private StepService stepService;
	
	@GetMapping(value = "/allByGame/{idGame}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Step> getAll(@PathVariable Long idGame) {
		return stepDAO.getStepsByGame(idGame);
	}
	
	@PostMapping(value = "/newStepAndRefreshStatus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Status newStepAndRefreshStatus(@RequestBody Step newStep) {
		return stepService.newStepAndRefreshStatus(newStep);
	}

}
