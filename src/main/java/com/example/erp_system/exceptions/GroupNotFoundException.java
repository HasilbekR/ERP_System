package com.example.erp_system.exceptions;

import java.io.Serial;

public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(String message){
        super(message);
    }

}
