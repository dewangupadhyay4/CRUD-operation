package com.suraj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Logic {
	
	@Autowired
	private Repo repo;
	
	public List<Data> getall(){
		return repo.findAll();
	}

	public Data creating(Data data) {
		return repo.save(data);
		
	}

	public Data findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public Data save(Data avail) {
		return repo.save(avail);
	}

	public void delete(Long id) {
		
		repo.deleteById(id);
	}

}
