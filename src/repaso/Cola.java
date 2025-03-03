package repaso;

import java.io.*;
import java.util.LinkedList;

public class Cola<T> {

    private LinkedList<T> colaDinamica;

    public Cola() {
        colaDinamica = new LinkedList<>();
    }

    public T remove() {
        if (colaDinamica.isEmpty()) {
            throw new RuntimeException("La cola esta vacia");
        }
        return colaDinamica.removeFirst();
    }

    public void add(T elemento) {
        colaDinamica.addLast(elemento);
    }

    @Override
    public String toString() {
        return colaDinamica.toString();
    }

    public void print() {
        for (int i = 0; i < colaDinamica.size(); i++) {
            System.out.print(colaDinamica.get(i) + " ");
        }
    }


    public boolean removeElementAtIndex(int index) {
        if (!(colaDinamica.contains(index))) {
            return false;
        }
        colaDinamica.remove(index);
        return true;

    }

    public void copyQueue(Cola<T> cola, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(cola);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }



}
