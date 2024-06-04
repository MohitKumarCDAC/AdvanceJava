package com.app.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.app.utils.DBUtils.*;

import com.app.entities.Candidate;

public class CandidateDaoImpl implements CandidateDao{
	private Connection con;
	private PreparedStatement pst1,pst2,pst3,pst4;
	
	//create a constructor
	public CandidateDaoImpl() throws SQLException{
		//use connection method 
		con=getConnection();
		pst1=con.prepareStatement("select * from candidates");
		pst2=con.prepareStatement("update candidates set votes=votes+1 where id=?");
		pst3=con.prepareStatement("select * from candidates order by votes desc limit 2");
		pst4=con.prepareStatement("SELECT party, SUM(votes) as total_votes from candidates group by party ORDER BY total_votes DESC;");
				
		System.out.println("Candidate Dao Created");
	}

	@Override
	public List<Candidate> getCandidateDetails() throws SQLException {
		List<Candidate> candidatelist=new ArrayList<Candidate>();
		try(ResultSet rs=pst1.executeQuery()){
			while(rs.next()) {
				candidatelist.add(new Candidate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		}
		return candidatelist;
	}

	@Override
	public String incrementCandidatevote(int candidateid) throws SQLException {
		//setIn parameters 
		pst2.setInt(1, candidateid);
		int updateCount=pst2.executeUpdate();
		if(updateCount==1)
			return "vote updated........";
		return "Vote Does not updates............";
		
	}
	// clean up
		public void cleanUp() throws SQLException {
			if (pst1 != null)
				pst1.close();
			if (pst2 != null)
				pst2.close();
			closeConnection();
			
		}

		@Override
		public List<Candidate> getMaxVotes() throws SQLException {
			List<Candidate> maxList=new ArrayList<Candidate>();
			try(ResultSet rs=pst3.executeQuery()){
				while(rs.next())
				{
					maxList.add(new Candidate(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getInt(4)));
				}
			}
			return maxList;
		}

		@Override
		public List<Candidate> getmaxVotesOfParty() throws SQLException {
			List<Candidate> candidateList=new ArrayList<Candidate>();
			try(ResultSet rs=pst4.executeQuery()){
				while(rs.next())
				{
					 String party = rs.getString("party");
	            int totalVotes = rs.getInt("total_votes"); // retrieve as total_votes
	            //System.out.println("Party: " + party + ", Total Votes: " + totalVotes);
	            Candidate candidate = new Candidate(); // create a new Candidate object
	            candidate.setParty(party);
	            candidate.setVotes(totalVotes); // set the votes
	            candidateList.add(candidate); // add to the list
	        }
	    }
	    return candidateList;
		}

}
