package com.newton.pi.letstravel.domain.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.newton.pi.letstravel.api.TouristGuideDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TouristGuide {
	
	@Id
	private String id;
	private String name;
	private String state;
	private String roadmap;
	private Date date;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
	public TouristGuide(TouristGuideDto touristguideDto) {
		this.id = touristguideDto.getId();
		this.name = touristguideDto.getName();
		this.state = touristguideDto.getState();
		this.roadmap = touristguideDto.getRoadmap();
		this.date = touristguideDto.getDate();
	}
		
}
