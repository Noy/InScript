package org.inscriptio.insc.parser;

import org.inscriptio.insc.BuiltInType;
import org.inscriptio.insc.Parameter;
import org.inscriptio.insc.BuiltInType;
import org.inscriptio.insc.block.Block;
import org.inscriptio.insc.block.Method;
import org.inscriptio.insc.tokeniser.Token;
import org.inscriptio.insc.tokeniser.Tokeniser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noy on 15/05/2017.
 */
public class MethodParser extends Parser<Method> {
    @Override
    public boolean shouldParse(String line) {
        // OUCH, lol
        return line.matches("method [a-zA-Z][a-zA-Z0-9]* requires \\(([a-zA-Z][a-zA-Z0-9]*)*\\) returns [a-zA-Z][a-zA-Z0-9]*");
    }

    @Override
    public Method parse(Block superBlock, Tokeniser tokeniser) {
        tokeniser.nextToken(); // again, skips method token

        String name = tokeniser.nextToken().getToken();

        tokeniser.nextToken(); // skip requires token

        tokeniser.nextToken(); // skip ( token

        Token first = tokeniser.nextToken();

        List<Parameter> params = new ArrayList<>();

        if (!first.getToken().equals(")")) { // params exists
            String[] paramData = new String[]{first.getToken(), null}; // 0 = type 1= value, loop through that (add them to params list)
            while (tokeniser.hasNextToken()) {
                Token token = tokeniser.nextToken();
                if (token.getToken().equals(")")) {
                    break;
                }

                if (paramData[0] == null) {
                    paramData[0] = token.getToken();
                }
                else {
                    paramData[1] = token.getToken();
                    params.add(new Parameter(BuiltInType.valueOf(paramData[0].toUpperCase()), paramData[1]));
                    paramData = new String[2];
                }
            }
        }

        tokeniser.nextToken(); // skips returns

        String returnBuiltInType = tokeniser.nextToken().getToken(); //  BuiltInType.valueOf(tokeniser.nextToken().getToken().toUpperCase());

        return new Method(superBlock, name, returnBuiltInType, params.toArray(new Parameter[params.size()]));

    }
}
