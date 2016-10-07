package main.java.com.uche.loanapplication.domain;

/**
 * Created by uuchey  on 10/6/2016.
 */
public class LoanRequestId implements Comparable<LoanRequestId>{
    private Integer id;

    private LoanRequestId(){}
    public LoanRequestId(Integer id){
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(LoanRequestId o) {
        return this.getId().compareTo(o.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanRequestId that = (LoanRequestId) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "LoanRequestId{" +
                "id=" + id +
                '}';
    }
}
