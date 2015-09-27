package com.github.tonydeng.desgin.state.impl;

import com.github.tonydeng.desgin.state.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/9/27.
 */
public class TVStartState implements State{
    private  static final Logger log = LoggerFactory.getLogger(TVStartState.class);

    @Override
    public void doAction() {
        log.info("TV is turned ON");
    }
}
