package webapp;

import domain.AddVetUseCase;
import domain.Vet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class VetController {

    private final AddVetUseCase addVetUseCase;

    public VetController(
        AddVetUseCase addVetUseCase
    ) {

        this.addVetUseCase = addVetUseCase;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add() {
        addVetUseCase.add(new Vet("Davide", "Botti", Set.of("Music", "Computers", "Stage diving")));
        return ResponseEntity.ok().build();
    }

}
