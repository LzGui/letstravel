package com.newton.pi.letstravel.api;

import java.sql.Date;
import java.time.LocalDateTime;

import com.newton.pi.letstravel.domain.entity.CustomScript;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomScriptDto {
	private String id;
	private String name;
	private String state;
	private String roadmap;
	private Date date;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
	public CustomScriptDto(CustomScript c) {
		this.id = c.getId();
		this.name = c.getName();
		this.state = c.getState();
		this.roadmap = c.getRoadmap();
		this.date = c.getDate();
		this.createdAt = c.getCreatedAt();
		this.modifiedAt = c.getModifiedAt();
	}
}
