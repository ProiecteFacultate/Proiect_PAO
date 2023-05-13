package proiect.models.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public class AbstractEntity {
    private UUID id;
    private LocalDateTime creationDateTime;
    private LocalDateTime updateDateTime;
    private LocalDateTime deleteDateTime;
}
