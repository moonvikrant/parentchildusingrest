package com.pcapplication.pcapplication.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pcapplication.pcapplication.entity.Parent;

@Repository
public interface ParentRepo extends JpaRepository<Parent, Long>
{
	//Optional<Parent> findByPname(String pname);
	
}
