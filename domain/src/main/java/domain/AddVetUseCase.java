package domain;

public class AddVetUseCase {

    private final VetRepository vetRepository;

    public AddVetUseCase(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public void add(Vet vet) {
        vetRepository.add(vet);
    }

}
