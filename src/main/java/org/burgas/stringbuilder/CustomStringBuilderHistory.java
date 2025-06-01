package org.burgas.stringbuilder;

import java.util.ArrayList;
import java.util.List;

public final class CustomStringBuilderHistory {

    private final List<CustomStringBuilderSnapshot> snapshotHistory = new ArrayList<>();

    public void add(CustomStringBuilderSnapshot customStringBuilderSnapshot) {
        this.snapshotHistory.add(customStringBuilderSnapshot);
    }

    public CustomStringBuilderSnapshot get(int index) {
        return this.snapshotHistory.get(index);
    }

    public List<CustomStringBuilderSnapshot> getSnapshotHistory() {
        return snapshotHistory;
    }
}
