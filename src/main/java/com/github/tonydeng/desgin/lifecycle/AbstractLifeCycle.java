package com.github.tonydeng.desgin.lifecycle;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractLifeCycle implements LifeCycle {

  private List<LifeCycleListener> lifeCycleListeners = new ArrayList<>();

  /**
   * 这里需要保证state的可见性, 防止多个线程并发时出问题
   */
  protected volatile LifeCycleState state = LifeCycleState.NULL;

  public AbstractLifeCycle() {
    addLifeCycleListener(new LifeCycleLogger());
  }

  @Override
  public void init() throws LifeCycleException {
    if (state.compare(LifeCycleState.NULL) != 0) {// 不是初始前状态
      return;
    }
    setState(LifeCycleState.INITIALIZING);
    try {
      initInternal();
    } catch (LifeCycleException e) {
      setState(LifeCycleState.FAILED);
      throw e;
    }
    setState(LifeCycleState.INITIALIZED);
  }

  private void setState(LifeCycleState state, boolean fireEvent) {
    this.state = state;
    if (fireEvent) {
      fireLifeCycleEvent(new LifeCycleEvent(this, this, state));
    }
  }

  private void setState(LifeCycleState state) {
    setState(state, true);
  }

  protected abstract void initInternal() throws LifeCycleException;

  @Override
  public void start() throws LifeCycleException {
    if (state.compare(LifeCycleState.INITIALIZED) != 0) { //不是已初始化
      init();
    }
    if (state.compare(LifeCycleState.INITIALIZED) != 0) {
      return;
    }
    setState(LifeCycleState.STARTING);
    try {
      startInternal();
    } catch (LifeCycleException e) {
      setState(LifeCycleState.FAILED);
      throw e;
    }
    setState(LifeCycleState.STARTED);
  }

  protected abstract void startInternal() throws LifeCycleException;

  @Override
  public void restart() throws LifeCycleException {
    if (state != LifeCycleState.STARTED) {
      throw new LifeCycleException("Illegal lifecycle state: " + state);
    }
    setState(LifeCycleState.RESTARTING);
    try {
      restartInternal();
    } catch (LifeCycleException e) {
      setState(LifeCycleState.FAILED);
    }
    setState(LifeCycleState.RESTARTED);
    setState(LifeCycleState.STARTED, false);
  }

  protected abstract void restartInternal() throws LifeCycleException;

  @Override
  public void destroy() throws LifeCycleException {
    if (state.compare(LifeCycleState.STARTED) != 0) { //不是已初始化
      return;
    }
    setState(LifeCycleState.DESTROYING);
    try {
      startInternal();
    } catch (LifeCycleException e) {
      setState(LifeCycleState.FAILED);
      throw e;
    }
    setState(LifeCycleState.DESTROYED);
  }

  protected abstract void destroyInternal() throws LifeCycleException;

  protected abstract String name();

  protected abstract String type();

  private void fireLifeCycleEvent(LifeCycleEvent e) {
    fireLifeCycleEvent(e, false);
  }

  private void fireLifeCycleEvent0(LifeCycleEvent e) {
    for (LifeCycleListener l : lifeCycleListeners) {
      l.lifeCycleEvent(e);
    }
  }

  protected void fireLifeCycleEvent(LifeCycleEvent e, boolean asyc) {
    if (!asyc) {
      fireLifeCycleEvent0(e);
    } else { // 异步通知
      new Thread(new Runnable() {
        @Override
        public void run() {
          fireLifeCycleEvent0(e);
        }
      }).start();
    }
  }

  public void addLifeCycleListener(LifeCycleListener l) {
    lifeCycleListeners.add(l);
  }

  public void removeLifeCycleListener(LifeCycleListener l) {
    lifeCycleListeners.remove(l);
  }

  // 日志打印, 可忽略
  public class LifeCycleLogger implements LifeCycleListener {

    private final Logger logger = LoggerFactory.getLogger(LifeCycleLogger.class);

    @Override
    public void lifeCycleEvent(LifeCycleEvent e) {
      switch (e.getState()) {
        case INITIALIZING:
          logger.info(type() + " " + name() + " initializing...");
          break;
        case INITIALIZED:
          logger.info(type() + " " + name() + " initialized...");
          break;
        case STARTING:
          logger.info(type() + " " + name() + " starting...");
          break;
        case STARTED:
          logger.info(type() + " " + name() + " started...");
          break;
        case RESTARTING:
          logger.info(type() + " " + name() + " restarting...");
          break;
        case RESTARTED:
          logger.info(type() + " " + name() + " restarted...");
          break;
        case DESTROYING:
          logger.info(type() + " " + name() + " destorying...");
          break;
        case DESTROYED:
          logger.info(type() + " " + name() + " destoryed...");
          break;
        case FAILED:
          logger.info(type() + " " + name() + " failed...");
          break;
        default:
          break;
      }
    }
  }
}
