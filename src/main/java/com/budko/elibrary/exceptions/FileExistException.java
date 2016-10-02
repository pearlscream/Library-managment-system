package com.budko.elibrary.exceptions;

/**
 * @author DBudko.
 */
public class FileExistException extends Exception {
    public FileExistException(){
        super("File already exist");
    }
}
