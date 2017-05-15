package org.inscriptio.insc.tokeniser;

/**
 * Created by noy on 15/05/2017.
 */
public class TokeniserTest {

    public static void main(String[] args) {
        String code = "class HelloWorld\n" +
                "    method main requires ()\n" +
                "        print \"Hello World\"";

        Tokeniser tokeniser = new Tokeniser(code);

        while (tokeniser.hasNextToken()) {
            System.out.println(tokeniser.nextToken().getToken());
        } }

}
