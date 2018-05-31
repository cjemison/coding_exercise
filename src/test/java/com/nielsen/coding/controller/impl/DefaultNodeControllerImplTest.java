package com.nielsen.coding.controller.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import com.nielsen.coding.config.WebConfig;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = WebConfig.class)
public class DefaultNodeControllerImplTest {

  private HashSet<String> hashSet;

  @Autowired
  private TestRestTemplate testRestTemplate;


  @Before
  public void setUp() throws Exception {
    hashSet = new HashSet<>(Arrays.asList("1, 1, 1, 1,",
        "2, 1, 1,",
        "1, 2, 1",
        "1, 1, 2",
        "2, 2"));
  }

  @Test
  public void handle() {
    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

    final HttpEntity<Void> httpEntity = new HttpEntity<>(null, httpHeaders);

    final Integer nSize = 4;
    final ResponseEntity<List<String>> responseEntity = testRestTemplate
        .exchange("/v1/perm/{numberOfSteps}",
            HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<String>>() {
            }, nSize);

    assertThat(responseEntity, is(notNullValue()));
    assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
    assertThat(responseEntity.getBody(), is(notNullValue()));

    final Set<String> set = new HashSet<>(responseEntity.getBody());

    assertThat(set.isEmpty(), is(equalTo(false)));
    assertThat(set.size(), is(equalTo(5)));

    final Iterator<String> iterator = hashSet.iterator();
    while(iterator.hasNext()){
      assertThat(set.contains(iterator.next()), is(equalTo(true)));
    }
  }
}