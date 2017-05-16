package org.inscriptio.insc;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.inscriptio.insc.block.Block;
import org.inscriptio.insc.parser.ClassParser;
import org.inscriptio.insc.parser.MethodParser;
import org.inscriptio.insc.parser.Parser;
import org.inscriptio.insc.parser.VariableParser;
import org.inscriptio.insc.tokeniser.Tokeniser;
import org.inscriptio.insc.block.Class;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noy on 16/05/2017.
 */
public class Runtime {

    private List<Class> classList;

    public Runtime() {
        classList = new ArrayList<>();
        String code = "class HelloWorld\n" +
                "    method main requires () returns void";
        Parser<?>[] parsers = new Parser<?>[] {new ClassParser(), new MethodParser(), new VariableParser()};

        Class main;

        Block block = null;

        boolean success = false;

        for (String line : code.split("\n")) {
            success = false;
            line = line.trim();
            Tokeniser tokeniser = new Tokeniser(line);

            for (Parser parser : parsers) {
                if (parser.shouldParse(line)) {
                    block = parser.parse(block, tokeniser);
                    if (block instanceof Class) {
                        classList.add((Class) block);
                    }
                    success = true;
                    break;
                }
            }
            if (!success) {
                throw new IllegalArgumentException("Invalid line!\n" + line);
            }
        }

    }

    public static void main(String[] args) {
        new Runtime();
    }

}
