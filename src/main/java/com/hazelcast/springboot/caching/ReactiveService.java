package com.hazelcast.springboot.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ReactiveService {
    private static final Logger logger = LoggerFactory.getLogger(ReactiveService.class);
    private static final String URL = "http://localhost:8080/topic";
    public Mono<ResponseEntity<String>> get(ServerHttpRequest request){
        return handleRequestHeadersUriSpec(request, HttpMethod.GET);
    }

    private Mono<ResponseEntity<String>> handleRequestHeadersUriSpec(ServerHttpRequest request, HttpMethod method){
//        WebClient.RequestHeadersSpec<?> spec;
        WebClient webClient = buildClient(URL);
//        spec = webClient.get();
        return webClient.get().retrieve().toEntity(String.class);
    }

    private WebClient buildClient(String url){
        WebClient.Builder builder = WebClient.builder().baseUrl(url);
        return builder.build();
    }
}
