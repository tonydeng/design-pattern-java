package com.github.tonydeng.desgin.command.impl;

import com.github.tonydeng.desgin.command.Command;
import com.github.tonydeng.desgin.command.fs.FileSystemReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/9/27.
 */
public class WriteFileComand implements Command{
    private static final Logger log = LoggerFactory.getLogger(WriteFileComand.class);

    private FileSystemReceiver fileSystem;

    public WriteFileComand(FileSystemReceiver fs){
        this.fileSystem = fs;
    }

    @Override
    public void execute() {
        if(log.isDebugEnabled())
            log.debug("write file command......");
        fileSystem.writeFile();
    }
}
