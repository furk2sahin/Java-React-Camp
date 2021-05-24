package kodlamaio.hmrs.business.concretes;

import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hmrs.model.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao){
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public List<JobPosition> getAll() {
        return jobPositionDao.findAll();
    }

    @Override
    public JobPosition add(JobPosition jobPosition) {
        return jobPositionDao.save(jobPosition);
    }

    @Override
    public JobPosition getByName(String name) {
        return jobPositionDao.getByJobName(name);
    }
}
