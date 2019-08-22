package com.github.tonydeng.desgin.command.fs.impl;

import com.github.tonydeng.desgin.command.fs.FileSystemReceiver;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by tonydeng on 15/9/27.
 */
@Slf4j
public class WindowsFileSystemReceiver implements FileSystemReceiver {

    @Override
    public void openFile() {
        log.info("Opening file in Windows OS");
    }

    @Override
    public void writeFile() {
        log.info("Writing file in Windows OS");
    }

    @Override
    public void closeFile() {
        log.info("Closing file in Windows OS");
    }
}
