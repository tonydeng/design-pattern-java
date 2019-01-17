package com.github.tonydeng.desgin.lifecycle;

public interface LifeCycle {

  void init() throws LifeCycleException;

  void start() throws LifeCycleException;

  void restart() throws LifeCycleException;

  void destroy() throws LifeCycleException;
}
