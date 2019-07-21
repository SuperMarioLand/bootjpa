package com.telusko.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.demo.dao.AlienRepo;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() 
	{
		return "home.jsp";
	}
	
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid)
	{
		Alien a = repo.getOne(aid);
		
		repo.delete(a);
		
		return "Deleted";
	}
	
	@PutMapping("/alien")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
//	@RequestMapping("addAlien")
//	public String addAlien(Alien alien)
//	{
//		repo.save(alien);
//		return "home.jsp";
//	}
	
	//@RequestMapping(path="/aliens", produces={"application/xml"})
	@GetMapping("/aliens")
	//@ResponseBody - WE CAN USE REST CONTROLLER FOR ALL THESE GUYS
	public List<Alien> getAliens()
	{
		return repo.findAll();
	}
	
	@GetMapping("/alien/{aid}")
//	@ResponseBody
	public Optional <Alien>getAlien(@PathVariable("aid")int aid)
	{
		return repo.findById(aid);
	}
	
//	@RequestMapping("getAlien")
//	public ModelAndView getAlien(@RequestParam int aid)
//	{
//		ModelAndView mv = new ModelAndView("showAlien.jsp");
//		Alien alien = repo.findById(aid).orElse(new Alien());

//		System.out.println(repo.findByTech("Java"));
//		System.out.println(repo.findByAidGreaterThan(102));
//		System.out.println(repo.findByTechSorted("Java"));
		
//		mv.addObject(alien);
//		return mv;
//	}
}
