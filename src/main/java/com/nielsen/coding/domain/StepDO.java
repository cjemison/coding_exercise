package com.nielsen.coding.domain;

import java.util.Objects;

public class StepDO {

  private final Integer stepName;
  private StepDO next;

  public StepDO(final Integer stepName) {
    this.stepName = stepName;
  }

  public Integer getStepName() {
    return stepName;
  }

  public StepDO getNext() {
    return next;
  }

  public void setNext(final StepDO next) {
    this.next = next;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof StepDO)) {
      return false;
    }
    final StepDO stepDO = (StepDO) o;
    return Objects.equals(getStepName(), stepDO.getStepName()) &&
        Objects.equals(getNext(), stepDO.getNext());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getStepName(), getNext());
  }

  @Override
  public String toString() {
    return "StepDO{" +
        "stepName=" + stepName +
        ", next=" + next +
        '}';
  }
}
