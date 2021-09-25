package com.Newton.aaw.LT.domain.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private Integer id;
	
	private String name;
	
	private String password;
	
	private String email;
	
	private String mobile;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime modifiedAt;
}
