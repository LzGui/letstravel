package com.newton.pi.letstravel.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.newton.pi.letstravel.domain.entity.CustomScript;
import com.newton.pi.letstravel.domain.repository.CustomScriptRepository;
import com.newton.pi.letstravel.exception.NotFoundException;

@Service
public class CustomScriptService {
private final CustomScriptRepository customscriptRepository;
	
	public CustomScriptService(CustomScriptRepository customscriptRepository) {
		this.customscriptRepository = customscriptRepository;
	}
	
	public CustomScript create(CustomScript c) {
		
		c.setCreatedAt(LocalDateTime.now());
		c.setModifiedAt(LocalDateTime.now());
		
		customscriptRepository.save(c);
		
		return c;
	}
	public CustomScript update(String id, CustomScript c) {
		var existing = get(id);
		
		existing.setName(c.getName());
		existing.setRoadmap(c.getRoadmap());
		existing.setState(c.getState());
		existing.setDate(c.getDate());
		existing.setModifiedAt(LocalDateTime.now());

		customscriptRepository.save(existing);
		
		return existing;
	}
	public CustomScript get(String id) {
		var customscript = customscriptRepository.findById(id);
		if (customscript.isEmpty()) {
			throw new NotFoundException("TourisGuide with ID " + id + "not found");
			
		}
		return customscript.get();
	}
	public List<CustomScript> getAll() {
		return customscriptRepository.findAll();
	}
	public void delete(String id) {
	get(id);
	
	customscriptRepository.deleteById(id);
	}
}
