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
        flatMapEx_Object();
    }

    /*
     *
     *  map()     one-to-one     Stream<T> ===> Stream<Y>
     *  flatMap() one-to-many    Stream<Collection<E>/array of E> ===> Stream<E>
     *               .flatMap(e -> e.stream()) / .flatMap(Arrays::stream)
     *  reduce()  many-to-one    Stream<T> ===> V v
     *
     * map()        : one input → one output
     * flatMap()    : one input → many outputs (then flattened into a single stream)
     *
     * rare use case      map()     one-to-many    Stream<T> ===> Stream<List<Y>>
     * e.g emp -> List<emailIds>
     *
     *
     * */
    private static void needOfFlatMap() {

        Function<Integer, Integer> oneToOne = e -> e * 2; // e.g emp -> firstName
        Function<Integer, List<Integer>> oneToMany = e -> Arrays.asList(e - 1, e + 1); //e.g emp -> List<emailIds>

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.print("one to one mapping - ");
        numbers.stream()
                .map(oneToOne) // one-to-one mapping function
                .forEach(e -> System.out.print(e + ", "));

        System.out.print("\none to many mapping - ");
        numbers.stream()
                .map(oneToMany) // one-to-many mapping function
                .flatMap(e -> e.stream())   // many-to-one mapping function
                .forEach(e -> System.out.print(e + ", "));
    }

    /*
     *
     * map()        ->  Stream<T> ===> Stream<Y>
      *             ->  transform one type to another type
     * flatMap()    ->  Stream<Collection<E>/array of E>  ===> Stream<E>
     *              ->  transforming, Stream<Collection<E>/array of E> -> Stream<E>
     *
     * Visual representation:
     * 	    Before flatMap: [ [1,2], [3,4], [5] ]
     * 	    After flatMap: [ 1, 2, 3, 4, 5 ]
     * 	    Think: “Map + flatten = flatMap”
     *
     * wrong usage of map - using map() in place of flatMap()
     * Ex :
     *        listOfLists.stream()                      // Stream<List<Integer>>
     *            .map(l -> l.stream())                 // Stream<Stream<Integer>>, nested Stream
     *            .collect(Collectors.toList());
     *        applying map() instead of flatMap()  - Stream<Stream<Integer>> this is nested Stream
     *        Nested streams = useless in most cases
     *
     *      sentences.stream()                          // Stream<String>
     *          .map(word -> word.split(""))            // Stream<String[]>
     *          .map(Arrays::stream) 		            // Stream<Stream<String>>
     *          .collect(Collectors.toList());
     *        applying map() instead of flatMap()  - Stream<Stream<Integer>> this is nested Stream
     *        Nested streams = useless in most cases
     *
     * Primitive flatMap variants (performance)
     *      -   flatMapToInt()
     *      -   flatMapToLong()
     *      -   flatMapToDouble()
     *
     *
     * */
    private static void flatMapEx() {

        // Stream<List<Integer>> to Stream<Integer> by applying - flatMap(e -> e.stream())
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5)
        );
        List<Integer> listOfE = listOfLists.stream()
                .flatMap(l -> l.stream())
                .toList();
        System.out.println("listOfE = " + listOfE); //[1, 2, 3, 4, 5]

        // Stream<String[]> to Stream<String> by applying - flatMap(Arrays::stream)
        List<String> sentences = Arrays.asList(
                "Java is powerful",
                "Streams are lazy"
        );
        List<String> words =
                sentences.stream()
                        .map(e -> e.split(" "))
                        .flatMap(Arrays::stream)
                        .toList();
        System.out.println("words = " + words); //[Java, is, powerful, Streams, are, lazy]
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
