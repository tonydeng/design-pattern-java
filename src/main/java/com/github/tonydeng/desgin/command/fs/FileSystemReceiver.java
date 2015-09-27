package com.github.tonydeng.desgin.command.fs;

/**
 * Created by tonydeng on 15/9/27.
 */
public interface FileSystemReceiver {
    public void openFile();

    public void writeFile();

    public void closeFile();
}
