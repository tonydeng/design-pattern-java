package com.github.tonydeng.desgin.lifecycle;

public enum LifeCycleState {
  NULL(0),//初始前

  INITIALIZING(1),

  INITIALIZED(2),

  STARTING(3),

  STARTED(4),

  RESTARTING(5),

  RESTARTED(6),

  DESTROYING(7),

  DESTROYED(8),

  FAILED(9);

  private int age;

  private LifeCycleState(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public int compare(LifeCycleState s) {
    return age > s.getAge() ? 1 : (age == s.getAge() ? 0 : -1);
  }
}
