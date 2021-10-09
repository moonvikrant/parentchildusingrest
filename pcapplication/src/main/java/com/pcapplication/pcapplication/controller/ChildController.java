package com.pcapplication.pcapplication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pcapplication.pcapplication.Repo.ChildRepo;
import com.pcapplication.pcapplication.entity.Child;

@RestController
public class ChildController {
	
	private ChildRepo crepo;

	public ChildController(ChildRepo crepo) {
		super();
		this.crepo = crepo;
	}
	
	@GetMapping("/childs/details/{cid}")
	public Child getChilds(@PathVariable Long cid)
	{
		if(crepo.findById(cid).isPresent())
			return crepo.findById(cid).get();
		else return null;
	}

	@GetMapping("/childs/all")
	public List<Child> getChilds()
	{
		return crepo.findAll();
		
	}
}




