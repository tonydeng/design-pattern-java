package com.github.tonydeng.desgin.command;

import com.github.tonydeng.desgin.BaseTest;
import com.github.tonydeng.desgin.command.fs.FileSystemReceiver;
import com.github.tonydeng.desgin.command.fs.util.FileSystemReceiverUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Created by tonydeng on 15/9/27.
 */
@Slf4j
public class FileSystemReceiverUtilTest extends BaseTest {

    @Test
    public void testGetUnderlyingFileSystem() {
        FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();
        if (fs != null) {
            log.info(fs.getClass().getSimpleName());
        }
    }
}
