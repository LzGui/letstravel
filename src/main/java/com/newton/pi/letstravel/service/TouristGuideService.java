package com.newton.pi.letstravel.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.newton.pi.letstravel.domain.entity.TouristGuide;
import com.newton.pi.letstravel.domain.repository.TouristGuideRepository;
import com.newton.pi.letstravel.exception.NotFoundException;

@Service
public class TouristGuideService {

	private final TouristGuideRepository touristguideRepository;
	
	public TouristGuideService(TouristGuideRepository touristguideRepository) {
		this.touristguideRepository = touristguideRepository;
	}
	
	public TouristGuide create(TouristGuide g) {
		
		g.setCreatedAt(LocalDateTime.now());
		g.setModifiedAt(LocalDateTime.now());
		
		touristguideRepository.save(g);
		
		return g;
	}
	public TouristGuide update(String id, TouristGuide g) {
		var existing = get(id);
		
		existing.setName(g.getName());
		existing.setRoadmap(g.getRoadmap());
		existing.setState(g.getState());
		existing.setDate(g.getDate());
		existing.setModifiedAt(LocalDateTime.now());

		touristguideRepository.save(existing);
		
		return existing;
	}
	public TouristGuide get(String id) {
		var touristguide = touristguideRepository.findById(id);
		if (touristguide.isEmpty()) {
			throw new NotFoundException("TourisGuide with ID " + id + "not found");
			
		}
		return touristguide.get();
	}
	public List<TouristGuide> getAll() {
		return touristguideRepository.findAll();
	}
	public void delete(String id) {
	get(id);
	
	touristguideRepository.deleteById(id);
	}
}

