package queivan.service.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoilerFetchedDto {
    private UUID id;
    private String type;
    private String serialNumber;
    private Boolean locallyMounted;
    @JsonFormat(pattern="yyyy-MM-dd", timezone="Europe/Warsaw")
    private LocalDate installationDate;
    @JsonFormat(pattern="yyyy-MM-dd", timezone="Europe/Warsaw")
    private LocalDate inspectionDate;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NoteBoilerDto> notes;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PictureClientDto> pictures;
}