package com.github.tonydeng.desgin.command.fs.command;

import com.github.tonydeng.desgin.command.fs.FileSystemReceiver;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/9/27.
 */
@Slf4j
public class OpenFileCommand implements Command {

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
