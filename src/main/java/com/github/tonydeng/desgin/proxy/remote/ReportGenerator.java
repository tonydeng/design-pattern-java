package com.github.tonydeng.desgin.proxy.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by tonydeng on 15/10/4.
 */
public interface ReportGenerator extends Remote {

    public String generateDailyReport() throws RemoteException;
}
