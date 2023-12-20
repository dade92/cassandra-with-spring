package domain;

import java.util.Set;

public record Vet(
    String name,
    String surname,
    Set<String>specialties
){}
