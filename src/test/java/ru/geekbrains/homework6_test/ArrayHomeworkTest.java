package ru.geekbrains.homework6_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.homework6_log_test.ArrayHomework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayHomeworkTest {

    @MethodSource("fillSliceParams")
    void sliceTest(int[] in, int [] out) {
        Assertions.assertArrayEquals(out, ArrayHomework.sliceArray(in));
    }

    static Stream<Arguments> fillSliceParams() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[] {1,5,4,8,2,1,4,8,6,4,5,77,1}, new int[] {5,77,1}));
        list.add(Arguments.arguments(new int[] {4}, new int[] {}));
        list.add(Arguments.arguments(new int[] {1,5,4,8,2,1,4,8,6,5,77,1}, new int[] {8,6,5,77,1}));
        return list.stream();
    }

    @Test
    void testSliceException() {
        Assertions.assertThrows(RuntimeException.class, () -> ArrayHomework.sliceArray(new int[] {1,2,54,5}));
    }

    @Test
    void oneAndFourTest() {
        Assertions.assertTrue(ArrayHomework.hasOneAndFour(new int[] {1,1,1,4,4,4,1}));
    }
}
