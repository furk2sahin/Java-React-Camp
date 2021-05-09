package kodlamaio.hmrs.api.controller;

import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.model.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/job-positions")
public class JobPositionsController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService){
        this.jobPositionService = jobPositionService;
    }

    @RequestMapping("/getall")
    public List<JobPosition> getAll(){
        return jobPositionService.getAll();
    }
}
