package com.evolutionnext.cyberdojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DoorContainer {
    private final Logger logger = LoggerFactory.getLogger(DoorContainer.class);

    private List<Boolean> doors = null;

    public DoorContainer(int initialSize) {
        doors = new ArrayList<>(initialSize);
        for (int i = 0; i < initialSize; i++) {
            doors.add(false);
        }
    }

    private List<Integer> toggleDoors(Predicate<Integer> predicate) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < doors.size(); i++) {
            if (predicate.test(i)) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public List<Integer> getDoorsOpened() {
        return toggleDoors(i -> doors.get(i));
    }

    public List<Integer> getDoorsClosed() {
        return toggleDoors(i -> !doors.get(i));
    }

    public void applyPredicateToAll(Predicate<Integer> predicate) {
        for (int i = 0; i < doors.size(); i++) {
            if (predicate.test(i + 1)) {
                doors.set(i, !doors.get(i));
            }
        }
    }

    public void applyToAll() {
        for (int i = 0; i < doors.size(); i++) {
            final int x = i + 1;
            applyPredicateToAll(index -> index % x == 0);
            logger.debug("Iteration " + i + ":" + doors.toString());
        }
    }
}
