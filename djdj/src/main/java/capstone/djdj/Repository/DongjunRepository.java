package capstone.djdj.Repository;

import capstone.djdj.DTO.DongjunResponseDTO;
import capstone.djdj.domain.dongjun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DongjunRepository extends JpaRepository<dongjun, Long> {

    @Query(nativeQuery = true, value = "select * from dongjun")
    List<DongjunResponseDTO> findallData();
}
