package test;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'fetchItemsToDisplay' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY items
     *  2. INTEGER sortParameter
     *  3. INTEGER sortOrder
     *  4. INTEGER itemsPerPage
     *  5. INTEGER pageNumber
     *
     *  List<String> = Joao 1 10
     *  List<String> = Goncalo 2 5
     */



    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        // Write your code here
        List<Item> itemList = items.stream().map(Item::buildFrom).collect(Collectors.toList());
        Comparator<Item> comparator = buildComparatorFor(sortParameter, sortOrder);
        itemList.stream().sorted(comparator);
        return itemList.stream().skip(itemsPerPage * pageNumber).limit(itemsPerPage).map(x -> x.getName()).collect(Collectors.toList());
    }

    private static Comparator<Item> buildComparatorFor(int sortParameter, int sortOrder) {
        Comparator<Item> comparator;
        switch (sortParameter) {
            case 0:
                comparator = Comparator.comparing(Item::getName);
                break;
            case 1:
                comparator = Comparator.comparing(Item::getRelevance);
                break;
            case 2:
                comparator = Comparator.comparing(Item::getPrice);
                break;
            default:
                throw new InvalidParameterException("Not expecting values different from 0,1,2 in sortParameter");
        }
        if (sortOrder == 1) {
            comparator = comparator.reversed();
        }
        return comparator;

    }

}

class Item {
    private String name;
    private int relevance;
    private int price;

    public Item(String name, int relevance, int price) {
        this.name = name;
        this.relevance = relevance;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", relevance=" + relevance +
                ", price=" + price +
                '}';
    }

    /**
     * List<String> = Joao 1 10
     * @param inputParams
     * @return
     */
    public static Item buildFrom(List<String> inputParams) {

        return new Item(
                inputParams.get(0), //name
                Integer.parseInt(inputParams.get(1)), // relevance
                Integer.parseInt(inputParams.get(2)) //price
        );

    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int itemsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int itemsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> items = new ArrayList<>();

        IntStream.range(0, itemsRows).forEach(i -> {
            try {
                items.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int sortParameter = Integer.parseInt(bufferedReader.readLine().trim());

        int sortOrder = Integer.parseInt(bufferedReader.readLine().trim());

        int itemsPerPage = Integer.parseInt(bufferedReader.readLine().trim());

        int pageNumber = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result.fetchItemsToDisplay(items, sortParameter, sortOrder, itemsPerPage, pageNumber);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
