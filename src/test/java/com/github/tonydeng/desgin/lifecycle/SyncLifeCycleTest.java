package com.github.tonydeng.desgin.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class SyncLifeCycleTest {

  private static SyncLifeCycle syncLifeCycle = new SyncLifeCycle();

  @Test
  public void testStart() throws LifeCycleException {

    log.info("{}", syncLifeCycle.state.getAge());
    syncLifeCycle.startInternal();
  }
}