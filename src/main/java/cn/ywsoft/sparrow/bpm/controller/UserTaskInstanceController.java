package cn.ywsoft.sparrow.bpm.controller;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import cn.ywsoft.sparrow.bpm.repository.UserTaskInstanceRepository;
import net.minidev.json.JSONArray;

@RestController
public class UserTaskInstanceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UserTaskInstanceRepository userTaskInstanceRepository;
	
	@PostMapping("/userTask")
	public Object userTask(@RequestParam(name = "endPoint") String endPoint, @RequestParam(name = "phase") String phase,@RequestBody final Object body) {
		String url = null;
		try {
			url = URLDecoder.decode(endPoint,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		URI uri = UriComponentsBuilder.fromUriString(url).queryParam("phase", phase).build().toUri();
		return restTemplate.postForObject(uri , body, Object.class);
	}
	
	@GetMapping("/userTask")
	public Object userTask(@PageableDefault(value = 10, sort = { "started" }, direction = Direction.DESC) Pageable p) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Jwt jwt = (Jwt) authentication.getCredentials();

		JSONArray ja = (JSONArray)jwt.getClaim("roles");
		
		String[] groups = new String[ ja.size()];
		ja.forEach(o->{
			groups[ja.indexOf(o)] = o.toString();
		});
		
		String[] user = new String[1];
		user[0] = jwt.getClaim("user_name").toString();
		
		return userTaskInstanceRepository.findByPotentialGroupsInOrPotentialUsersIn(groups, user, p);
		
	}
}
