package com.newton.pi.letstravel.api;

import java.sql.Date;
import java.time.LocalDateTime;

import com.newton.pi.letstravel.domain.entity.ReadyScript;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReadyScriptDto {
	private String id;
	private String name;
	private String state;
	private String roadmap;
	private Date date;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
	public ReadyScriptDto(ReadyScript r) {
		this.id = r.getId();
		this.name = r.getName();
		this.state = r.getState();
		this.roadmap = r.getRoadmap();
		this.date = r.getDate();
		this.createdAt = r.getCreatedAt();
		this.modifiedAt = r.getModifiedAt();
	}
}
