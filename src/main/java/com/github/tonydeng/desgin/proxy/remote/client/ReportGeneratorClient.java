package com.github.tonydeng.desgin.proxy.remote.client;

import com.github.tonydeng.desgin.proxy.remote.ReportGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by tonydeng on 15/10/5.
 */
public class ReportGeneratorClient {
    private static final Logger log = LoggerFactory.getLogger(ReportGeneratorClient.class);

    public void generateReport() {
        try {
            ReportGenerator reportGenerator = (ReportGenerator) Naming.lookup("rmi://127.0.0.1:9999/PizzaCoRemoteGenerator");

            log.info("remote report:'{}'",reportGenerator.generateDailyReport());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
