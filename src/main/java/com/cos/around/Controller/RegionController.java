package com.cos.around.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.around.Model.Region;
import com.cos.around.Repository.RegionRepository;


@RestController
@RequestMapping("/region")
public class RegionController {
	
	@Autowired
	RegionRepository regionRepository;
	
	@PostMapping("/test/save")
	public Region save(Region region) {

		
		return regionRepository.save(region); 
	}
	@GetMapping("/test/findall")
	public List<Region> findAll() {

		
		return regionRepository.findAll(); 
	}
	@GetMapping("/test/findby/{num}")
	public Region findByID(@PathVariable int num) {

		Optional<Region> opR = regionRepository.findById(num);
		if(opR.isPresent()) {
		Region region = opR.get();
		return region;
		}
		return null;
		 
	}
	@PostMapping("/test/update")
	public Region update(Region region ) {
		System.out.println(region.getRegionNum());
		
		return regionRepository.save(region); 
	}
	@PostMapping("/test/delete/{num}")
	public String delete(@PathVariable int num) {
		
		regionRepository.deleteById(num);
		  
		return " \"delete\" : "+num;
	}
}
