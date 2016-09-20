package com.budko.elibrary.exceptions;

import javax.security.auth.message.AuthException;

/**
 * @author DBudko.
 */
public class UserExistException extends AuthException {
    public UserExistException(){
        super("Email for user exists");
    }
    public UserExistException(final String email){
        super(String.format("Email '%s' already exists in DB.", email));
    }

}
