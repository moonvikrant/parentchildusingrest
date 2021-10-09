package com.pcapplication.pcapplication.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pcapplication.pcapplication.Repo.ParentRepo;
import com.pcapplication.pcapplication.entity.Parent;
import com.pcapplication.pcapplication.service.ParentService;


@RestController
public class ParentController 
{

	private ParentService pservice;
    private ParentRepo prepo;

    public ParentController(ParentService pservice, ParentRepo prepo) {
		super();
		this.pservice = pservice;
		this.prepo = prepo;
	}
    
    
    
	@PostMapping("/parent/create")
    public ResponseEntity<Object> createParent(@RequestBody Parent parent) {
        return  pservice.addparent(parent);
    }
	
    @DeleteMapping("/parent/delete/{pid}")
    public ResponseEntity<Object> deleteParent(@PathVariable Long pid) {
        return pservice.deleteparent(pid);
    }
    
    @GetMapping("/parent/details/{pid}")
    public Parent getParent(@PathVariable Long pid) {
        if(prepo.findById(pid).isPresent())
            return prepo.findById(pid).get();
        else return null;
    }
    
    @GetMapping("/parent/all")
    public List<Parent> getParents() {
        return prepo.findAll();
    }
	
    @PutMapping("/parent/update")
    public ResponseEntity<Object> updateparents(@RequestBody Parent parent) {
        return pservice.updateparent(parent);
    }
	
}
