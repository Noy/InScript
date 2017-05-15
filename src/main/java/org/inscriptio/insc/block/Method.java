package org.inscriptio.insc.block;

import lombok.Getter;
import org.inscriptio.insc.Parameter;
import org.inscriptio.insc.Type;
import org.inscriptio.insc.Value;

/**
 * Created by noy on 15/05/2017.
 */
@Getter
public final class Method extends Block {

    private String name;
    private Type type;
    private Parameter[] params;
    private Value returnValue;

    public Method(Block superBlock, String name, Type type, Parameter[] params) {
        super(superBlock);
        this.name = name;
        this.type = type;
        this.params = params;
    }

    @Override
    public void run() {
        invoke();
    }

    public void invoke(Value... values) {
        // Invoke the method with the supplied values.
    }
}
