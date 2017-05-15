package org.inscriptio.insc.parser;

import org.inscriptio.insc.block.Block;
import org.inscriptio.insc.tokeniser.Tokeniser;
import org.inscriptio.insc.block.Class;

/**
 * Created by noy on 15/05/2017.
 */

// Simplest parser
public class ClassParser extends Parser<Class> {

    @Override
    public boolean shouldParse(String line) {
        return line.matches("class [a-zA-z][a-zA-Z0-9]*"); // this represents the line of code that will be our class
    }

    @Override
    public Class parse(Block superBlock, Tokeniser tokeniser) {
        tokeniser.nextToken(); // Skip class

        String name = tokeniser.nextToken().getToken(); // Get's value of next token (name of class)
        return new Class(name);
    }
}
