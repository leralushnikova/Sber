package Part3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        /*for (City c : cityList) {
            System.out.println(c.toString());
        }*/

       /* for (City c : cityList) {
            for (City s : cityList) {
                if (c.getRegion().compareTo(s.getRegion()) > 0) {
                    City a = c;
                    c = s;
                    s = a;
                }
            }
            System.out.println(c);
        }*/
    }
}
