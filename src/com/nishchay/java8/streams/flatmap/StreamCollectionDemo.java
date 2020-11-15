package com.nishchay.java8.streams.flatmap;

import java.util.*;
import java.util.stream.Collectors;

public class StreamCollectionDemo {

    public static void main(String[] args) {

        mthd4mapAndCollectorsToList();
        mthd4mapToIntAndSum();
        mthd4flatMap();

    }


    private static void mthd4mapAndCollectorsToList() {

        List<Book> books = getListOfBook();

        System.out.println(" ----------------map() & Collectors.toList() demo ----------------");
        List<String> authers =
                books.stream()
                        .map(e -> e.getAuthorName())
                        .sorted()
                        .collect(Collectors.toList());

        System.out.println("authers = " + authers);
    }

    private static void mthd4mapToIntAndSum() {

        List<Book> books = getListOfBook();

        System.out.println(" ----------------mapToInt() & sum() demo ----------------");
        int totalPage = books.stream()
                .mapToInt(e -> e.getPageCount())
                .sum();

        System.out.println("totalPage = " + totalPage);
    }

    private static void mthd4flatMap() {

        Author auther1 = new Author();
        auther1.setName("Andrew S. Tanenbaum");
        auther1.setCountry("US");
        auther1.setBooks(Arrays.asList(
                new Book(2021, "Computer Networks", "Andrew S. Tanenbaum", 700),
                new Book(2022, "Modern Operating Systems", "Andrew S. Tanenbaum", 580),
                new Book(2023, "Structured Computer Organization", "Andrew S. Tanenbaum", 400),
                new Book(2024, "Data Strcuture", "Andrew S. Tanenbaum", 220)
        ));

        Author auther2 = new Author();
        auther2.setName("E. Balagurusamy");
        auther2.setCountry("India");
        auther2.setBooks(Arrays.asList(
                new Book(2051, "Object-oriented Programming with C++", "E. Balagurusamy", 400),
                new Book(2052, "Programming in ANSI C", "E. Balagurusamy", 580),
                new Book(2053, "Programming in C#: A Primer", "E. Balagurusamy", 300)
        ));

        List<Author> autherList = new ArrayList<>();
        autherList.add(auther1);
        autherList.add(auther2);


        List<Book> books =
                autherList.stream()
                        .map(e -> e.getBooks())
                        .flatMap(e -> e.stream())
                        .distinct()
                        .collect(Collectors.toList());


        System.out.println("------------------ books ----------------------------");
        books.forEach(System.out::println);


        Optional<Integer> minPage =
                autherList.stream()
                        .map(e -> e.getBooks())
                        .flatMap(e -> e.stream())
                        .map(e -> e.getPageCount())
                        .min(Comparator.naturalOrder());

        System.out.println("minPage = " + minPage.get());

        Optional<Book> smallestBook =
                autherList.stream()
                        .map(e -> e.getBooks())
                        .flatMap(e -> e.stream())
                        .min(Comparator.comparing(Book::getPageCount));

        System.out.println("smallestBook = " + smallestBook.get());


    }

    private static List<Book> getListOfBook() {
        List<Book> listOfBook = new ArrayList<>();
        listOfBook.add(new Book(1011, "Hindi", "Prem Chand", 200));
        listOfBook.add(new Book(1012, "Mathemetics", "K C Sinha", 650));
        listOfBook.add(new Book(1033, "Computer Science", "Tenen Bom", 140));
        listOfBook.add(new Book(1048, "Physics", "H C Verma", 240));
        listOfBook.add(new Book(1050, "Economics", "Rowrds Jowney", 900));
        return listOfBook;
    }

}
