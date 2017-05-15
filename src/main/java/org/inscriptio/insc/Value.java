package org.inscriptio.insc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents a value
 */
@Data
@AllArgsConstructor
public class Value {
    private Type type;
    private Object value;
}