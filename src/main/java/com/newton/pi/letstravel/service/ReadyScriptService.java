package com.newton.pi.letstravel.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.newton.pi.letstravel.domain.entity.ReadyScript;
import com.newton.pi.letstravel.domain.repository.ReadyScriptRepository;
import com.newton.pi.letstravel.exception.NotFoundException;

@Service
public class ReadyScriptService {
	
	private final ReadyScriptRepository readyscriptRepository;
	
	public ReadyScriptService(ReadyScriptRepository readyscriptRepository) {
		this.readyscriptRepository = readyscriptRepository;
	}
	
	public ReadyScript create(ReadyScript r) {
		
		r.setCreatedAt(LocalDateTime.now());
		r.setModifiedAt(LocalDateTime.now());
		
		readyscriptRepository.save(r);
		
		return r;
	}
	public ReadyScript update(String id, ReadyScript r) {
		var existing = get(id);
		
		existing.setName(r.getName());
		existing.setRoadmap(r.getRoadmap());
		existing.setState(r.getState());
		existing.setDate(r.getDate());
		existing.setModifiedAt(LocalDateTime.now());

		readyscriptRepository.save(existing);
		
		return existing;
	}
	public ReadyScript get(String id) {
		var touristguide = readyscriptRepository.findById(id);
		if (touristguide.isEmpty()) {
			throw new NotFoundException("TourisGuide with ID " + id + "not found");
			
		}
		return touristguide.get();
	}
	public List<ReadyScript> getAll() {
		return readyscriptRepository.findAll();
	}
	public void delete(String id) {
	get(id);
	
	readyscriptRepository.deleteById(id);
	}
}
