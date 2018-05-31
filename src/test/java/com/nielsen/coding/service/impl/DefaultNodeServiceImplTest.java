package com.nielsen.coding.service.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import com.nielsen.coding.domain.StepDO;
import com.nielsen.coding.service.NodeService;
import org.junit.Before;
import org.junit.Test;

public class DefaultNodeServiceImplTest {

  private NodeService nodeService;

  @Before
  public void setUp() throws Exception {
    nodeService = new DefaultNodeServiceImpl();
  }

  @Test
  public void createSteps() {
    final int size = 6;
    final StepDO root = nodeService.createSteps(size);

    assertThat(root, is(notNullValue()));
    assertThat(root.getStepName(), is(equalTo(-1)));
    assertThat(root.getNext(), is(notNullValue()));

    StepDO step = root.getNext();
    for (int i = 0; i <= size; i++) {
      assertThat(step, is(notNullValue()));
      assertThat(step.getStepName(), is(equalTo(i)));
      if ((size - 1) == i) {
        assertThat(root.getNext(), is(notNullValue()));
      }
    }
  }
}