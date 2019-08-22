package com.github.tonydeng.desgin.command.fs;

/**
 * Created by tonydeng on 15/9/27.
 */
public interface FileSystemReceiver {
    void openFile();

    void writeFile();

    void closeFile();
}
