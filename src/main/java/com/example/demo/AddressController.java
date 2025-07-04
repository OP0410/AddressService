package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
			@Autowired
			MyRepo repo;
			@GetMapping("/address")
			public List<Address> show()
			{
				return this.repo.findAll();
			}
			@PostMapping("/address")
			public Address save(@RequestBody Address a)
			{
				return this.repo.save(a);
			}
			@PutMapping("/address/{hno}")
			public Address update(@RequestBody Address a,@PathVariable("hno") int id)
			{
				Optional<Address> rc=repo.findById(id);
				if(rc.isPresent())
				{
					a.setHno(id);
					return this.repo.save(a);
				}else
				{
					return null;
				}
			}
			@DeleteMapping("/address/{hno}")
			public String delete(@PathVariable("hno") int id)
			{
				repo.deleteById(id);
				return "No Content";
			}
}
