package org.inscriptio.insc;

import lombok.Getter;
import org.inscriptio.insc.block.Block;

/**
 * Created by noy on 16/05/2017.
 */
public class Variable extends Value {

    @Getter private Block block;
    @Getter private String name;

    public Variable(Block block, Type builtInType, String name, Object value) {
        super(builtInType, value);
        this.block = block;
        this.name = name;
    }
}
