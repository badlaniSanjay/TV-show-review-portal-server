package com.example.wbdvprojectsf19javaservergroup13.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvprojectsf19javaservergroup13.models.Analysis;
import com.example.wbdvprojectsf19javaservergroup13.models.Show;
import com.example.wbdvprojectsf19javaservergroup13.services.AnalysisService;

@RestController
@CrossOrigin("*")
public class AnalysisController {

	@Autowired
	private AnalysisService service;
	
	@PostMapping("/api/user/{userId}/show/{showId}/episode/{eid}/analysis")
	public Analysis createAnalysis(@PathVariable("userId") int userId,
			@PathVariable("showId") int showId,
			@PathVariable("eid") int episodeId, @RequestBody Analysis analysis) {
		return service.createAnalysis(userId,showId,episodeId,analysis);
	}
	
	@GetMapping("/api/user/{userid}/episode/{eid}/analysis")
	public List<Analysis> getAnalysisForStudent(@PathVariable("userid") int userId, @PathVariable("eid") int eid) {
		return service.getStudentAnalysisList(userId, eid);
	}
//
//	@GetMapping("/api/user/{userid}/tvshow/{showid}/episode/{eid}/analysis")
//	public List<Analysis> getAnalysisForProfessor(@PathVariable("userid") int userId, @PathVariable("showid") int showId, @PathVariable("eid") int eid) {
//
//		return service.getAnalysisListForProfessor(userId, showId, eid);
//	}
//

	
	@PutMapping("/analysis/{aid}/content/{content}")
	public Analysis updateAnalysis(@PathVariable("aid") int aid, 
			@PathVariable("content") String content) {
		return service.updateAnalysis(aid, content);
	}
	
	@DeleteMapping("/analysis/{aid}")
	public void deleteAnalysis(@PathVariable("aid") int aid) {
		service.deleteAnalysis(aid);
	}
	
	@GetMapping("/api/analysis")
	public List<Analysis> getAllAnalysis() {
		return service.getAllAnalysis();
	}
	
	@GetMapping("/api/episode/{episodeId}/analysis")
	public List<Analysis> getAllAnalysisForEpisode(@PathVariable("episodeId") int episodeId){
		return service.getAllAnalysisForEpisode(episodeId);
		
	}

//	@GetMapping("/api/user/latestAnalysis")
//	public List<Analysis> getLatestAnalysis() {
//
//		return service.getLatestAnalysis();
//	}

	@GetMapping("api/user/analysedShowIds/{sid}")
	public List<Show> getAnalysedShows(@PathVariable("sid") int sid){
		return service.getAnalysedShows(sid);
		}

}
