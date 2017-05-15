package org.inscriptio.insc.block;

/**
 * Created by noy on 15/05/2017.
 */

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 *  Represents a block of code
 *  @author Noy H.
 */
public abstract class Block {

    @Getter private Block superBlock;
    private List<Block> subBlocks;

    public Block(Block superBlock) {
        this.superBlock = superBlock;
        this.subBlocks = new ArrayList<>();
    }

    public void addBlock(Block block) {
        subBlocks.add(block);
    }

    // Run will run the block, e.g. if a class has a main method
    public abstract void run();

}
