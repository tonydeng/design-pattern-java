package com.github.tonydeng.desgin.proxy.remote.client;

import com.github.tonydeng.desgin.proxy.remote.ReportGenerator;
import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by tonydeng on 15/10/5.
 */
@Slf4j
public class ReportGeneratorClient {

    public void generateReport() {
        try {
            ReportGenerator reportGenerator = (ReportGenerator) Naming.lookup("rmi://127.0.0.1:9999/PizzaCoRemoteGenerator");

            log.info("remote report:'{}'", reportGenerator.generateDailyReport());
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            log.error("{}", e);
        }
    }
}
