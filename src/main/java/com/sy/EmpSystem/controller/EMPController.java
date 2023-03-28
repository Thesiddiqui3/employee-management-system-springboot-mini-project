package com.sy.EmpSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sy.EmpSystem.dto.EMP;
import com.sy.EmpSystem.service.EMPService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EMPController {

	@Autowired
	EMPService service;
	
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<EMP> emps=service.getAllEMP();
		
		model.addAttribute("emps",emps);
		
		
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute EMP emp,HttpSession session) {
		System.out.println(emp);
		
		service.addEmp(emp);
		
		session.setAttribute("msg", "employee Added Successfully");
		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id ,Model model) {
		
		EMP emp=service.getEMPById(id);
		
		model.addAttribute("emp",emp);
		
		return "edit";
	}
	@PostMapping("/update")
	public String updateEMP(@ModelAttribute EMP emp,HttpSession session) {
		service.addEmp(emp);
		session.setAttribute("msg", "emp dat aupdated successfully");
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteEMP(@PathVariable int id) {
		service.deleteEMP(id);
		return "redirect:/";
	}
}
