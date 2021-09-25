package com.newton.pi.letstravel.domain.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;

import com.newton.pi.letstravel.api.CustomScriptDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomScript {
	@Id
	private String id;
	private String name;
	private String state;
	private String roadmap;
	private Date date;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
	public CustomScript(CustomScriptDto customscriptDto) {
		this.id = customscriptDto.getId();
		this.name = customscriptDto.getName();
		this.state = customscriptDto.getState();
		this.roadmap = customscriptDto.getRoadmap();
		this.date = customscriptDto.getDate();
	}
		
}
