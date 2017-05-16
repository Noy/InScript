package org.inscriptio.insc.block;

/**
 * Created by noy on 15/05/2017.
 */

import lombok.Getter;
import org.inscriptio.insc.Type;

/**
 * Represents a class instance!
 */
public final class Class extends Block implements Type {

    @Getter private String name;

    public Class(String name) {
        super(null); // There will never be anything above a class (no need for classes inside of classes)
        this.name = name;
    }

    @Override
    public void run() {
        // Find main method, if exists, run it
    }
}
