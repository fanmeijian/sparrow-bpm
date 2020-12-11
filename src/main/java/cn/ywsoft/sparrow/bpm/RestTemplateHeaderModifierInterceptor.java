package cn.ywsoft.sparrow.bpm;

import java.io.IOException;
import java.net.URI;
import java.util.Set;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.util.UriComponentsBuilder;

import net.minidev.json.JSONArray;

import org.springframework.http.client.support.HttpRequestWrapper;

public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Jwt jwt = (Jwt) authentication.getCredentials();
		String token =jwt.getTokenValue();
		request.getHeaders().add("Authorization", "Bearer " + token);
		String url = UriComponentsBuilder.fromUri(request.getURI()).queryParam("user", jwt.getClaim("user_name").toString()).queryParam("group", ((JSONArray)jwt.getClaim("roles"))).build().toUri().toASCIIString();
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		HttpRequest modifiedRequest = new HttpRequestWrapper(request) {

            @Override
            public URI getURI() {
                return uri;
            }
        };
		ClientHttpResponse response = execution.execute(modifiedRequest, body);
        return response;
	}

}
