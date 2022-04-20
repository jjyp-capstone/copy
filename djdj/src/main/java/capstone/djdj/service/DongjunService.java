package capstone.djdj.service;


import capstone.djdj.DTO.DongjunResponseDTO;
import capstone.djdj.Repository.DongjunRepository;
import capstone.djdj.domain.dongjun;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DongjunService {
    private final DongjunRepository dongjunRepository;

    public List<dongjun> getAllData() {
        //List<DongjunResponseDTO> dongjunResponseDTOList = dongjunRepository.findallData();
        System.out.println("service start");
        List<dongjun> dongjunList = dongjunRepository.findAll();
        System.out.println("return success");
        return dongjunList;
    }
}
