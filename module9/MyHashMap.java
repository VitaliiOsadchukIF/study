package module9;

import java.io.InputStream;

// Клас Nodo для зберігання пари ключ-значення
class Nodo<K, V> {
    K key;  // Ключ
    V value; // Значення
    Nodo<K, V> next; // Посилання на наступний елемент

    // Конструктор
    public Nodo(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

// Клас MyHashMap для реалізації хеш-таблиці
public class MyHashMap<K, V> {
    private static final int CAPACITY = 16; // Розмір масиву бакетів
    InputStream i;
    private Nodo<K, V>[] buckets; // Масив бакетів
    private int size; // Кількість елементів

    // Конструктор
    public MyHashMap() {
        buckets = new Nodo[CAPACITY];
        size = 0;
    }

    // Метод для отримання хеш-коду ключа
    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode()) % CAPACITY;
    }

    // Метод для додавання пари ключ-значення
    public void put(K key, V value) {
        int index = hash(key); // Індекс бакета
        Nodo<K, V> head = buckets[index]; // Перший елемент бакета
        Nodo<K, V> nodo = new Nodo<>(key, value); // Новий елемент
        // Якщо бакет порожній, додаємо новий елемент на початок
        if (head == null) {
            head = nodo;
            size++;
            return;
        }
        // Якщо бакет не порожній, перевіряємо, чи існує елемент з таким самим ключем
        Nodo<K, V> prev = null; // Попередній елемент
        Nodo<K, V> curr = head; // Поточний елемент
        while (curr != null) {
            // Якщо знайшли елемент з таким самим ключем, оновлюємо його значення і виходимо з методу
            if (curr.key == key || (key != null && key.equals(curr.key))) {
                curr.value = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        // Якщо не знайшли елемент з таким самим ключем, додаємо новий елемент в кінець бакета
        prev.next = nodo;
        size++;
    }

    // Метод для видалення пари за ключем
    public void remove(K key) {
        int index = hash(key); // Індекс бакета
        Nodo<K, V> head = buckets[index];  // Перший елемент бакета

        // Якщо бакет порожній, нічого не робимо
        if (head == null) {
            return;
        }

        // Якщо перший елемент має такий самий ключ, видаляємо його і оновлюємо посилання на голову бакета
        if (head.key == key || (key != null && head.key.equals(key))) {
            head = head.next;
            size--;
            return;
        }

        // Якщо перший елемент не має такого самого ключа, шукаємо елемент з таким ключем у бакеті
        Nodo<K, V> prev = head; // Попередній елемент
        Nodo<K, V> curr = head.next; // Поточний елемент

        while (curr != null) {
            // Якщо знайшли елемент з таким самим ключем, видаляємо його і оновлюємо посилання на наступний елемент
            if (curr.key == key || (key != null && curr.key.equals(key))) {
                prev.next = curr.next;
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        // Якщо не знайшли елемент з таким самим ключем, нічого не робимо
    }

    // Метод для очищення колекції
    public void clear() {
        // Проходимо по всіх бакетах і встановлюємо їх значення в null
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = null;
        }
        // Обнуляємо розмір колекції
        size = 0;
    }

    // Метод для отримання розміру колекції
    public int size() {
        return size;
    }

    // Метод для отримання значення за ключем
    public V get(K key) {
        int index = hash(key);  // Індекс бакета
        Nodo<K, V> head = buckets[index];  // Перший елемент бакета

        // Якщо бакет порожній, повертаємо null
        if (head == null) {
            return null;
        }

        // Якщо бакет не порожній, шукаємо елемент з таким самим ключем у бакеті
        Nodo<K, V> curr = head;  // Поточний елемент

        while (curr != null) {
            // Якщо знайшли елемент з таким самим ключем, повертаємо його значення
            if (curr.key == key || (key != null && curr.key.equals(key))) {
                return curr.value;
                ;
            }
            curr = curr.next;
        }
        // Якщо не знайшли елемент з таким самим ключем, повертаємо null
        return null;
    }

}
