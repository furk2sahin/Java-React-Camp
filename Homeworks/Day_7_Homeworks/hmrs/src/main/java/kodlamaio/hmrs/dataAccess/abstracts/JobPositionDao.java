package kodlamaio.hmrs.dataAccess.abstracts;

import kodlamaio.hmrs.model.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    JobPosition getByJobName(String jobName);
}
