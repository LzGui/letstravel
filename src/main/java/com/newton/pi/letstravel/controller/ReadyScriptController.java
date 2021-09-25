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

import com.newton.pi.letstravel.api.ReadyScriptDto;
import com.newton.pi.letstravel.domain.entity.ReadyScript;
import com.newton.pi.letstravel.service.ReadyScriptService;



@RestController
public class ReadyScriptController {
private final ReadyScriptService readyscriptService;
	
	public ReadyScriptController(ReadyScriptService readyscriptService) {
		this.readyscriptService = readyscriptService;
	}
	
	@GetMapping("/readyscript/{id}")
	public ReadyScriptDto getById(@PathVariable String id) {
		var readyscript = readyscriptService.get(id);
		
		return new ReadyScriptDto(readyscript);
	}
	@GetMapping("/readyscript")
	public List<ReadyScriptDto> getAll(){
		var readyscripts = readyscriptService.getAll();
		var readyscriptDtos = new ArrayList<ReadyScriptDto>();
		
		for(var readyscript: readyscripts) {
			readyscriptDtos.add(new ReadyScriptDto (readyscript));
		}
		return readyscriptDtos;
	}
	@PostMapping("/readyscript")
	public ReadyScriptDto create(@RequestBody ReadyScriptDto r) {
		var readyscript = new ReadyScript(r);
		
		readyscript = readyscriptService.create(readyscript);
		
		return new ReadyScriptDto(readyscript);
	}
	@PutMapping("/readyscript/{id}")
	public ReadyScriptDto update(@PathVariable String id,@RequestBody ReadyScriptDto r) {
		var readyscript = new ReadyScript(r);
		
		readyscript = readyscriptService.update(id, readyscript);
		
		return new ReadyScriptDto(readyscript);
	}
	@DeleteMapping("readyscript/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		readyscriptService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
