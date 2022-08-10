package List;

import java.util.Iterator;

public interface MyIteratorInterface<E> extends Iterator<E> {
    void insertBefore (E e);
    public E nextE();

}
