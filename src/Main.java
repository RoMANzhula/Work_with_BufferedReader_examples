import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException{
        String urlString = "https://www.someSite.com/index.html"; //строка для URL адреса

        readingFromUrl(urlString); //вызываем метод, который читает с сайта символьные данные
    }

    public static void readingFromUrl(String urlString) throws IOException { //метод, который считывает данные с сайта(на вход
        //принимает адрес URL)
        URL url = new URL(urlString); //создаем переменную типа URL, в которую передадим адрес для считывания

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream())); //открываем поток для ввода
        //символьных данных и сразу буферизируем его

        String inputLine = bufferedReader.readLine(); //создаем строковую переменную, в которую будем читать по одной строке

        while (inputLine != null) { //пока строка с прочитанными данными не будет пустой
            System.out.println(inputLine); //будем выводить ее в консоль
        }
    }
}