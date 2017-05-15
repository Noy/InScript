package org.inscriptio.insc.tokeniser;

/**
 * Created by noy on 15/05/2017.
 */
public enum TokenType {

    /** Represent a token. e.g. ( ) = , etc.. */
    TOKEN,

    /**  - First char is a letter, any proceeding chars are letters or numbers. */
    IDENTIFIER,

    /** Anything enclosed in double quotes. e.g. "hello" */
    STRING_LITERAL,

    /** A Number */
    INTEGER_LITERAL

}
