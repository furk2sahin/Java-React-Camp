package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.model.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getAll();
    JobPosition getByName(String name);
    JobPosition add(JobPosition jobPosition);
}
