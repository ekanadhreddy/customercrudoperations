package com.example.prime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.prime.entity.Prime;
import com.example.prime.repo.Primerepo;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
public class primeController {

	
	@Autowired
	Primerepo primeRepo;
	
	//----- postmapping-----
	
	@PostMapping("api/prime")
	public ResponseEntity<Prime> saveCustomerDetails(@RequestBody Prime prime)
	{
		return new ResponseEntity<>(primeRepo.save(prime),HttpStatus.CREATED);
	}
	
	//----getmapping--
	
	@GetMapping("api/prime/list")
	public ResponseEntity<List<Prime>> getAllCustomerDetails(){
		return new ResponseEntity<>(primeRepo.findAll(),HttpStatus.OK);
	}
	
	//--get mapping--
	
	@GetMapping("api/prime/{customerId}")
	public ResponseEntity<Prime>getDetailsById(@PathVariable long customerId){
		java.util.Optional<Prime> prime = primeRepo.findById(customerId);
		if(prime.isPresent()) {
			return new  ResponseEntity<>(prime.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	// --- put mapping --
	
	@PutMapping("api/prime/{customerId}")
	public ResponseEntity<Prime> UpdateCustomerDetails(@PathVariable Long customerId, @RequestBody Prime primeup){
		java.util.Optional<Prime> prime = primeRepo.findById(customerId);
		if(prime.isPresent()) {
			prime.get().setCustomerName(primeup.getCustomerName());
			prime.get().setPayment(primeup.getPayment());
			prime.get().setNotification(primeup.isNotification());
			
			return new ResponseEntity<>(primeRepo.save(prime.get()),HttpStatus.OK);
	}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
}
	
	//-- Delete Mapping
	
	@DeleteMapping("api/prime/{customerId}")
	public ResponseEntity<Prime>deletecustomer(@PathVariable long customerId){
		java.util.Optional<Prime> prime = primeRepo.findById(customerId);
		if(prime.isPresent()) {
			primeRepo.deleteById(customerId);
			return new  ResponseEntity<>(HttpStatus.OK);
			
		}
		else {  
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
