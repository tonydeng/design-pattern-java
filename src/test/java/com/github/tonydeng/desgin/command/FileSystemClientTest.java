package com.github.tonydeng.desgin.command;

import com.github.tonydeng.desgin.BaseTest;
import com.github.tonydeng.desgin.command.fs.client.FileSystemClient;
import org.junit.Test;

/**
 * Created by tonydeng on 15/9/27.
 */
public class FileSystemClientTest extends BaseTest {

    private FileSystemClient client = new FileSystemClient();

    @Test
    public void testOpen(){
        client.open();
    }

    @Test
    public void testWrite(){
        client.write();
    }

    @Test
    public void testClose(){
        client.close();
    }
}
