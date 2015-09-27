package com.github.tonydeng.desgin.state;

import com.github.tonydeng.desgin.BaseTest;
import com.github.tonydeng.desgin.state.remote.TVRemote;
import org.junit.Test;

/**
 * Created by tonydeng on 15/9/27.
 */
public class TVRemoteTest extends BaseTest {

    @Test
    public void testStartTV(){
        TVRemote remote = new TVRemote();
        remote.startTV();
    }

    @Test
    public void testStopTV(){
        TVRemote remote = new TVRemote();
        remote.stopTV();
    }

    @Test
    public void testAllAction(){
        TVRemote remote = new TVRemote();
        remote.allAction();
    }
}
