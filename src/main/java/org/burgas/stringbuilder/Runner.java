package org.burgas.stringbuilder;

import static java.lang.System.*;

public class Runner {

    public static void main(String[] args) {

        CustomStringBuilder newStringBuilder = new CustomStringBuilder();
        newStringBuilder.append("New CustomStringBuilder object");
        out.println(newStringBuilder);
        newStringBuilder.append(" + append");
        out.println(newStringBuilder);
        newStringBuilder.undo();
        out.println(newStringBuilder);
        out.println();

        CustomStringBuilder customStringBuilder = new CustomStringBuilder("Hello World");
        out.println(customStringBuilder);

        customStringBuilder
                .append(", how are you?\n")
                .append("I don't now, something wrong!");
        out.println(customStringBuilder);
        out.println();

        customStringBuilder.undo();
        customStringBuilder.undo();
        out.println(customStringBuilder);

        customStringBuilder.append(" something new")
                        .append(" and a bit more");
        out.println(customStringBuilder);
        customStringBuilder.undo();
        out.println(customStringBuilder);
        customStringBuilder.undo();
        out.println(customStringBuilder);
        customStringBuilder.undo();
    }
}
