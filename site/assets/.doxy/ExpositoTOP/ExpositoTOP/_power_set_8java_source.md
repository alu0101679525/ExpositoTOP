

# File PowerSet.java

[**File List**](files.md) **>** [**es**](dir_f9b1e2a59d62d001356ff527358589e3.md) **>** [**ull**](dir_5e4a5b0330a43e454ff3ad9bcb612958.md) **>** [**esit**](dir_ff138097d92aca141cd969d7c10ce4fe.md) **>** [**utilities**](dir_5612c464522cebfe44601dfa3f1684ce.md) **>** [**PowerSet.java**](_power_set_8java.md)

[Go to the documentation of this file](_power_set_8java.md)


```Java
package main.java.es.ull.esit.utilities;

import java.util.BitSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class PowerSet<E> implements Iterator<Set<E>>, Iterable<Set<E>> {

    private E[] arr = null;
    private BitSet bset = null;
    private final Set<E> originalSet;

    @SuppressWarnings("unchecked")
    public PowerSet(Set<E> set) {
        this.originalSet = set;
        this.arr = (E[]) set.toArray();
        this.bset = new BitSet(this.arr.length + 1);
    }

    @Override
    public boolean hasNext() {
        return !this.bset.get(this.arr.length);
    }

    @Override
    public Set<E> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Set<E> returnSet = new TreeSet<>();
        for (int i = 0; i < this.arr.length; i++) {
            if (this.bset.get(i)) {
                returnSet.add(this.arr[i]);
            }
        }
        for (int i = 0; i < this.bset.size(); i++) {
            if (!this.bset.get(i)) {
                this.bset.set(i);
                break;
            } else {
                this.bset.clear(i);
            }
        }
        return returnSet;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not Supported!");
    }

    @Override
    public Iterator<Set<E>> iterator() {
        return new PowerSet<>(this.originalSet);
    }
}
```


