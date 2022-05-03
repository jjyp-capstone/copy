package capstone.djdj.controller;

import capstone.djdj.service.DongjunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@RequiredArgsConstructor
//@RestController
@Controller
public class DongjunController {
    /** 
    private final DongjunService dongjunService;

    @GetMapping("/data")
    public List<dongjun> showdata(){
        System.out.println("controller start");
        return dongjunService.getAllData();
    }
*/

    @Autowired
    private DongjunService dongjunService;

    @GetMapping("/demo")
    public String demoList(Model model){

        model.addAttribute("list", dongjunService.dongjunlist());
        return"demo_show";
    }


}
