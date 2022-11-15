package com.demo.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpRepository;

@RestController
public class EmployeeRestController {

	@Autowired
	EmpRepository repo;
	
	
	//---------------------------------Create Employee Detail----------------------------------------
	@PostMapping(value="/emp", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addEmp(@RequestBody Emp e) {
		if(repo.existsById(e.getId())) {
			return ResponseEntity.ok("{\"status\":\"Emp Exists\"}");
		}
		else {
			repo.save(e);
			return ResponseEntity.ok("{\"status\":\"Emp saved....\"}");

		}
	}
	
	
	
	//---------------------Get Detail of Employee-----------------------------------------------------------
	@GetMapping(value="/emp/{id}" ,produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findEmpById(@PathVariable("id") int id) {
		Optional<Emp> empop=repo.findById(id);
		if(empop.isPresent()) {
			return ResponseEntity.ok(empop.get());
		}
		else {
			return ResponseEntity.status(404).body("{\"status\":\"Emp with id not found\"}");
		}
		
	}
	
	//-------------------Update Employee Details----------------------------------------------------------
	@PutMapping(value="/emp", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateEmp(@RequestBody Emp e) {
		if(repo.existsById(e.getId())) {
			repo.save(e);
			return ResponseEntity.ok("{\"status\":\"Emp Updated\"}");
		}
		else {
			
			return ResponseEntity.ok("{\"status\":\"Emp not found....\"}");

		}
	}
	
	
	//--------------------Delete Employee Details--------------------------------------------------------------
	@DeleteMapping(value="/emp/{id}" ,produces= MediaType.APPLICATION_JSON_VALUE)
       public ResponseEntity<String> deleteEmp( @PathVariable Integer id)
       {

            if(repo.existsById(id))
            {
                 repo.deleteById(id);
                return ResponseEntity.ok("{\"status\":\"Emp deleted\")");
            }
            else
            {
                return ResponseEntity.ok("{\"status\":\"Emp does not exists\")");
            }

       }
	
}
