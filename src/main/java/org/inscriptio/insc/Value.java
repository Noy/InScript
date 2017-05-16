package org.inscriptio.insc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents a value
 */
@Data
@AllArgsConstructor
public class Value {
    private Type builtInType;
    private Object value;
}