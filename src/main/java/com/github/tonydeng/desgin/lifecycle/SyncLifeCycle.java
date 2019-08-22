package com.github.tonydeng.desgin.lifecycle;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class SyncLifeCycle extends AbstractLifeCycle {


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
