package com.sort.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Comparable interface provides a single sorting sequence. Comparable affects the original class, i.e., the actual
 * class is modified. Comparable provides compareTo() method to sort elements. present in java.lang package
 * 
 * @author MALLIKARJUN
 *
 */
public class TestComparable {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "s1", "s1", 21));
        students.add(new Student(2L, "s2", "s2", 20));
        students.add(new Student(3L, "s3", "s3", 23));
        System.out.println(students);
        Collections.sort(students);
        System.out.println(students);
    }
}
