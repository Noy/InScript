package org.inscriptio.insc.tokeniser;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.regex.Pattern;

/**
 * Created by noy on 15/05/2017.
 */
@AllArgsConstructor
@Value
public class TokenData {
    private Pattern pattern;
    private TokenType type;
}
