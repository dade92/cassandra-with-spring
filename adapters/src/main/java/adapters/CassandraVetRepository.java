package adapters;

import domain.Vet;
import domain.VetRepository;

import java.util.UUID;

public class CassandraVetRepository  implements VetRepository {

    private final DaoVetEntity daoVetEntity;

    public CassandraVetRepository(
        DaoVetEntity daoVetEntity
    ) {
        this.daoVetEntity = daoVetEntity;
    }

    @Override
    public void add(Vet vet) {
       daoVetEntity.save(toEntity(vet));
    }

    private static VetRecord toEntity(Vet vet) {
        return new VetRecord(UUID.randomUUID(), vet.name(), vet.surname(), vet.specialties());
    }
}
