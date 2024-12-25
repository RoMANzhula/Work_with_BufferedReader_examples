import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> wordsList = new ArrayList<String>(); // створюємо колекцію рядків у вигляді списку з інтерфейсом ArrayList

    static { // статичний блок, в якому ініціалізуємо (заповнюємо) нашу колекцію словами
        wordsList.add("Some");
        wordsList.add("word");
        wordsList.add("in");
        wordsList.add("text");
    }
    public static void main(String[] args) throws IOException {
        String urlString = "https://www.someSite.com/index.html"; // рядок для URL адреси
        String pathToFile = "c://...//file.txt"; // рядок для адреси (шляху) до файлу

        readingFromUrl(urlString); // викликаємо метод, який читає з сайту символи та виводить в консоль
        readingFromFileByPath(pathToFile); // викликаємо метод, який читає з файлу в консоль
        returnFromFileOnlyStringWithTwoMatchingWordsFromTheList(wordsList); // викликаємо метод, який фільтрує рядки з файлу
    }

    public static void readingFromUrl(String urlString) throws IOException { // метод, який читає дані з сайту (на вхід приймає адресу URL)
        // та виводить символи в консоль
        URL url = new URL(urlString); // створюємо змінну типу URL, в яку передаємо адресу для читання

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream())); // відкриваємо потік для вводу
        // символів та відразу буферизуємо його

        String containerForInputLine; // створюємо змінну для зчитування рядка з сайту

        while ((containerForInputLine = bufferedReader.readLine()) != null) { // поки рядок з прочитаними даними не буде порожнім
            System.out.println(containerForInputLine); // виводимо його в консоль
        }
        bufferedReader.close(); // закриваємо потік
    }

    public static void readingFromFileByPath(String path) throws IOException { // метод, який читає дані з файлу (на вхід
        // приймає адресу (шлях) до файлу) та виводить символи в консоль
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path))); // відкриваємо потік
        // для вводу символів та відразу буферизуємо його

        String containerForDataFromFile; // створюємо змінну для зчитування рядка з файлу

        while ((containerForDataFromFile = bufferedReader.readLine()) != null) { // поки рядок з прочитаними даними не буде порожнім
            System.out.println(containerForDataFromFile); // виводимо його в консоль
        }

        bufferedReader.close(); // очищаємо ресурси, закриваємо потоки
    }

    public static void returnFromFileOnlyStringWithTwoMatchingWordsFromTheList(List<String> words) throws IOException { // метод
        // який повертає з файлу тільки ті рядки, в яких буде всього два слова з колекції (списку)
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); // відкриваємо буферизований потік
        // для вводу даних з клавіатури (System.in)
        String nameFile = bufferedReader.readLine(); // створюємо змінну, в яку зчитуємо введену користувачем строку
        FileReader fileReader = new FileReader(nameFile); // за допомогою адаптера FileReader зчитуємо дані з файлу
        BufferedReader reader = new BufferedReader(fileReader); // буферизуємо зчитані дані

        while (reader.ready()) { // цикл виконується, поки є дані для читання
            String data = reader.readLine(); // створюємо змінну та зчитуємо в неї цілу строку (строка вважається цілісною,
            // поки в ній не з'явиться символ переходу на новий рядок (Enter))
            String[] wordsArr = data.split(" "); // створюємо масив рядків, у який розбиваємо зчитану строку на слова (розділювачем
            // є пробіл - " ")
            int count = 0; // створюємо змінну для підрахунку збігів (кількість збігів слів з масиву і колекції)
            for (int i = 0; i < wordsArr.length; i++) { // циклом for проходимо всі елементи масиву
                for (String element : words) { // за допомогою циклу for-each проходимо кожен елемент з колекції
                    if(wordsArr[i].equals(element)) { // якщо елемент масиву співпадає з елементом колекції, то
                        count++; // збільшуємо лічильник на 1
                    }
                }
            }
            if (count == 2) { // якщо лічильник дорівнює 2 (тобто знайдено рівно два співпадіння слів), то
                System.out.println(data); // виводимо рядок, що відповідає цьому збігу
            }

        }
        bufferedReader.close(); // очищаємо ресурси, закриваємо потік
        fileReader.close(); // очищаємо ресурси, закриваємо потік
        reader.close(); // очищаємо ресурси, закриваємо потік
    }

}
