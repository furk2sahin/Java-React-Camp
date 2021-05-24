package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.model.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    JobPosition getByJobName(String jobName);
}
