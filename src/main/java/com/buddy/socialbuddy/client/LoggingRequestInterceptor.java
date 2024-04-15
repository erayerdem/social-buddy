package com.buddy.socialbuddy.client;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

@Service
@Slf4j
public class LoggingRequestInterceptor implements ClientHttpRequestInterceptor {

  @Override
  public ClientHttpResponse intercept(
      HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
    logRequest(request, body);
    ClientHttpResponse response = execution.execute(request, body);
    logResponse(response);
    return response;
  }

  private void logRequest(HttpRequest request, byte[] body) {

    if (log.isInfoEnabled()) {
      log.info(
          "URI: {}, Method: {}, Headers: {}, Request body: {}",
          request.getURI(),
          request.getMethod(),
          request.getHeaders(),
          new String(body, StandardCharsets.UTF_8));
    }
  }

  private void logResponse(ClientHttpResponse response) throws IOException {

    boolean isError = response.getStatusCode().isError();

    log.makeLoggingEventBuilder(isError ? Level.ERROR : Level.INFO)
        .log(
            "Response status code: {}, Response headers: {}, Response body: {}",
            response.getStatusCode(),
            response.getHeaders(),
            isError ? StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()) : "");
  }
}
