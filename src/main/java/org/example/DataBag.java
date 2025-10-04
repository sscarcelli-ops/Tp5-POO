package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException; // Una excepción estándar para el remove

public class DataBag<T> {
    private final int maxSize;
    private final List<T> elements;

    public DataBag(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("El tamaño máximo debe ser mayor que cero.");
        }
        this.maxSize = maxSize;
        this.elements = new ArrayList<>(maxSize);
    }

    public boolean isFull() {
        return elements.size() >= maxSize;
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void add(T element) {
        if (isFull()) {
            throw new FullDataBagException("La bolsa de datos está llena. No se puede agregar '" + element + "'.");
        }
        elements.add(element);
    }

    public T remove() {
        if (isEmpty()) {
            throw new EmptyDataBagException("La bolsa de datos está vacía. No hay elementos para remover.");
        }
        return elements.remove(elements.size() - 1);
    }

    // Método para ver los elementos en la bolsa (opcional, para el ejemplo interactivo)
    public void printElements() {
        if (isEmpty()) {
            System.out.println("La bolsa está vacía.");
        } else {
            System.out.println("Elementos en la bolsa: " + elements);
        }
    }
}