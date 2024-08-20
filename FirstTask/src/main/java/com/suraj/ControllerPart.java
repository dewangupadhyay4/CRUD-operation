package com.suraj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Data")
public class ControllerPart {
	
	@Autowired
	Logic logic;
	
	@GetMapping("/getall")
	public List<Data> getallcont(){
		return logic.getall();
	}
	
	@GetMapping("/{id}")
	public Data getviaid(@PathVariable Long id) {
		return logic.findById(id);
	}
	
	@PostMapping()
	public Data create(@RequestBody Data data) {
		return logic.creating(data);
	}
	
	@PutMapping("/{id}")
	public Data updating(@PathVariable Long id,@RequestBody Data data) {
		Data avail=logic.findById(id);
		avail.setName(data.getName());
		avail.setSalary(data.getSalary());
		return logic.save(avail);
	}
	
	@DeleteMapping("/{id}")
	public void deleting(@PathVariable Long id) {
		logic.delete(id);
	}

}
