package org.burgas.stringbuilder;

import static java.lang.String.*;
import static java.lang.System.*;

public class CustomStringBuilder {

    private char[] chars;
    private final CustomStringBuilderHistory history = new CustomStringBuilderHistory();

    public CustomStringBuilder() {
        this.chars = new char[0];
    }

    public CustomStringBuilder(String string) {
        this.chars = string.toCharArray();
        this.history.add(new CustomStringBuilderSnapshot(this.chars));
    }

    public CustomStringBuilder append(String string) {
        if (string == null)
            throw new NullPointerException("Input string is empty");

        char[] inputChars = string.toCharArray();
        char[] temp = new char[this.chars.length + string.length()];

        arraycopy(this.chars, 0, temp, 0, this.chars.length);

        int tempI = 0;
        for (int i = this.chars.length; i < temp.length; i++)
            temp[i] = inputChars[tempI++];

        this.chars = temp;
        this.history.add(new CustomStringBuilderSnapshot(this.chars));
        return this;
    }

    public void undo() {
        if (this.history.getSnapshotHistory().size() == 1) {
            out.println("Only 1 element in StringBuilder history");
            return;
        }

        this.history.getSnapshotHistory().remove(this.history.getSnapshotHistory().size() - 1);
        CustomStringBuilderSnapshot snapshot = this.history.get(this.history.getSnapshotHistory().size() - 1);

        this.chars = snapshot.chars();
    }

    @Override
    public String toString() {
        return valueOf(this.chars);
    }
}
