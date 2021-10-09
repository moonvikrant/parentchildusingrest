package com.pcapplication.pcapplication.service;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pcapplication.pcapplication.Repo.ChildRepo;
import com.pcapplication.pcapplication.Repo.ParentRepo;
import com.pcapplication.pcapplication.entity.Parent;

@Service
public class ParentService 
{
	
	private ParentRepo prepo;

    @SuppressWarnings("unused")
	private  ChildRepo crepo;

    

    public ParentService(ParentRepo prepo, ChildRepo crepo) {
		super();
		this.prepo = prepo;
		this.crepo = crepo;
	}

	/**
     * Create a new role along with users
     */

    @Transactional
    public ResponseEntity<Object> addparent(Parent parent) {

        Parent p = new Parent();
       p.setPname(parent.getPname());
        p.setPattr(parent.getPattr());

        p.setChilds(parent.getChilds());
        Parent savedata = prepo.save(p);
        
        if (prepo.findById(savedata.getPid()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Role and Users");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
    }

    /**
     * Delete a specified role given the id
     */
    public ResponseEntity<Object> deleteparent(Long pid) {
        if (prepo.findById(pid).isPresent()) {
            prepo.deleteById(pid);
            if (prepo.findById(pid).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }
	
    
     public ResponseEntity<Object> updateparent(Parent parent)
    {
    	Parent entity=prepo.save(parent);
    	if (prepo.findById(entity.getPid()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Role and Users");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
    }
	
}
