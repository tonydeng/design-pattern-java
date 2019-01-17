package com.github.tonydeng.desgin.lifecycle;

import java.util.EventListener;

public interface LifeCycleListener extends EventListener {

  void lifeCycleEvent(LifeCycleEvent event);
}
