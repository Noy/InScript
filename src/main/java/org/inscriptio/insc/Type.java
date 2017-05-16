package org.inscriptio.insc;

/**
 * Created by noy on 16/05/2017.
 */
public interface Type {

    static Type match(String str) {
        try {
            return BuiltInType.valueOf(str.toUpperCase());
        } catch (Exception e) {
            //TODO: match str to a call
            return null;
        }
    }

}
