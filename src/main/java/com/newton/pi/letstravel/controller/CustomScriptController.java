package com.newton.pi.letstravel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newton.pi.letstravel.api.CustomScriptDto;
import com.newton.pi.letstravel.domain.entity.CustomScript;
import com.newton.pi.letstravel.service.CustomScriptService;

@RestController
public class CustomScriptController {
	
	private final CustomScriptService customscriptService;
	
	public CustomScriptController(CustomScriptService customscriptService) {
		this.customscriptService = customscriptService;
	}
	
	@GetMapping("/touristguide/{id}")
	public CustomScriptDto getById(@PathVariable String id) {
		var customscript = customscriptService.get(id);
		
		return new CustomScriptDto(customscript);
	}
	@GetMapping("/customscript")
	public List<CustomScriptDto> getAll(){
		var customscripts = customscriptService.getAll();
		var customscriptDtos = new ArrayList<CustomScriptDto>();
		
		for(var customscript: customscripts) {
			customscriptDtos.add(new CustomScriptDto (customscript));
		}
		return customscriptDtos;
	}
	@PostMapping("/customscript")
	public CustomScriptDto create(@RequestBody CustomScriptDto c) {
		var customscript = new CustomScript(c);
		
		customscript = customscriptService.create(customscript);
		
		return new CustomScriptDto(customscript);
	}
	@PutMapping("/customscript/{id}")
	public CustomScriptDto update(@PathVariable String id,@RequestBody CustomScriptDto c) {
		var customscript = new CustomScript(c);
		
		customscript = customscriptService.update(id, customscript);
		
		return new CustomScriptDto(customscript);
	}
	@DeleteMapping("customscript/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		customscriptService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
