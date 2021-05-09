package kodlamaio.hmrs.dataAccess.abstracts;

import kodlamaio.hmrs.model.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
}
