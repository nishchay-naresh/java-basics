package com.nishchay.java8.split;

import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/*
 *	1.	This is a custom spliterator class that implements Spliterator<Student>.
 *	2.	We need to override four methods: tryAdvance, trySplit, estimateSize and characteristics.
 *	3.	The characteristics methods return NONNULL i.e. all elements are nonnull.
 *	4.	The estimateSize is returning the size of the list studentList.
 *
* */
public class StudentSpliterator implements Spliterator<Student> {

   private final List<Student> studentList;
 
   private int endIndex;
   private int startIndex;
 
   public StudentSpliterator(List<Student> studentList) {
       this(studentList, 0, studentList.size());
   }
 
   private StudentSpliterator(List<Student> studentList, int startIndex, int endIndex) {
       this.studentList = studentList;
       this.startIndex = startIndex;
       this.endIndex = endIndex;
   }
 
   @Override
   public boolean tryAdvance(Consumer<? super Student> action) {
       if (getSize() > 0) {
           action.accept(studentList.get(startIndex));
           startIndex++;
           return true;
       }
       return false;
   }
 
   @Override
   public Spliterator<Student> trySplit() {
 
       if (getSize() == 1) {
           return null;
       }
 
       int newStartIndex;
       int newEndIndex = endIndex;
 
       if (getSize() % 2 == 0) {
           newStartIndex = startIndex + getSize() / 2;
           this.endIndex -= getSize() / 2;
       } else {
           newStartIndex = startIndex + getSize() / 2 + 1;
           this.endIndex -= getSize() / 2;
       }
       return new StudentSpliterator(studentList, newStartIndex, newEndIndex);
   }
 
 
   private int getSize() {
       return endIndex - startIndex;
   }
 
   @Override
   public long estimateSize() {
       return studentList.size();
   }
 
   @Override
   public int characteristics() {
       return NONNULL;
   }
}