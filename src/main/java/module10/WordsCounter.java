package module10;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class WordsCounter {
    public static void main(String[] args) {

        // Створення нової HashMap для зберігання слів та їх частоти
        Map<String, Integer> wordsMap = new HashMap<>();

        // Спробуйте відкрити файл та прочитати його вміст
        try (InputStream fis = new FileInputStream("C:\\Диск D\\java\\Education\\src\\main\\java\\module10\\words.txt");
             Scanner scanner = new Scanner(fis)){

            // Проходження кожного слова в файлі
            while (scanner.hasNext()){
                String word =scanner.next();

                // Якщо слово ще не міститься у мапі, додайте його з частотою 1
                if (!wordsMap.containsKey(word)) {
                    wordsMap.put(word, 1);
                } else {
                    // Якщо слово вже міститься у мапі, збільште його частоту на 1
                    wordsMap.put(word, wordsMap.get(word) + 1);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // Створення нового Comparator для сортування мапи за значенням (частотою)
        Comparator<String> comparator = ((o1, o2) -> wordsMap.get(o2).compareTo(wordsMap.get(o1)));

        // Створення нового TreeMap для зберігання відсортованої мапи
        Map<String, Integer> result = new TreeMap<>(comparator);

        // Додавання всіх записів з оригінальної мапи до відсортованої мапи
        result.putAll(wordsMap);

        // Проходження кожного запису у відсортованій мапі та друк його до консолі
        result.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
