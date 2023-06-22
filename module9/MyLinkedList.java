package module9;

// Клас для представлення елемента списку
// Використовуємо generic тип E для даних
class Node<E> {
    // Поле для зберігання даних
    E data;
    // Посилання на попередній та наступний елементи
    Nodes<E> prev;
    Nodes<E> next;

    // Конструктор з параметром
    public Node(E data) {
        this.data = data;
    }
}

// Клас для представлення списку
// Використовуємо generic тип E для даних
public class MyLinkedList<E> {
    // Посилання на перший та останній елементи списку
    private Nodes<E> head;
    private Nodes<E> tail;
    // Розмір списку
    private int size;

    // Конструктор без параметрів
    public MyLinkedList() {
        // Створюємо порожній список
        head = null;
        tail = null;
        size = 0;
    }

    // Метод add, для додавання елемента в кінець списку
    public void add(E value) {
        // Створюємо новий вузол з даними
        Nodes<E> newNode = new Nodes<>(value);
        // Якщо список порожній, то новий вузол стає першим і останнім
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // Інакше, додаємо новий вузол в кінець списку
            // Встановлюємо посилання між останнім та новим вузлами
            tail.next = newNode;
            newNode.prev = tail;
            // Оновлюємо посилання на останній вузол
            tail = newNode;
        }
        // Збільшуємо розмір списку на одиницю
        size++;
    }

    // Метод remove, для видалення елемента за індексом
    public void remove(int index) {
        // Перевіряємо, чи індекс в межах розміру списку
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + "Size: " + size);
        }
        // Якщо список має один елемент, то просто очищуємо список
        if (size == 1) {
            clear();
            return;
        }
        // Якщо індекс дорівнює нулю, то видаляємо перший елемент
        if (index == 0) {
            // Оновлюємо посилання на перший елемент
            head = head.next;
            // Видаляємо посилання на попередній елемент у новому першому елементі
            head.prev = null;
        } else if (index == size - 1) {
            // Якщо індекс дорівнює розміру списку мінус один, то видаляємо останній елемент
            // Оновлюємо посилання на останній елемент
            tail = tail.prev;
            // Видаляємо посилання на наступний елемент у новому останньому елементі
            tail.next = null;
        } else {
            // Інакше, видаляємо елемент у середині списку
            // Знаходимо вузол за індексом
            Nodes<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            // Встановлюємо посилання між попереднім та наступним вузлами, щоб пропустити поточний
            current.prev.next = current.next;
            current.next.prev = current.prev;
            // Видаляємо посилання на попередній та наступний вузли у поточному
            current.next = null;
            current.prev = null;
        }
        // Зменшуємо розмір списку на одиницю
        size--;
    }

    // Метод clear,  для очищення списку
    public void clear() {
        // Видаляємо посилання на перший та останній елементи
        head = null;
        tail = null;
        // Встановлюємо розмір списку рівним нулю
        size = 0;
    }

    // Метод size, для отримання розміру списку
    public int size() {
        return size;
    }

    // Метод get, для отримання елемента за індексом
    public E get(int index) {
        // Перевіряємо, чи індекс в межах розміру списку
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // Знаходимо вузол за індексом, перебираючи список з початку або з кінця, залежно від того, що ближче
        Nodes<E> current = null;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        // Повертаємо дані з вузла
        return current.data;
    }
}

