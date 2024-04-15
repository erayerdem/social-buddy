package com.buddy.socialbuddy.config;

import com.buddy.socialbuddy.client.BubiletClient;
import com.buddy.socialbuddy.client.LoggingRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ApiConfig {

  @Bean
  public BubiletClient bubiletClient(@Value("${apis.bubilet}") String buBiletBaseUrl, LoggingRequestInterceptor loggingRequestInterceptor) {

    RestClient restClient =
        RestClient.builder()
            .defaultHeader("Accept", "application/json")
            .defaultHeader("Content-Type", "application/json")
            .defaultHeader("Authorization", "")
            .defaultHeader(
                "User-Agent",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
            .defaultHeader(
                "sec-ch-ua",
                "\"Google Chrome\";v=\"123\", \"Not:A-Brand\";v=\"8\", \"Chromium\";v=\"123\"")
            .defaultHeader("sec-ch-ua-mobile", "?0")
            .baseUrl(buBiletBaseUrl)
            .requestInterceptor(loggingRequestInterceptor)
            .build();

    RestClientAdapter adapter = RestClientAdapter.create(restClient);
    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
    return factory.createClient(BubiletClient.class);
  }
}
