package adapters;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Vet {

    private String id;

    private String name;

    private String surname;

    private List<String> specialties;

    public Vet(String id, String name, String surname, List<String> specialties) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.specialties = specialties;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
    }
}
