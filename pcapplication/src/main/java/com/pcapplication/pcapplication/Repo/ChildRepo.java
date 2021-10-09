package com.pcapplication.pcapplication.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pcapplication.pcapplication.entity.Child;

@Repository
public interface ChildRepo extends JpaRepository<Child, Long> 
{
	Optional<Child> findByCattr(String cattr);
}
