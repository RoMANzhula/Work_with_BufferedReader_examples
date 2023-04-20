import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> wordsList = new ArrayList<String>(); //создаем строковую коллекцию в виде Списка с интерфейсом ArrayList

    static { //статический блок, в котором проинициализируем (заполним) нашу коллекцию из слов
        wordsList.add("Some");
        wordsList.add("word");
        wordsList.add("in");
        wordsList.add("text");
    }
    public static void main(String[] args) throws IOException{
        String urlString = "https://www.someSite.com/index.html"; //строка для URL адреса
        String pathToFile = "c://...//file.txt"; //строка для адреса(пути) к файлу

        readingFromUrl(urlString); //вызываем метод, который читает с сайта символьные данные в консоль
        readingFromFileByPath(pathToFile); //вызываем метод, который читает из файла в консоль
        returnFromFileOnlyStringWithTwoMatchingWordsFromTheList(wordsList);
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

    public static void returnFromFileOnlyStringWithTwoMatchingWordsFromTheList(List<String> words) throws IOException { //метод
        //который будет возвращать из указанного файла только те строки, в которых будет всего два слова из коллекции(Списка)
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); //открываем буферизированный поток
        //для ввода данных с клавиатуры(System.in)
        String nameFile = bufferedReader.readLine(); //создаем строковую переменную, в которую читаем введенную строку пользователем
        FileReader fileReader = new FileReader(nameFile); //с помощью Адаптера FileReader читаем данные из указанного файла
        BufferedReader reader = new BufferedReader(fileReader); //буферизируем считанные Адаптером данные

        while (reader.ready()) { //цикл будет выполняться пока есть данные для чтения
            String data = reader.readLine(); //создаем строковую переменную и читаем в нее целыми строками (строка считается целой,
            //пока в ней не появится символ перехода строка (Enter))
            String[] wordsArr = data.split(" "); //создаем строковый массив в который разбиваем считанную строку на слова(разделителем
            //в данном случае выступает пробел - " ")
            int count = 0; //создаем целочисленную переменную, которая выступает в роли счетчика(будет считать совпадения слов в
            //массиве и коллекции)
            for (int i = 0; i < wordsArr.length; i++) { //циклом for проходимся по всем элементам массива
                for (String element : words) { //с помощью for-each проходимся по каждому элементу из Коллекции
                    if(wordsArr[i].equals(element)) //если элемент массива совпадает с элементом коллекции, то
                        count++; //увеличиваем счетчик на 1
                }
            }
            if (count == 2) { //если значение счетчика = 2 (т.е. у нас есть совпадение двух слов и только 2 слов), то
                System.out.println(data); //выводим строку с соответствующим совпадением
            }

        }
        bufferedReader.close(); //очищаем ресурсы, закрываем поток
        fileReader.close(); //очищаем ресурсы, закрываем поток
        reader.close(); //очищаем ресурсы, закрываем поток
    }

}