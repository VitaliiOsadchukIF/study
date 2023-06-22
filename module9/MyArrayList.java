package module9;

public class MyArrayList<T> {
    // Масив для зберігання даних
    private T[] data;
    // Поточний розмір масиву
    private int capacity;
    // Кількість елементів в колекції
    private int size;

    // Конструктор без параметрів, який створює масив розміром 10
    public MyArrayList() {
        data = (T[]) new Object[10];
        capacity = 10;
        size = 0;
    }

    // Метод add, який додає елемент в кінець колекції
    public void add(T value) {

        if (size == capacity) {
            // Якщо так, то збільшуємо його розмір
            ensureCapacity();
        }
        // Додаємо елемент в кінець масиву
        data[size] = value;
        // Збільшуємо кількість елементів на одиницю
        size++;
    }

    // Метод, який збільшує розмір масиву у два рази
    public void ensureCapacity() {
        // Створюємо новий масив розміром у два рази більшим за поточний
        T[] newData = (T[]) new Object[capacity * 2];
        // Копiюємо всi елементи зi старого масиву до нового
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        // Призначаємо новий масив як data
        data = newData;
        // Збільшуємо поточний розмір масиву у два рази
        capacity = capacity * 2;
    }

    // Метод remove, який видаляє елемент за вказаним індексом
    public void remove(int index) {
        // Переміщаємо всі елементи, що стоять праворуч від видаленого, на одну позицію вліво
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
            // Зменшуємо кількість елементів на одиницю
            data[size] = null;
            size--;
        }
    }

    // Метод clear, який очищає колекцію
    public void clear() {
        // Створюємо новий порожній масив розміром 10
        T[] data = (T[]) new Object[10];
        capacity = 10;
        size = 0;
    }

    // Метод size, який повертає розмір колекції
    public int size() {
        return size;
    }

    // Метод get, який повертає елемент за вказаним індексом
    public T get(int index) {
        return data[index];
    }


}
