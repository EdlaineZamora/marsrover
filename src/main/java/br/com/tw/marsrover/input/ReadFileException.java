package br.com.tw.marsrover.input;

public class ReadFileException extends Exception {

    public ReadFileException(String message, Exception exception) {
        super(message, exception);
    }

}
