package com.sy.EmpSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.EmpSystem.dto.EMP;
import com.sy.EmpSystem.repos.EMPRepos;

@Service
public class EMPService {
	
	@Autowired
	EMPRepos repos;
	
	public void addEmp(EMP emp) {
		repos.save(emp);
	}
	
	public List<EMP> getAllEMP() {
		return repos.findAll();
	}
	
	public EMP getEMPById(int id) {
		Optional<EMP> optional= repos.findById(id);
		if (optional.isPresent()) {
			optional.get();
		}
		return null;
		
	}
	
	public void deleteEMP(int id) {
		repos.deleteById(id);
	}
}
