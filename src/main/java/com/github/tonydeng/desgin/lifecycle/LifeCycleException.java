package com.github.tonydeng.desgin.lifecycle;

public class LifeCycleException extends Exception {

  private final String message;

  public LifeCycleException(String message) {
    this.message = message;
  }
}
