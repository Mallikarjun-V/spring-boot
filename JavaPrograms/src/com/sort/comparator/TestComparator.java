package com.sort.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator interface provides multiple sorting sequences. Comparator doesn't affect the original class, i.e., the
 * actual class is not modified. Comparator provides compare() method to sort elements. present in java.util package
 * 
 * @author MALLIKARJUN
 *
 */
public class TestComparator {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "s1", "s1", 21));
        students.add(new Student(2L, "s2", "s2", 20));
        students.add(new Student(3L, "s3", "s3", 23));
        System.out.println(students);
        Comparator<Student> ageComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getAge() == s2.getAge()) {
                    return 0;
                } else if (s1.getAge() > s2.getAge()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        
        Comparator<Student> idComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getId() == s2.getId()) {
                    return 0;
                } else if (s1.getId() > s2.getId()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        
        Collections.sort(students, ageComparator);
        System.out.println(students);
        
        Collections.sort(students, idComparator);
        System.out.println(students);
    }
}
