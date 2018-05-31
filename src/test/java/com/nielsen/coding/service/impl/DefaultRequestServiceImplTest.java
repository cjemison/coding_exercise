package com.nielsen.coding.service.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import com.nielsen.coding.service.NodeService;
import com.nielsen.coding.service.RequestService;
import java.util.Set;
import org.junit.Test;

public class DefaultRequestServiceImplTest {

  private final String[] perms = {
      "1, 1, 1, 1,",
      "2, 1, 1,",
      "1, 2, 1",
      "1, 1, 2",
      "2, 2",
  };
  private NodeService nodeService = new DefaultNodeServiceImpl();
  private RequestService requestService = new DefaultRequestServiceImpl(nodeService);

  @Test
  public void happyPath() {
    final int numberOfSteps = 5;

    final Set<String> resultList = requestService.getPermutions(5);
    assertThat(resultList, is(notNullValue()));
    assertThat(resultList.size(), is(equalTo(5)));

    for (String value : perms) {
      assertThat(resultList.contains(value), is(equalTo(true)));
    }
  }
}