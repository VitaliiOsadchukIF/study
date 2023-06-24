package module10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneValidator {
    // Створюємо метод, який приймає назву файлу як параметр
    public static void validatorPhoneNumbers(String fileName) {
        // Створюємо об'єкт файлу за назвою
        File file = new File(fileName);
        // Створюємо об'єкт сканера для читання файлу
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            // Якщо файл не знайдено, виводимо повідомлення про помилку і завершуємо метод
            System.out.println("File not found: " + fileName);
            return;
        }
        // Створюємо об'єкт патерну для перевірки валідності телефонного номера за двома форматами
        Pattern pattern = Pattern.compile("(\\d{3}-\\d{3}-\\d{4})|(\\(\\d{3}\\) \\d{3}-\\d{4})");
        // Поки в файлі є наступний рядок, читаємо його і перевіряємо на валідність
        while (scanner.hasNextLine()) {
            // Зчитуємо рядок з файлу
            String line = scanner.nextLine();
            // Якщо рядок відповідає патерну, виводимо його на екран
            if (pattern.matcher(line).matches()) {
                System.out.println(line);

            }
        }
        // Закриваємо сканер
        scanner.close();
    }

    // Створюємо головний метод для тестування
    public static void main(String[] args) {
        // Викликаємо метод з назвою файлу file.txt
        validatorPhoneNumbers("C:\\Диск D\\java\\Education\\src\\main\\java\\module10\\filePhone.txt");
    }
}


