package org.inscriptio.insc.tokeniser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by noy on 15/05/2017.
 */
public class Tokeniser {

    private List<TokenData> tokenDatas;
    private String str;


    private Token lastToken;
    private boolean pushBack;

    public Tokeniser(String str) {
        this.str = str;
        this.tokenDatas = new ArrayList<>();
        // Regex, needs to be one letter (lower or upper case) or a number. * means 0 or more
        tokenDatas.add(new TokenData(Pattern.compile("^([a-zA-Z][a-zA-Z0-9]*)"), TokenType.IDENTIFIER));
        // Regex, any number, positive or negative
        tokenDatas.add(new TokenData(Pattern.compile("^((-)?[0-9]+)"), TokenType.INTEGER_LITERAL));
        // Regex, anything inside two double quotes
        tokenDatas.add(new TokenData(Pattern.compile("^(\".*\")"), TokenType.STRING_LITERAL));

        // Adding all our tokens, escaping any special features (our backslashes)
        for (String t : new String[] {"=", "\\(", "\\)", "\\.", "\\,"}) {
            tokenDatas.add(new TokenData(Pattern.compile("^(" + t + ")"), TokenType.TOKEN));
        }
    }

    public Token nextToken() {
        // we don't care for extra spacing
        str = str.trim();
        if (pushBack) {
            pushBack = false;
            return lastToken;
        }

        if (str.isEmpty()) {
            return (lastToken = new Token("", TokenType.EMPTY));
        }

        for (TokenData data : tokenDatas) {
            Matcher matcher = data.getPattern().matcher(str);
            if (matcher.find()) {
                // will find all integers, follows the regex.
                String token = matcher.group().trim();
                // Remove the next token from the string, we don't want to get the same token twice
                str = matcher.replaceFirst("");

                if (data.getType() == TokenType.STRING_LITERAL) {
                    return (lastToken = new Token(token.substring(1, token.length()-1), TokenType.STRING_LITERAL));
                }
                else {
                    return (lastToken = new Token(token, data.getType()));
                }
            }
        }
        throw new TokenException("Could not find parse " + str);
    }

    public boolean hasNextToken() {
        return !str.isEmpty();
    }

    public void pushBack() {
        if (lastToken != null) {
            this.pushBack = true;
        }
    }

}
