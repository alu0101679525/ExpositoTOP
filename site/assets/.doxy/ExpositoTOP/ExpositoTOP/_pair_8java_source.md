

# File Pair.java

[**File List**](files.md) **>** [**es**](dir_f9b1e2a59d62d001356ff527358589e3.md) **>** [**ull**](dir_5e4a5b0330a43e454ff3ad9bcb612958.md) **>** [**esit**](dir_ff138097d92aca141cd969d7c10ce4fe.md) **>** [**utils**](dir_1d50f258775204ffcd31c17842ee0718.md) **>** [**Pair.java**](_pair_8java.md)

[Go to the documentation of this file](_pair_8java.md)


```Java
package main.java.es.ull.esit.utils;
import java.util.Objects;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }

    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }

    public static <A, B> Pair <A, B> create(A a, B b) {
        return new Pair<A, B>(a, b);
    }
}
```


