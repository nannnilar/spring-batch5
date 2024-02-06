package com.example.divisiontownshipreactive;

import com.example.divisiontownshipreactive.entity.Township;
import com.example.divisiontownshipreactive.repo.DivisionRepo;
import com.example.divisiontownshipreactive.entity.Division;
import com.example.divisiontownshipreactive.repo.TownshipRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class DivisionTownshipReactiveApplication {
    private final DivisionRepo divisionRepo;
    private final TownshipRepo townshipRepo;

    @Bean @Transactional
    public ApplicationRunner runner(){
        return r -> {
            List.of(
                    new Division("Yangon","South"),
                    new Division("Mandalay","Middle"),
                    new Division("Pago","South")
            ).forEach(divisionRepo::save);
            List.of(
                    new Township("Hlaing"),
                    new Township("Taungnoo"),
                    new Township("Pagan")
            ).forEach(townshipRepo::save);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DivisionTownshipReactiveApplication.class, args);
    }

}
