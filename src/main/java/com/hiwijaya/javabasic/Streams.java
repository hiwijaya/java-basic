package com.hiwijaya.javabasic;

import java.util.*;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Streams {

    public List<Product> initList() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(5, "Sandals"));
        list.add(new Product(6, "Shoes"));
        list.add(new Product(7, "Pan"));
        list.add((new Product(8, "Stove")));
        list.add(new Product(9,"Spoon"));
        list.add(new Product(10, "Plate"));
        list.add(new Product(1, "Shampoo"));
        list.add(new Product(2, "Detergent"));
        list.add(new Product(3, "Tooth Brush"));
        list.add(new Product(4, "Tissue"));

        return list;
    }

    public void createStream(){

        // create an empty Stream (to prevent NUllPointerException)
        Stream<String> emptyStream = Stream.empty();
        System.out.println(emptyStream.count());

        // create Stream from Array
        Stream<String> streamArray = Stream.of("a", "b", "c");
        streamArray = Arrays.stream(new String[]{"d", "e", "f"});
        streamArray.forEach(System.out::println);

        // create Stream from Collection (Collection, List, Set)
        Collection<String> list = Arrays.asList("a", "b", "c");
        Stream<String> streamList = list.stream();
        streamList.forEach(System.out::println);

        // Stream with generate()
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
        streamGenerated.forEach(System.out::println);

        // Stream with iterate()
        Stream<Integer> streamIterated = Stream.iterate(10, n -> n + 2).limit(5);
        streamIterated.forEach(System.out::println);

    }

    // non-terminal operations
    public void intermediateOperations(){

        Stream<Product> stream;

        // filter()
        stream = initList().stream();
        stream.filter(p -> p.getName().startsWith("S"))
                .filter( p -> p.getName().length() == 5)
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        // limit()
        stream = initList().stream();
        stream.limit(5)
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        // skip()
        stream = initList().stream();
        stream.skip(2)
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        // distinct()
        List<Product> list = initList();
        list.add(new Product(1, "Soap"));
        list.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        // sorted()
        stream = initList().stream();
        stream.sorted()
                .sorted(Comparator.comparing((product) -> product.getName().length() ))
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        // peek() to peek at the elements in the stream, NOT TO TRANSFORM THEM.
        // Keep in mind that the peek method does not start the internal iteration
        // of the elements in the stream. You need to call a terminal operation for that.
        stream = initList().stream();
        stream.peek((p) -> System.out.println(p.getName().toUpperCase()));  // wouldn't execute

        System.out.println("----------------------------------");

        // map() method converts (maps) an element to another object.
        stream = initList().stream();
        stream.map(Streams::upperCaseName)
                .forEach(System.out::println);

        // flatMap()
        // operation has the effect of applying a one-to-many transformation
        // to the elements of the stream, and then flattening the resulting elements into a new stream.
        String[][] data = new String[][]{{"a", "b"}, {"c", "d", "e"}, {"f", "g"}, {"h"}};
        Stream<String[]> streamArr = Arrays.stream(data);
        String[] flatten = streamArr.flatMap(arr -> Arrays.stream(arr))
                .toArray(String[]::new);
        System.out.println(Arrays.toString(flatten));

    }

    public void terminalOperations(){

        Stream<Product> stream;

        // anyMatch()
        stream = initList().stream();
        boolean anyMatch =stream.sorted()
                .anyMatch((p) -> p.getName().startsWith("Tooth"));
        System.out.println("Product start with 'Tooth': " + anyMatch);

        // allMatch()
        stream = initList().stream();
        boolean allMatch = stream.allMatch((p) -> p.getName().length() >= 3);
        System.out.println("All product length is >= 3: " + allMatch);

        // noneMatch()
        stream = initList().stream();
        boolean noneMatch = stream.noneMatch((p) -> p.getName().contains("x"));
        System.out.println("Product name doesn't contains 'x':" + noneMatch);

        // collect() converted proceed Stream to Collections
        stream = initList().stream();
        List<Product> filtered = stream.filter(p -> p.getName().startsWith("S"))
                .collect(Collectors.toList());
        System.out.println(filtered);

        // count() starts the internal iteration of the elements in the Stream, and counts the elements.
        stream = initList().stream();
        long count = stream.filter(p -> p.getName().startsWith("T"))
                .count();
        System.out.println("Product startwith 'T': " + count);

        // findAny() method can find a single element from the Stream.
        // The element found can be from anywhere in the Stream.
        // There is NO GUARANTEE about from where in the stream the element is taken.
        stream = initList().stream();
        Optional<Product> any = stream.findAny();
        any.ifPresent(System.out::println);

        // findFirst()
        stream = initList().stream();
        Optional<Product> first = stream.findFirst();
        first.ifPresent(System.out::println);

        // min()
        stream = initList().stream();
        Optional<Product> min = stream.min((val1, val2) -> val1.getId() - val2.getId());
        System.out.print("min ");
        min.ifPresent(System.out::println);

        // max()
        stream = initList().stream();
        Optional<Product> max = stream.max(Comparator.comparingInt(Product::getId));
        System.out.print("max ");
        max.ifPresent(System.out::println);

        // reduce() a terminal operation that can reduce all elements in the stream to a single element.
        stream = initList().stream();
        String reduced = stream.map(p -> p.getName() + ", ")
                .reduce("products: ", (subtotal, element) -> subtotal + element);
        System.out.println(reduced);

        // forEach()
        stream = initList().stream();
        stream.forEach(p -> System.out.println(p.getName()));

        // toArray()
        stream = initList().stream();
        Product[] productArr = stream.sorted().toArray(Product[]::new);
        System.out.println(Arrays.toString(productArr));

    }

    public static Product upperCaseName(Product p){
        p.setName(p.getName().toUpperCase());
        return p;
    }



    public static void main(String[] args) {
        Streams s = new Streams();
//        s.createStream();
//        s.intermediateOperations();
        s.terminalOperations();


    }

}

