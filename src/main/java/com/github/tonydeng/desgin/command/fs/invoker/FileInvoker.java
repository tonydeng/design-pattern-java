package com.github.tonydeng.desgin.command.fs.invoker;

import com.github.tonydeng.desgin.command.fs.command.Command;

/**
 * Created by tonydeng on 15/9/27.
 */
public class FileInvoker {
    private Command command;

    public FileInvoker(Command c){
        this.command = c;
    }

    public void execute(){
        this.command.execute();
    }
}
