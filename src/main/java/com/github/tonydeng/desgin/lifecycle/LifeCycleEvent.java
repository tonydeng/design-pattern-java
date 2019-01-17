package com.github.tonydeng.desgin.lifecycle;

import java.util.EventObject;

public class LifeCycleEvent extends EventObject {

  private static final long serialVersionUID = 1L;
  private AbstractLifeCycle lifeCycle;

  private LifeCycleState state;

  public LifeCycleEvent(Object source, AbstractLifeCycle lifeCycle, LifeCycleState state) {
    super(source);
    this.lifeCycle = lifeCycle;
    this.state = state;
  }

  public AbstractLifeCycle getLifeCycle() {
    return lifeCycle;
  }

  public void setLifeCycle(AbstractLifeCycle lifeCycle) {
    this.lifeCycle = lifeCycle;
  }

  public LifeCycleState getState() {
    return state;
  }

  public void setState(LifeCycleState state) {
    this.state = state;
  }
}
