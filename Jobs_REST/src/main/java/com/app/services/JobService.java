package com.app.services;



import java.util.List;

import com.app.DTO.JobDTO;
import com.app.Entity.Jobs;

public interface JobService {
   JobDTO addnewJob(JobDTO addJob);
   List<JobDTO> getAllJobs();
   JobDTO getJobByID(Long id);
   String updateJob(Long id,JobDTO jobdto);
   Jobs deleteJob(Long id);
}
