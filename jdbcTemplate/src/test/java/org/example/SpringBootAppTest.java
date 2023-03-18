package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/** Unit test for simple App. */
@SpringBootTest
public class SpringBootAppTest {
  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    queryParams.add("pagination[start]","0");
    queryParams.add("pagination[limit]","10");
    Map<String, String> urlParams = new HashMap<>();
    urlParams.put("storeId","1000");
    String path = "api/v1/customers";


    System.out.println(getUri(queryParams,urlParams,path));
  }

  private URI getUri(
          MultiValueMap<String, String> queryParams,
          Map<String, String> urlParams,
          String... pathSegments)
          throws IllegalArgumentException {
    return UriComponentsBuilder.fromHttpUrl("http://localhost")
            .pathSegment(pathSegments)
            .queryParams(queryParams)
            .buildAndExpand(urlParams)
            .toUri();
  }
}
