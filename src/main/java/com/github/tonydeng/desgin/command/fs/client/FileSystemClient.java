package com.github.tonydeng.desgin.command.fs.client;

import com.github.tonydeng.desgin.command.fs.FileSystemReceiver;
import com.github.tonydeng.desgin.command.fs.command.CloseFileCommand;
import com.github.tonydeng.desgin.command.fs.command.OpenFileCommand;
import com.github.tonydeng.desgin.command.fs.command.WriteFileCommand;
import com.github.tonydeng.desgin.command.fs.invoker.FileInvoker;
import com.github.tonydeng.desgin.command.fs.util.FileSystemReceiverUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/9/27.
 */
@Slf4j
public class FileSystemClient {
    private FileSystemReceiver fs;
    private OpenFileCommand openFileCommand;
    private WriteFileCommand writeFileCommand;
    private CloseFileCommand closeFileCommand;
    private FileInvoker fileInvoker;

    public FileSystemClient() {
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
