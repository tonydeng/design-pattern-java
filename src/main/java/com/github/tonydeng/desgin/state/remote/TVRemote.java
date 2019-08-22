package com.github.tonydeng.desgin.state.remote;

import com.github.tonydeng.desgin.state.State;
import com.github.tonydeng.desgin.state.context.TVContext;
import com.github.tonydeng.desgin.state.impl.TVStartState;
import com.github.tonydeng.desgin.state.impl.TVStopState;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/9/27.
 */
@Slf4j
public class TVRemote {
    private TVContext context = new TVContext();

    public void startTV() {
        log.debug("start tv......");
        actionTV(new TVStartState());
    }

    public void stopTV() {
        log.debug("stop tv......");
        actionTV(new TVStopState());
    }

    public void actionTV(State state) {
        log.debug("action state {} tv......", state.getClass().getName());
        context.setTvState(state);
        context.doAction();
    }

    public void allAction() {
        log.debug("all action tv......");
        actionTV(new TVStartState());
        actionTV(new TVStopState());
    }
}
