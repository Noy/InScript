package org.inscriptio.insc.block;

/**
 * Created by noy on 15/05/2017.
 */

import lombok.Getter;
import org.inscriptio.insc.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 *  Represents a block of code
 *  @author Noy H.
 */
public abstract class Block {

    @Getter private Block superBlock;
    private List<Block> subBlocks;
    private List<Variable> variables;

    public Block(Block superBlock) {
        this.superBlock = superBlock;
        this.subBlocks = new ArrayList<>();
        this.variables = new ArrayList<>();
    }

    public void addBlock(Block block) {
        subBlocks.add(block);
    }

    public void addVariable(Variable v) {
        variables.add(v);
    }

    public Variable getVariable(String name) {
        for (Variable v : variables) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }

    public Block[] getSubBlocks() {
        return subBlocks.toArray(new Block[subBlocks.size()]);
    }

    // Run will run the block, e.g. if a class has a main method
    public abstract void run();

}
