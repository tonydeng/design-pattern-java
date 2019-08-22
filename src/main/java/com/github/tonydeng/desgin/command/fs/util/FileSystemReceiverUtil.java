package com.github.tonydeng.desgin.command.fs.util;

import com.github.tonydeng.desgin.command.fs.FileSystemReceiver;
import com.github.tonydeng.desgin.command.fs.impl.UnixFileSystemReceiver;
import com.github.tonydeng.desgin.command.fs.impl.WindowsFileSystemReceiver;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by tonydeng on 15/9/27.
 */
@Slf4j
public class FileSystemReceiverUtil {

    private FileSystemReceiverUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static FileSystemReceiver getUnderlyingFileSystem() {
        String osName = System.getProperty("os.name");
        if (log.isDebugEnabled()) {
            log.debug("Underlying OS is:{}", osName);
        }
        if (osName.contains("Windows")) {
            return new WindowsFileSystemReceiver();
        } else {
            return new UnixFileSystemReceiver();
        }
    }
}
