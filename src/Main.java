import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException{
        String urlString = "https://www.someSite.com/index.html"; //строка для URL адреса
        String pathToFile = "c://...//file.txt"; //строка для адреса(пути) к файлу

        readingFromUrl(urlString); //вызываем метод, который читает с сайта символьные данные в консоль
        readingFromFileByPath(pathToFile); //вызываем метод, который читает из файла в консоль
    }

    public static void readingFromUrl(String urlString) throws IOException { //метод, который считывает данные с сайта(на вход
        //принимает адрес URL)  и выводит символьные данные в консоль
        URL url = new URL(urlString); //создаем переменную типа URL, в которую передадим адрес для считывания

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream())); //открываем поток для ввода
        //символьных данных и сразу буферизируем его

        String containerForInputLine; //создаем строковую переменную, в которую будем читать по одной строке из сайта

        while ((containerForInputLine = bufferedReader.readLine()) != null) { //пока строка с прочитанными данными не будет пустой
            System.out.println(containerForInputLine); //будем выводить ее в консоль
        }
        bufferedReader.close(); //закрываем поток
    }

    public static void readingFromFileByPath(String path) throws IOException { //метод, который считывает данные с файла(на вход
        //принимает адрес(путь) к файлу) и выводит символьные данные в консоль
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path))); //открываем поток
        //для ввода символьных данных и сразу буферизируем его

        String containerForDataFromFile; //создаем строковую переменную, в которую будем читать по одной строке из файла

        while ((containerForDataFromFile = bufferedReader.readLine()) != null) { //пока строка с прочитанными данными не будет пустой
            System.out.println(containerForDataFromFile); //будем выводить ее в консоль
        }

        bufferedReader.close(); //освобождаем ресурсы, закрываем потоки
    }
}