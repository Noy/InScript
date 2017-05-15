package org.inscriptio.insc.tokeniser;

import lombok.Value;

/**
 * Created by noy on 15/05/2017.
 */
@Value
public final class Token {
    private String token;
    private TokenType type;
}
