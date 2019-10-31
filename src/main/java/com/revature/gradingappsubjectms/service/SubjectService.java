package com.revature.gradingappsubjectms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.gradingappsubjectms.dto.MessageConstant;
import com.revature.gradingappsubjectms.exception.ServiceException;
import com.revature.gradingappsubjectms.model.Subject;
import com.revature.gradingappsubjectms.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	SubjectRepository subjectrepository;
	
	public Optional<Subject> findbyId(int id) throws ServiceException{
		Optional<Subject> subjectList = subjectrepository.findById(id);
		if(subjectList==null) {
			throw new ServiceException(MessageConstant.INVALID);
		}
		return subjectList;
	}
	
	public List<Subject> subject() throws ServiceException {
        List<Subject> list = null;
        list = subjectrepository.findAll();
        if (list == null)  {
            throw new ServiceException(MessageConstant.INVALID);
        }
        return list;
    }

}
