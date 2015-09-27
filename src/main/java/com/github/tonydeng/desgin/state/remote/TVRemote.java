package com.github.tonydeng.desgin.state.remote;

import com.github.tonydeng.desgin.state.State;
import com.github.tonydeng.desgin.state.context.TVContext;
import com.github.tonydeng.desgin.state.impl.TVStartState;
import com.github.tonydeng.desgin.state.impl.TVStopState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/9/27.
 */
public class TVRemote {
    private static final Logger log = LoggerFactory.getLogger(TVRemote.class);
    private TVContext context = new TVContext();

    public void startTV() {
        if(log.isDebugEnabled())
            log.debug("start tv......");
        actionTV(new TVStartState());
    }

    public void stopTV() {
        if(log.isDebugEnabled())
            log.debug("stop tv......");
        actionTV(new TVStopState());
    }

    public void actionTV(State state) {
        if(log.isDebugEnabled())
            log.debug("action state {} tv......",state.getClass().getName());
        context.setTvState(state);
        context.doAction();
    }

    public void allAction() {
        if(log.isDebugEnabled())
            log.debug("all action tv......");
        actionTV(new TVStartState());
        actionTV(new TVStopState());
    }
}
