package com.newton.pi.letstravel.api;

import java.sql.Date;
import java.time.LocalDateTime;

import com.newton.pi.letstravel.domain.entity.TouristGuide;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TouristGuideDto {

	private String id;
	private String name;
	private String state;
	private String roadmap;
	private Date date;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
	public TouristGuideDto(TouristGuide g) {
		this.id = g.getId();
		this.name = g.getName();
		this.state = g.getState();
		this.roadmap = g.getRoadmap();
		this.date = g.getDate();
		this.createdAt = g.getCreatedAt();
		this.modifiedAt = g.getModifiedAt();
	}
}
