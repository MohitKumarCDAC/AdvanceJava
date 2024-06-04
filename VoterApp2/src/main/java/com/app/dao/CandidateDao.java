package com.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.entities.Candidate;

public interface CandidateDao {
//display all details from db
	List<Candidate> getCandidateDetails() throws SQLException;
	//add a method to increment votes
	String incrementCandidatevote(int candidateid) throws SQLException;
	//display data whose votes are max
	List<Candidate> getMaxVotes()throws SQLException;
	//display list maxVotes in specific party
	List<Candidate> getmaxVotesOfParty()throws SQLException;
}
