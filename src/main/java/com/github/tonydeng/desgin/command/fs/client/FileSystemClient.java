package com.github.tonydeng.desgin.command.fs.client;

import com.github.tonydeng.desgin.command.fs.FileSystemReceiver;
import com.github.tonydeng.desgin.command.fs.invoker.FileInvoker;
import com.github.tonydeng.desgin.command.fs.util.FileSystemReceiverUtil;
import com.github.tonydeng.desgin.command.fs.command.CloseFileCommand;
import com.github.tonydeng.desgin.command.fs.command.OpenFileCommand;
import com.github.tonydeng.desgin.command.fs.command.WriteFileCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/9/27.
 */
public class FileSystemClient {
    private static final Logger log = LoggerFactory.getLogger(FileSystemClient.class);
    private FileSystemReceiver fs;
    private OpenFileCommand openFileCommand;
    private WriteFileCommand writeFileCommand;
    private CloseFileCommand closeFileCommand;
    private FileInvoker fileInvoker;

    public FileSystemClient() {
        if(log.isDebugEnabled())
            log.debug("file system client init......");

        fs = FileSystemReceiverUtil.getUnderlyingFileSystem();
        openFileCommand = new OpenFileCommand(fs);
        writeFileCommand = new WriteFileCommand(fs);
        closeFileCommand = new CloseFileCommand(fs);
    }

    public void open() {
        fileInvoker = new FileInvoker(openFileCommand);
        fileInvoker.execute();
    }

    public void write() {
        fileInvoker = new FileInvoker(writeFileCommand);
        fileInvoker.execute();
    }

    public void close() {
        fileInvoker = new FileInvoker(closeFileCommand);
        fileInvoker.execute();
    }
}
