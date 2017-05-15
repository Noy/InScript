package org.inscriptio.insc.parser;

import org.inscriptio.insc.Block;
import org.inscriptio.insc.tokeniser.Tokeniser;

/**
 * Created by noy on 15/05/2017.
 */
public abstract class Parser<T extends Block> {


    /**
     *  Takes a line and checks to see if it is for this parse by using regex
     */
    public abstract boolean shouldParse(String line);

    /**
     * Parses the given line of code. (Take the superblock and tokeniser for the line and return a blok of this parser's type)
     */
    public abstract T parse(Block superBlock, Tokeniser tokeniser);



}
