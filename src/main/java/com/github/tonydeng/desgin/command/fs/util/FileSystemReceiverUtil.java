package com.github.tonydeng.desgin.command.fs.util;

import com.github.tonydeng.desgin.command.fs.FileSystemReceiver;
import com.github.tonydeng.desgin.command.fs.impl.UnixFileSystemReceiver;
import com.github.tonydeng.desgin.command.fs.impl.WindowsFileSystemReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/9/27.
 */
public class FileSystemReceiverUtil {
    private static final Logger log = LoggerFactory.getLogger(FileSystemReceiverUtil.class);

    public static FileSystemReceiver getUnderlyingFileSystem(){
        String osName = System.getProperty("os.name");
        if(log.isDebugEnabled())
            log.debug("Underlying OS is:{}",osName);
        if(osName.contains("Windows")){
            return new WindowsFileSystemReceiver();
        }else {
            return new UnixFileSystemReceiver();
        }
    }
}
