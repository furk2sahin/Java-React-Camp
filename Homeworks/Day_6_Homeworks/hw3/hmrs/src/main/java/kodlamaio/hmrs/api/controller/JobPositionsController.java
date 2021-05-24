package kodlamaio.hmrs.api.controller;

import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.model.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-positions")
public class JobPositionsController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService){
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public List<JobPosition> getAll(){
        return jobPositionService.getAll();
    }

    @GetMapping("/getbyjobname")
    public JobPosition getAll(@RequestParam("jobName") String jobName){
        return jobPositionService.getByName(jobName);
    }

    @PostMapping("/add-job-position")
    public JobPosition add(@RequestBody JobPosition jobPosition){
        return jobPositionService.add(jobPosition);
    }
}
