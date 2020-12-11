package cn.ywsoft.sparrow.bpm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProcessInstanceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/startProcess/{processId}")
	public Object startProcess(@RequestBody final Object body, @PathVariable(name = "processId") String processId) {
		String url = "http://localhost:8080/"+processId;
		return restTemplate.postForObject(url, body, Object.class);
	}
}
