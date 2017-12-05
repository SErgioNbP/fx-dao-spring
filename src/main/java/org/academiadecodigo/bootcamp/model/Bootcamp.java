package org.academiadecodigo.bootcamp.model;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="bootcamp")
public class Bootcamp extends AbstractModel {

    private String location;
    private Date start;
    private Date end;

    @OneToMany(
            mappedBy = "bootcamp",
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<CodeCadet> cadets = new HashSet<>();

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Set<CodeCadet> getCadets() {
        return cadets;
    }

    public void setCadets(Set<CodeCadet> cadets) {
        this.cadets = cadets;
    }

    // utility method to update both sides of the association
    public void addCadet(CodeCadet cadet) {
        this.cadets.add(cadet);
        cadet.setBootcamp(this);
    }

    // utility method to update both sides of the association
    public void removeCadet(CodeCadet cadet) {
        this.cadets.remove(cadet);
        cadet.setBootcamp(null);
    }

    public boolean hasCadet(CodeCadet cadet) {
        return this.cadets.contains(cadet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bootcamp bootcamp = (Bootcamp) o;

        if (location != null ? !location.equals(bootcamp.location) : bootcamp.location != null) return false;
        if (start != null ? !start.equals(bootcamp.start) : bootcamp.start != null) return false;
        if (end != null ? !end.equals(bootcamp.end) : bootcamp.end != null) return false;
        return cadets != null ? cadets.equals(bootcamp.cadets) : bootcamp.cadets == null;
    }

    @Override
    public int hashCode() {
        int result = location != null ? location.hashCode() : 0;
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (cadets != null ? cadets.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "location='" + location + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", cadets=" + cadets +
                '}' + super.toString();
    }
}


