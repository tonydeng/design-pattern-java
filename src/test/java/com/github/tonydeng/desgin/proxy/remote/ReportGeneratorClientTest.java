package com.github.tonydeng.desgin.proxy.remote;

import com.github.tonydeng.desgin.BaseTest;
import com.github.tonydeng.desgin.proxy.remote.client.ReportGeneratorClient;
import org.junit.Test;

/**
 * Created by tonydeng on 15/10/5.
 */
public class ReportGeneratorClientTest extends BaseTest {
    @Test
    public void testRemoteProxy() {
        ReportGeneratorClient client = new ReportGeneratorClient();

        client.generateReport();
    }
}
