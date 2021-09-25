package com.Newton.aaw.LT.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.Newton.aaw.LT.domain.entity.User;

@Service
public class UserService {
	
	private static int id=0;
	private Map<Integer, User> users = new HashMap<Integer, User>();
	
	//C - CRUD
	public User create(User u) {
		u.setId(++id);
		
		u.setCreatedAt(LocalDateTime.now());
		u.setModifiedAt(LocalDateTime.now());
		
		users.put(id, u);

	return u;
	}
	
	//u -CRUD
	public User update(Integer Id, User u) {
		
		//recuperar para validar se existe
		var existing = get(id);
		existing.setName(u.getName());
		existing.setPassword(u.getPassword());
		existing.setEmail(u.getEmail());
		existing.setMobile(u.getMobile());
		
		existing.setModifiedAt(LocalDateTime.now());
		
		return u;		
	}
	
	//R - CRUD
	public User get(Integer id){
		
		var u = users.get(id);
		
		if(u == null) {
			/// todo expecepition
		}
		
		return u; 
	}
	
	// R - CRUD
	public List<User>getAll(){
		return new ArrayList<>(users.values());
	}
	
	//D - CRUD
	public void delete(Integer id) {
		//recuperar para validar se existe
		get(id);
		
		users.remove(id);
	}
}


