package org.inscriptio.insc.parser;

import org.inscriptio.insc.block.Block;
import org.inscriptio.insc.block.VariableBlock;
import org.inscriptio.insc.tokeniser.Token;
import org.inscriptio.insc.tokeniser.TokenType;
import org.inscriptio.insc.tokeniser.Tokeniser;

/**
 * Created by noy on 16/05/2017.
 */
public class VariableParser extends Parser<Block> {

    @Override
    public boolean shouldParse(String line) {
        return line.matches("var [a-zA-z]+ [a-zA-Z]+ = \"?[a-zA-Z0-9]\"?");
    }

    @Override
    public Block parse(Block superBlock, Tokeniser tokeniser) {

        tokeniser.nextToken(); // Skips the var keyword

        String builtInType = tokeniser.nextToken().getToken();

        //if (builtInType == BuiltInType.VOID) throw new IllegalStateException("Cannot declare variables of type void.");

        String name = tokeniser.nextToken().getToken();

        tokeniser.nextToken(); // skip = (could make initialising optional)

        Token v = tokeniser.nextToken();

        Object value;
        if (v.getType() == TokenType.INTEGER_LITERAL) {
            value = Integer.valueOf(v.getToken());
        } else if (v.getType() == TokenType.STRING_LITERAL) {
            value = v.getToken();
        } else {
            // identifier
            value = superBlock.getVariable(v.getToken()).getValue();
        }
        // Add this variable to block
        //superBlock.addVariable(new Variable(superBlock, builtInType, name, value));
        return new VariableBlock(superBlock, builtInType, name, value);
    }
}
