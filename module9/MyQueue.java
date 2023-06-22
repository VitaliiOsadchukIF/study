package module9;

import java.util.NoSuchElementException;

// Клас для представлення елемента черги
// Використовуємо generic тип E для даних
class Noda<E> {
    // Поле для зберігання даних
    E data;
    // Посилання на наступний елемент черги
    Noda<E> next;

    // Конструктор з параметром
    public Noda(E data) {

        this.data = data;
    }
}

// Клас для представлення черги
// Використовуємо generic тип E для даних

public class MyQueue<E> {
    // Посилання на перший та останній елементи черги
    private Noda<E> head;
    private Noda<E> tail;
    // Розмір черги
    private int size;

    public MyQueue() {
        // Створюємо порожню чергу
        head = null;
        tail = null;
        size = 0;
    }

    // Метод для додавання елемента в кінець черги
    public void add(E value) {
        // Створюємо новий вузол з даними
        Noda<E> newNoda = new Noda<>(value);
        // Якщо черга порожня, то новий вузол стає першим і останнім
        if (head == null) {
            head = newNoda;
            tail = newNoda;
        } else {
            // Інакше, додаємо новий вузол в кінець черги
            // Встановлюємо посилання між останнім та новим вузлами
            tail.next = newNoda;
            // Оновлюємо посилання на останній вузол
            tail = newNoda;
        }
        // Збільшуємо розмір черги на одиницю
        size++;

    }

    // Метод для очищення черги
    public void clear() {
        // Видаляємо посилання на перший та останній елементи
        head = null;
        tail = null;
        // Встановлюємо розмір черги рівним нулю
        size = 0;
    }

    // Метод для отримання розміру черги
    public int size() {
        return size;
    }

    // Метод для отримання першого елемента з черги
    public E peek() {
        // Перевіряємо, чи не порожня черга
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        // Повертаємо дані з першого вузла
        return head.data;
    }

    // Метод для отримання та видалення першого елемента з черги
    public E poll() {
        // Перевіряємо, чи не порожня черга
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        // Запам'ятовуємо дані з першого вузла
        E value = head.data;
        // Оновлюємо посилання на перший вузол
        head = head.next;
        // Якщо черга стала порожньою, то оновлюємо посилання на останній вузол
        if (head == null) {
            tail = null;
        }
        // Зменшуємо розмір черги на одиницю
        size--;
        // Повертаємо запам'ятовані дані
        return value;
    }
}
