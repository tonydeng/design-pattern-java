package com.github.tonydeng.desgin.lifecycle;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncLifeCycleTest {

  private static final Logger log = LoggerFactory.getLogger(SyncLifeCycleTest.class);
  private static SyncLifeCycle syncLifeCycle = new SyncLifeCycle();

  @Test
  public void testStart() throws LifeCycleException {

    log.info("{}", syncLifeCycle.state.getAge());
    syncLifeCycle.startInternal();
  }
}