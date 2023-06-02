package Part3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Задача ВС Java Сбер.csv"));
        String line;
        Scanner scanner;
        int index = 0;
        List<City> cityList = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            City city = new City();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if(index == 0) city.setNumber(Integer.parseInt(data));
                else if(index == 1) city.setName(data);
                else if (index == 2) city.setRegion(data);
                else if (index == 3) city.setDistrict(data);
                else if (index == 4) city.setPopulation(Integer.parseInt(data));
                else if (index == 5) city.setFoundation(data);
                else
                    System.out.println("Некорректные данные::" + data);
                index++;
            }
            index = 0;
            cityList.add(city);
        }
        reader.close();

        /*
        for (City c : cityList) {
            System.out.println(c.toString());
        }
        */

        /*
        cityList.sort(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (City c : cityList) {
            System.out.println(c.toString());
        }
        System.out.println();
        cityList.sort(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getDistrict().compareTo(o2.getDistrict()) ;
            }
        });
        for (City c : cityList) {
            System.out.println(c.toString());
        }
        */

        /*
        City[] cities = cityList.toArray(new City[0]);
        int max = 0;
        for (City city : cities) {
            if(max < city.getPopulation()) max = city.getPopulation();
        }
        for (City city : cities) {
            if(max == city.getPopulation()) System.out.println("[" + city.getNumber() + "] = " + city.getPopulation());
        }
        */

        Map<String, Integer> cities = new HashMap<>();
        for (City city : cityList) {
            if (!cities.containsKey(city.getRegion())) {
                cities.put(city.getRegion(), 1);
            } else {
                cities.put(city.getRegion(), cities.get(city.getRegion()) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : cities.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }

}
