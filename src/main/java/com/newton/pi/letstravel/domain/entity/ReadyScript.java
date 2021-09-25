package com.newton.pi.letstravel.domain.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import com.newton.pi.letstravel.api.CustomScriptDto;
import com.newton.pi.letstravel.api.ReadyScriptDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReadyScript {
	@Id
	private String id;
	private String name;
	private String state;
	private String roadmap;
	private Date date;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
	public ReadyScript(ReadyScriptDto readyscriptDto) {
		this.id = readyscriptDto.getId();
		this.name = readyscriptDto.getName();
		this.state = readyscriptDto.getState();
		this.roadmap = readyscriptDto.getRoadmap();
		this.date = readyscriptDto.getDate();
	}
}
