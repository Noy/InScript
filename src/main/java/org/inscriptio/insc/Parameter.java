package org.inscriptio.insc;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * Created by noy on 15/05/2017.
 */
@Value
@AllArgsConstructor
public class Parameter {
    private Type type;
    private String name;
}
