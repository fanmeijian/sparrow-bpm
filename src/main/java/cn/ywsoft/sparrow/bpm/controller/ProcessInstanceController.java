package cn.ywsoft.sparrow.bpm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.ywsoft.sparrow.bpm.model.KogitoFlow;
import cn.ywsoft.sparrow.bpm.repository.KogitoFlowRepository;
import net.minidev.json.JSONObject;

@RestController
public class ProcessInstanceController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	KogitoFlowRepository kogitoFlowRepository;

	@PostMapping("/startProcess/{processId}")
	public Object startProcess(@RequestBody final JSONObject body, @PathVariable(name = "processId") String processId) {
		KogitoFlow kogitoFlow = kogitoFlowRepository.findByProcessId(processId);
		String url = "http://" + kogitoFlow.getServiceName() + "/" + processId;
		return restTemplate.postForObject(url, body, Object.class);
	}
}
