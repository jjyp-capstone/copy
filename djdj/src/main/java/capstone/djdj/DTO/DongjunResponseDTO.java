package capstone.djdj.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DongjunResponseDTO {
    private String keyword;
    private double weight;
    private int cluster;
}