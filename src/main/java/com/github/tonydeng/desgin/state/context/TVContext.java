package com.github.tonydeng.desgin.state.context;

import com.github.tonydeng.desgin.state.State;

/**
 * Created by tonydeng on 15/9/27.
 */
public class TVContext implements State {

    private State tvState;

    public State getTvState() {
        return tvState;
    }

    public void setTvState(State tvState) {
        this.tvState = tvState;
    }

    @Override
    public void doAction() {
        this.tvState.doAction();
    }
}
