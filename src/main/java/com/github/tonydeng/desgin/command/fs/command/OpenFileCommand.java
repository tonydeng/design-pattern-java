package com.github.tonydeng.desgin.command.fs.command;

import com.github.tonydeng.desgin.command.fs.FileSystemReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/9/27.
 */
public class OpenFileCommand implements Command {
    private static final Logger log = LoggerFactory.getLogger(OpenFileCommand.class);

    private FileSystemReceiver fileSystem;

    public OpenFileCommand(FileSystemReceiver fs) {
        this.fileSystem = fs;
    }

    @Override
    public void execute() {
        if(log.isDebugEnabled())
            log.debug("open file command.......");
        this.fileSystem.openFile();
    }
}
