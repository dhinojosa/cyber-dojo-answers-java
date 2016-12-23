package com.evolutionnext.cyberdojo;

import org.assertj.core.util.Lists;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DoorContainerTest {

    @Test
    public void testDoorContainersOpenedWithNoArray() {
        DoorContainer doorContainer = new DoorContainer(0);
        assertThat(doorContainer.getDoorsOpened()).isEmpty();
    }

    @Test
    public void testDoorContainerClosedWithNoArray() {
        DoorContainer doorContainer = new DoorContainer(0);
        assertThat(doorContainer.getDoorsClosed()).isEmpty();
    }

    @Test
    public void testDoorContainerClosedWithArrayOfOne() {
        DoorContainer doorContainer = new DoorContainer(1);
        assertThat(doorContainer.getDoorsClosed()).hasSize(1);
    }

    @Test
    public void testDoorContainerOpenWithArrayOfOne() {
        DoorContainer doorContainer = new DoorContainer(1);
        assertThat(doorContainer.getDoorsOpened()).hasSize(0);
    }

    @Test
    public void testDoorAfterIterationOfOne() {
        DoorContainer doorContainer = new DoorContainer(1);
        doorContainer.applyPredicateToAll(myIndex -> myIndex % 1 == 0);
        assertThat(doorContainer.getDoorsOpened()).hasSize(1);
    }

    @Test
    public void testOpenedDoorsAfterIterationOfTwo() {
        DoorContainer doorContainer = new DoorContainer(2);
        doorContainer.applyPredicateToAll(myIndex -> true);
        doorContainer.applyPredicateToAll(myIndex -> myIndex % 2 == 0);
        assertThat(doorContainer.getDoorsOpened()).isEqualTo(Lists.newArrayList(1));
        //   [0]    [1]
        //0. false, false
        //1. true,  true
        //2. true,  false
    }

    @Test
    public void testClosedDoorsAfterIterationOfTwo() {
        DoorContainer doorContainer = new DoorContainer(2);
        doorContainer.applyPredicateToAll(myIndex -> myIndex % 1 == 0);
        doorContainer.applyPredicateToAll(myIndex -> myIndex % 2 == 0);
        assertThat(doorContainer.getDoorsClosed()).isEqualTo(Lists.newArrayList(2));
        //   [0]    [1]
        //0. false, false
        //1. true,  true
        //2. true,  false
    }

    @Test
    public void testOpenedDoorsAfterIterationOfThree() {
        DoorContainer doorContainer = new DoorContainer(3);
        doorContainer.applyPredicateToAll(myIndex -> true);
        doorContainer.applyPredicateToAll(myIndex -> myIndex % 2 == 0);
        doorContainer.applyPredicateToAll(myIndex -> myIndex % 3 == 0);
        assertThat(doorContainer.getDoorsOpened()).isEqualTo(Lists.newArrayList(1));
        //   [0]    [1]    [2]
        //0. false  false  false
        //1. true   true   true
        //2. true   false  true
        //3. true   false  false
    }

    @Test
    public void testClosedDoorsAfterIterationOfThree() {
        DoorContainer doorContainer = new DoorContainer(3);
        doorContainer.applyPredicateToAll(myIndex -> true);
        doorContainer.applyPredicateToAll(myIndex -> myIndex % 2 == 0);
        doorContainer.applyPredicateToAll(myIndex -> myIndex % 3 == 0);
        assertThat(doorContainer.getDoorsClosed()).isEqualTo(Lists.newArrayList(2, 3));
        //   [0]    [1]    [2]
        //0. false  false  false
        //1. true   true   true
        //2. true   false  true
        //3. true   false  false
    }

    @Test
    public void testOpenDoorsAfterIteration() {
        DoorContainer doorContainer = new DoorContainer(3);
        doorContainer.applyToAll();
        assertThat(doorContainer.getDoorsOpened()).isEqualTo(Lists.newArrayList(1));
    }

    @Test
    public void testClosedDoorsAfterIteration() {
        DoorContainer doorContainer = new DoorContainer(3);
        doorContainer.applyToAll();
        assertThat(doorContainer.getDoorsClosed()).isEqualTo(Lists.newArrayList(2,3));
    }

    //    1      2      3      4      5
    //   [0]    [1]    [2]    [3]    [4]
    //0. false, false, false, false, false
    //1. true,  true,  true,  true,  true
    //2. true,  false, true,  false, true
    //3. true,  false, false, false, true
    //4. true,  false, false, true,  true
    //5. true,  false, false, true,  false

    @Test
    public void testClosedDoorsAfterFullIterationWith5() {
        DoorContainer doorContainer = new DoorContainer(5);
        doorContainer.applyToAll();
        assertThat(doorContainer.getDoorsClosed()).isEqualTo(Lists.newArrayList(2,3,5));
    }

    @Test
    public void testOpenDoorsAfterFullIterationWith5() {
        DoorContainer doorContainer = new DoorContainer(5);
        doorContainer.applyToAll();
        assertThat(doorContainer.getDoorsOpened()).isEqualTo(Lists.newArrayList(1, 4));
    }

    @Test
    public void testOpenDoorsAfterFullIterationWith100() {
        DoorContainer doorContainer = new DoorContainer(100);
        doorContainer.applyToAll();
        assertThat(doorContainer.getDoorsOpened()).isEqualTo(
                Lists.newArrayList(1, 4, 9, 16, 25, 36, 49, 64, 81, 100));
    }

    @Test
    public void testClosedDoorsAfterFullIterationWith100() {
        DoorContainer doorContainer = new DoorContainer(100);
        doorContainer.applyToAll();
        assertThat(doorContainer.getDoorsClosed()).isEqualTo(
                Lists.newArrayList(2, 3, 5, 6, 7, 8, 10, 11, 12, 13, 14,
                                   15, 17, 18, 19, 20, 21, 22, 23, 24, 26,
                                   27, 28, 29, 30, 31, 32, 33, 34, 35, 37,
                                   38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
                                   48, 50, 51, 52, 53, 54, 55, 56, 57, 58,
                                   59, 60, 61, 62, 63, 65, 66, 67, 68, 69,
                                   70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
                                   80, 82, 83, 84, 85, 86, 87, 88, 89, 90,
                                   91, 92, 93, 94, 95, 96, 97, 98, 99));
    }
}