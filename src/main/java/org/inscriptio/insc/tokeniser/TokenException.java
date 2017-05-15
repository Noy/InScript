package org.inscriptio.insc.tokeniser;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by noy on 15/05/2017.
 */
@EqualsAndHashCode(callSuper = true)
@Data
final class TokenException extends IllegalStateException {
    private final String message;
}
