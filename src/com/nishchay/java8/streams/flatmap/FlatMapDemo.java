package com.nishchay.java8.streams.flatmap;

import com.nishchay.util.pojo.Author;
import com.nishchay.util.pojo.Book;
import com.nishchay.util.pojo.Country;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemo {


    public static void main(String[] args) {

        needOfFlatMap();

        flatMapEx();

        List<Book> books = Book.getListOfBook();
        mapAndCollectToList(books);
        flatMapDemoLowerToUpperObject();
        flatMapDemoUpperToLowerObject(books);
        flatMapEx_Object();
    }

    /*
    *
    *  map()     one-to-one     Stream<T> ===> Stream<Y>
    *  map()     one-to-many    Stream<T> ===> Stream<List<Y>>
    *  flatMap() many-to-one    Stream<List<E>> ===> Stream<E>
    *               .flatMap(e -> e.stream()) => Stream<collection/array of E> ===> Stream<E>
    *  reduce()  many-to-one    Stream<T> ===> V v
    *
    * */
    private static void needOfFlatMap() {

        Function<Integer, Integer> oneToOne = e -> e * 2; // e.g emp -> firstName
        Function<Integer, List<Integer>> oneToMany = e -> Arrays.asList(e - 1, e + 1); //e.g emp -> List<emailIds>
        // Function<Integer, Stream<Integer>> oneToMany = e -> Stream.of(e - 1, e + 1); //e.g emp -> List<emailIds>

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.print("one to one mapping - ");
        numbers.stream()
                .map(oneToOne) // one-to-one mapping function
                .forEach(e -> System.out.print(e + ", "));

        System.out.print("\none to many mapping - ");
        numbers.stream()
                .map(oneToMany) // one-to-many mapping function
                .flatMap(e -> e.stream())
                .forEach(e -> System.out.print(e + ", "));
    }

    /*
     *
     * map()        →   you get a list of items, map will help you what you want to do with each item
     * flatMap()    →   you get a list of boxes which is filled with items,
     *                  you open all boxes and pull out all the items put them into a flat list
     *
     *  -   Doing a transformation of, Stream<collection/array of E> -> Stream<E>
     *  -   Not giving same no of output as no of input
     *  -   For primitive , below variant of map can be used :
     *          flatMapToInt(), flatMapToLong(), flatMapToDouble()
     *
     * */
    private static void flatMapEx() {
        // Find unique chars from list of words
        String[] arrOfWords = {"Goodbye", "World"};
        // array[] to stream
        Stream<String> streamOfWords = Arrays.stream(arrOfWords);

/*
        wrong usage of map - using map in place of flatMap
        List<String> uniqueChars =
                streamOfWords
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
*/

        List<String> uniqueChars = streamOfWords
                .map(word -> word.split(""))
                //.flatMap(e -> Arrays.stream(e))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("uniqueChars = " + uniqueChars);
    }


    private static void mapAndCollectToList(List<Book> books) {

        System.out.println(" ----------------map() & Collectors.toList() demo ----------------");
        List<String> authors =
                books.stream()
                        .map(Book::getAuthorName)
                        .sorted()
                        .collect(Collectors.toList());

        System.out.println("authors = " + authors);
    }

    private static void flatMapDemoLowerToUpperObject() {

        System.out.println(" ---------------- LowerToUpperObject ----------------");
        List<String> writers = Arrays.asList("Spider Man", "Iron Man", "Super Man", "Wonder Women");
        // Mapping : LowerToUpperObject
        List<Book> books = writers.stream().map(writer -> new Book(1001, "Book 1", writer, 100))
                .collect(Collectors.toList());

        books.forEach(System.out::println);
    }



    private static void flatMapDemoUpperToLowerObject(List<Book> books) {

        System.out.println(" ---------------- UpperToLowerObject ----------------");
        // Mapping : UpperToLowerObject
        int totalPage = books.stream()
                //.mapToInt(e -> e.getPageCount())
                .mapToInt(Book::getPageCount)
                .sum();

        System.out.println("totalPage = " + totalPage);
    }

    private static void flatMapEx_Object() {

        Author author1 = new Author();
        author1.setName("Andrew S. Tanenbaum");
        author1.setCountry(new Country("US"));
        author1.setBooks(Arrays.asList(
                new Book(2021, "Computer Networks", "Andrew S. Tanenbaum", 700),
                new Book(2022, "Modern Operating Systems", "Andrew S. Tanenbaum", 580),
                new Book(2023, "Structured Computer Organization", "Andrew S. Tanenbaum", 400),
                new Book(2024, "Data Structure", "Andrew S. Tanenbaum", 220)
        ));

        Author author2 = new Author();
        author2.setName("E. Balagurusamy");
        author2.setCountry(new Country("India"));
        author2.setBooks(Arrays.asList(
                new Book(2051, "Object-oriented Programming with C++", "E. Balagurusamy", 400),
                new Book(2052, "Programming in ANSI C", "E. Balagurusamy", 580),
                new Book(2053, "Programming in C#: A Primer", "E. Balagurusamy", 300)
        ));

        List<Author> autherList = new ArrayList<>();
        autherList.add(author1);
        autherList.add(author2);


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

}
