package com.github.tonydeng.desgin.state.impl;

import com.github.tonydeng.desgin.state.State;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/9/27.
 */
@Slf4j
public class TVStopState implements State{
    @Override
    public void doAction() {
        log.info("TV is turned OFF");
    }
}
