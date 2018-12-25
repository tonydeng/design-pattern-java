package com.github.tonydeng.desgin.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncLifeCycle extends AbstractLifeCycle {

  private static final Logger log = LoggerFactory.getLogger(SyncLifeCycle.class);

  @Override
  protected void initInternal() throws LifeCycleException {
    log.info("init internal");
  }

  @Override
  protected void startInternal() throws LifeCycleException {

  }

  @Override
  protected void restartInternal() throws LifeCycleException {

  }

  @Override
  protected void destroyInternal() throws LifeCycleException {

  }

  @Override
  protected String name() {
    return "Tony";
  }

  @Override
  protected String type() {
    return "Human";
  }
}
