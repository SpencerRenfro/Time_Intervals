package com.example.week8project4;
/*
* The third class is the exception class InvalidTime that implements a checked exception. It
should have an instance variable of type String that saves the message and the following
method:
 A constructor that accepts the message as a string and constructs an InvalidTime object

* */
public class InvalidTime extends Throwable {
    String message;
    public InvalidTime(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
