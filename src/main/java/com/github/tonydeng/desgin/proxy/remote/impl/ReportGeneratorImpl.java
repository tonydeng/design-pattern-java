package com.github.tonydeng.desgin.proxy.remote.impl;

import com.github.tonydeng.desgin.proxy.remote.ReportGenerator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 * Created by tonydeng on 15/10/4.
 */
public class ReportGeneratorImpl extends UnicastRemoteObject implements ReportGenerator {

    private static final long serialVersionUID = 1l;

    public ReportGeneratorImpl(int port) throws RemoteException {
        super(port);
    }


    @Override
    public String generateDailyReport() throws RemoteException {
        StringBuilder sb = new StringBuilder();

        sb.append("********************Location X Daily Report********************");
        sb.append("\\n Location ID: 012");
        sb.append("\\n Today's Date: " + new Date());
        sb.append("\\n Total Pizza's Sell: 112");
        sb.append("\\n Total Price: $2534");
        sb.append("\\n Net Profit: $1985");
        sb.append("\\n ***************************************************************");
        return sb.toString();
    }
}
