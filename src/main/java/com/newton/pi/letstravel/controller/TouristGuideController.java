package com.newton.pi.letstravel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.newton.pi.letstravel.api.TouristGuideDto;
import com.newton.pi.letstravel.domain.entity.TouristGuide;
import com.newton.pi.letstravel.service.TouristGuideService;

@RestController
public class TouristGuideController {
	
	private final TouristGuideService touristguideService;
	
	public TouristGuideController(TouristGuideService touristguideService) {
		this.touristguideService = touristguideService;
	}
	
	@GetMapping("/touristguide/{id}")
	public TouristGuideDto getById(@PathVariable String id) {
		var touristguide = touristguideService.get(id);
		
		return new TouristGuideDto(touristguide);
	}
	@GetMapping("/touristguides")
	public List<TouristGuideDto> getAll(){
		var touristguides = touristguideService.getAll();
		var touristguideDtos = new ArrayList<TouristGuideDto>();
		
		for(var touristguide: touristguides) {
			touristguideDtos.add(new TouristGuideDto (touristguide));
		}
		return touristguideDtos;
	}
	@PostMapping("/touristguide")
	public TouristGuideDto create(@RequestBody TouristGuideDto g) {
		var touristguide = new TouristGuide(g);
		
		touristguide = touristguideService.create(touristguide);
		
		return new TouristGuideDto(touristguide);
	}
	@PutMapping("/touristguide/{id}")
	public TouristGuideDto update(@PathVariable String id,@RequestBody TouristGuideDto g) {
		var touristguide = new TouristGuide(g);
		
		touristguide = touristguideService.update(id, touristguide);
		
		return new TouristGuideDto(touristguide);
	}
	@DeleteMapping("touristguide/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		touristguideService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
