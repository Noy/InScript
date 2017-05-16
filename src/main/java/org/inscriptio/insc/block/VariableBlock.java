package org.inscriptio.insc.block;

import org.inscriptio.insc.BuiltInType;
import org.inscriptio.insc.Type;
import org.inscriptio.insc.Variable;

/**
 * Created by noy on 16/05/2017.
 */
public class VariableBlock extends Block {

    private String type, name;
    private Object value;

    public VariableBlock(Block superBlock, String type, String name, Object value) {
        super(superBlock);
        this.type = type;
        this.name = name;
        this.value = value;
    }

    @Override
    public void run() {
        Type t = Type.match(type); //TTT
        if (t == BuiltInType.VOID) throw new IllegalStateException("Cannot declare variables of type void.");

        getSuperBlock().addVariable(new Variable(getSuperBlock(), t, name, value));
    }
}
