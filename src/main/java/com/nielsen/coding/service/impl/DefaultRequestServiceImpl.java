package com.nielsen.coding.service.impl;

import com.nielsen.coding.service.NodeService;
import com.nielsen.coding.service.RequestService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultRequestServiceImpl implements RequestService {

  private final NodeService nodeService;

  @Autowired
  public DefaultRequestServiceImpl(final NodeService nodeService) {
    this.nodeService = nodeService;
  }

  @Override
  public Set<String> getPermutions(final Integer numberOfNodes) {
    final Set<String> set = new HashSet<>();
    return set;
  }
}
