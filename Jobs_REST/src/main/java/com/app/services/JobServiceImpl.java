package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.JobDTO;
import com.app.Entity.Jobs;
import com.app.ExceptionHandler.JobNotFoundException;
import com.app.Repository.JobRepository;
@Service
@Transactional
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobRepository jobRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public JobDTO addnewJob(JobDTO addJob) {
	Jobs job=mapper.map(addJob, Jobs.class);
		//return jobRepo.save(addJob);
	Jobs j=jobRepo.save(job);
		return mapper.map(j, JobDTO.class);
	}

	@Override
	
	public List<JobDTO> getAllJobs() {
		return jobRepo.findAll().stream().map(e->mapper.map(e,JobDTO.class )).collect(Collectors.toList());		
	}

	@Override
	public JobDTO getJobByID(Long id) {
		return mapper.map(jobRepo.findById(id).orElseThrow(()-> new JobNotFoundException("Job Id Mismatch....")),JobDTO.class);
	}

	@Override
	public String updateJob(Long id, JobDTO jobdto) {
		String msg="job not found";
		if(jobRepo.existsById(id))
		{
			Jobs job=mapper.map(jobdto, Jobs.class);
			job.setId(id);
			jobRepo.save(job);
			msg="Update successfully";
		}
		return msg;
	
	}

	@Override
	public Jobs deleteJob(Long id) {
		
		Jobs job=jobRepo.findById(id).
				orElseThrow(()->new JobNotFoundException("Id not found"));
		jobRepo.deleteById(id);
		
		return job;
			
	}
	
	

}
