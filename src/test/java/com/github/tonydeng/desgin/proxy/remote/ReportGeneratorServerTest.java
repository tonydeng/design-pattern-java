package com.github.tonydeng.desgin.proxy.remote;

import com.github.tonydeng.desgin.BaseTest;
import com.github.tonydeng.desgin.proxy.remote.impl.ReportGeneratorImpl;
import org.junit.Test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Created by tonydeng on 15/10/5.
 */
public class ReportGeneratorServerTest extends BaseTest {

    @Test
    public void testRemoteServer() {
        try {
            ReportGenerator reportGenerator = new ReportGeneratorImpl(9999);
            log.info("start report rmi server...");
            Naming.rebind("PizzaCoRemoteGenerator", reportGenerator);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
