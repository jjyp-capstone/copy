package capstone.djdj.controller;

import capstone.djdj.DTO.DongjunResponseDTO;
import capstone.djdj.domain.dongjun;
import capstone.djdj.service.DongjunService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DongjunController {

    private final DongjunService dongjunService;

    @GetMapping("/data")
    public List<dongjun> showdata(){
        System.out.println("controller start");
        return dongjunService.getAllData();
    }


}
