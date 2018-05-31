package com.nielsen.coding.service.impl;

import com.nielsen.coding.domain.StepDO;
import com.nielsen.coding.service.NodeService;
import org.springframework.stereotype.Service;

@Service
public class DefaultNodeServiceImpl implements NodeService {

  @Override
  public StepDO createSteps(final Integer count) {
    if (count == null || count < 0) {
      throw new IllegalArgumentException("count is null");
    }

    final StepDO root = new StepDO(-1);
    StepDO previous;
    for (int i = 0; i < count; i++) {

    }
    return root;
  }
}
