package com.bridgelabz.statecensus;

public class StateCensusException extends Exception {
    public String messege;

    public StateCensusException(String messege) {
        if(messege.contains("Invalid File Format")) {
            this.messege = ExceptionType.INVALID_FORMAT+ ":" + messege;
        }
    }

    @Override
    public String getMessage() {
        return messege;
    }
}
