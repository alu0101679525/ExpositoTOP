

# File TOPTWRoute.java

[**File List**](files.md) **>** [**java**](dir_fd3f6763802dee1ad875f6c80eac0bda.md) **>** [**top**](dir_6ff67e08b8bc917d9697c3f221534daa.md) **>** [**TOPTWRoute.java**](_t_o_p_t_w_route_8java.md)

[Go to the documentation of this file](_t_o_p_t_w_route_8java.md)


```Java
package main.java.top;

public class TOPTWRoute {
    int predecessor;
    int succesor;
    int id;
    
    TOPTWRoute() {
        
    }
    
    TOPTWRoute(int pre, int succ, int id) {
        this.predecessor = pre;
        this.succesor = succ;
        this.id = id;
    }
    
    public int getPredeccesor() {
        return this.predecessor;
    }
    
    public int getSuccesor() {
        return this.succesor;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setPredeccesor(int pre) {
        this.predecessor = pre;
    }
    
    public void setSuccesor(int suc) {
        this.succesor = suc;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
```


