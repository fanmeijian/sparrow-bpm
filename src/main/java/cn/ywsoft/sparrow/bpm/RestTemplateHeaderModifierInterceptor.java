package cn.ywsoft.sparrow.bpm;

import java.io.IOException;
import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.util.UriComponentsBuilder;

import net.minidev.json.JSONArray;

public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Jwt jwt = (Jwt) authentication.getCredentials();
		String token =jwt.getTokenValue();
		request.getHeaders().add("Authorization", "Bearer " + token);
//		request.getHeaders().add("Content-Type", "application/json; charset=UTF-8");
		String url = UriComponentsBuilder.fromUri(request.getURI()).queryParam("user", jwt.getClaim("user_name").toString()).queryParam("group", ((JSONArray)jwt.getClaim("roles"))).build().toUri().toASCIIString();
//		String url = UriComponentsBuilder.fromUriString(request.getURI().getPath()).query(request.getURI().getQuery()).queryParam("user", jwt.getClaim("user_name").toString()).queryParam("group", ((JSONArray)jwt.getClaim("roles"))).build().toUri().toASCIIString();

		
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
//		URI uri = UriComponentsBuilder.fromUriString("http://SPARROW-TRIAL"+url).build().toUri();

		HttpRequest modifiedRequest = new HttpRequestWrapper(request) {

            @Override
            public URI getURI() {
                return uri;
            }
        };
        
		ClientHttpResponse response = execution.execute(modifiedRequest, body);
//		response.getHeaders().add("Content-Type", "application/json; charset=UTF-8");
        return response;
	}

}
