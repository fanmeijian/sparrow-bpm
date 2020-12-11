package cn.ywsoft.sparrow.bpm.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserTaskInstanceController {
	
	@Autowired
	RestTemplate restTemplate;
	
//	@Autowired
//	UserTaskInstanceRepository userTaskInstanceRepository;
//	
//	@GetMapping("/usertaskinstances")
//	public Page<?> userTaskInstances(){
//		return userTaskInstanceRepository.findAll(Pageable.unpaged());
//		String[] a = new String[1];
//		a[0]="trial-follower";
//		return userTaskInstanceRepository.findByPotentialGroups(a,Pageable.unpaged());
//	}
	
	
	@PostMapping("/userTask")
	public Object userTask(@RequestParam(name = "endPoint") String endPoint, @RequestParam(name = "phase") String phase,@RequestBody final Object body) {
		String url = null;
		try {
			url = URLDecoder.decode(endPoint,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return restTemplate.postForObject(url + "?phase="+ phase, body, Object.class);
	}
}
