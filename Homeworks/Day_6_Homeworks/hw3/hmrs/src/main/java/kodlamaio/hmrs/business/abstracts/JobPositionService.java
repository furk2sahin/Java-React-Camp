package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.model.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getAll();
}
