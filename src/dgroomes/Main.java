package dgroomes;

import java.util.Iterator;
import java.util.List;

import static java.lang.System.out;

/**
 * Learning and experimenting with the Java Collections Framework.
 */
public class Main {

    public static void main(String[] args) {
        var messages = List.of("Hello", "there,", "world!");
        var iterator = new CountingIterator<>(messages.iterator());

        while (iterator.hasNext()) {
            var message = iterator.next();
            out.printf("%s message: '%s'%n", iterator, message);
        }
    }

    /**
     * An iterator that keeps track of how many elements have been visited by the iteration.
     * <p>
     * This is not thread safe.
     */
    static class CountingIterator<E> implements Iterator<E> {

        private int elementsVisited = 0;
        private final Iterator<E> inner;

        CountingIterator(Iterator<E> inner) {
            this.inner = inner;
        }

        @Override
        public boolean hasNext() {
            return inner.hasNext();
        }

        @Override
        public E next() {
            var next = inner.next();
            elementsVisited++;
            return next;
        }

        @Override
        public String toString() {
            return "CountingIterator{" +
                    "elementsVisited=" + elementsVisited +
                    '}';
        }
    }
}
