package com.newton.aaw.hr.domain.entity;

import com.newton.aaw.hr.api.UserDto;

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

	private Gender gender;

	public User(UserDto userDto) {
		this.id = userDto.getId();
		this.name = userDto.getName();
		this.password = userDto.getPassword();
		this.email = userDto.getEmail();
		this.gender = userDto.getGender();
	}

}
