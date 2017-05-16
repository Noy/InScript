package org.inscriptio.insc.block;

import lombok.Getter;
import org.inscriptio.insc.*;
import org.inscriptio.insc.BuiltInType;

/**
 * Created by noy on 15/05/2017.
 */
@Getter
public final class Method extends Block {

    private String name;
    private String type;
    private Parameter[] params;
    private Value returnValue;

    public Method(Block superBlock, String name, String type, Parameter[] params) {
        super(superBlock);
        this.name = name;
        this.type = type;
        this.params = params;
    }

    @Override
    public void run() {
        invoke();
    }

    public Value invoke(Value... values) {
        Type t = Type.match(type);
        // Invoke the method with the supplied values.
        if (values.length != params.length) throw new IllegalArgumentException("Wrong argument!");

        for (int i = 0; i < values.length && i < params.length; i ++) {
            Parameter p = params[i];
            Value v = values[i];

            if (p.getType() != v.getBuiltInType()) throw new IllegalStateException("Parameter " + p.getName() + " should be " + p.getType() + ". Got " + v.getBuiltInType());

            addVariable(new Variable(this, p.getType(), p.getName(), v.getValue()));
        }

        for (Block b : getSubBlocks()) {
            b.run();
            if (returnValue != null) break;
        }

        if (returnValue == null && t != BuiltInType.VOID) throw new IllegalStateException("Expected return value, got nothing.");
        Value localReturnValue = returnValue;
        returnValue = null;
        return localReturnValue;
    }
}
