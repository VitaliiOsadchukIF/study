package module10;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserReader { // Створюємо клас UserReader
    //    Є текстовий файл file.txt. Необхідно прочитати файл,
    //    перетворити його в список об'єктів типу User,
    //    і записати їх у новий файл user.json.
    public static void main(String[] args) { // Створюємо головний метод main
        List<User> userList = new ArrayList<>(); // Створюємо порожній список об'єктів типу User
        // (C:/Users/user/IdeaProjects/Shape/src/main/java/module10/)

        try  // Відкриваємо файл file.txt за допомогою FileReader
                (FileReader fileReader = new FileReader("C:\\Диск D\\java\\Education\\src\\main\\java\\module10\\file.txt");
                 Scanner scanner = new Scanner(fileReader)) { // Відкриваємо Scanner для читання файлу
            if (scanner.hasNextLine()) {// Перевіряємо, чи є наступний рядок у файлі
                scanner.nextLine(); // Пропускаємо перший рядок, який містить заголовки
            }
            while (scanner.hasNextLine()) { // Повторюємо, поки є наступний рядок у файлі
                String userName = scanner.next(); // Зчитуємо наступне слово у рядку як userName
                int userAge = scanner.nextInt(); // Зчитуємо наступне число у рядку як userAge
                User user = new User(userName, userAge); // Створюємо новий об'єкт типу User з userName та userAge
                userList.add(user); // Додаємо об'єкт user до списку userList
            }

        } catch (Exception ex) { // Обробляємо будь-який виняток, який може виникнути при читанні файлу
            ex.printStackTrace(); // Виводимо стек-трейс винятку на консоль
        }

        // Відкриваємо файл user.json за допомогою FileWriter
        try (FileWriter fileWriter = new FileWriter("C:\\Диск D\\java\\Education\\src\\main\\java\\module10\\user.json")) {
            // Створюємо об'єкт типу Gson з опцією pretty printing для форматування JSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Перетворюємо список userList у JSON-рядок та записуємо його у файл user.json за допомогою методу toJson
            gson.toJson(userList, fileWriter);

        } catch (Exception ex) { // Обробляємо будь-який виняток, який може виникнути при записі файлу
            ex.printStackTrace();
        }
    }
}

