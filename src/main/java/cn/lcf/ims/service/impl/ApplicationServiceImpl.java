package cn.lcf.ims.service.impl;

import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import cn.lcf.core.Page;
import cn.lcf.core.exception.ServiceException;
import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.dao.ApplicationDao;
import cn.lcf.ims.entity.Application;
import cn.lcf.ims.service.ApplicationService;


@Service
public class ApplicationServiceImpl  implements ApplicationService{
    @Autowired
    private ApplicationDao  applicationDao;
    
    public void addApplication(Application  application){ 
        validate( application);

        applicationDao.save(application);
    }

    public Application  findApplicationById(Long id){ 
        validateId(id);

        Application application= applicationDao.findOne(id);
        
        return application;
    }

    public void updateApplication( Application application){ 
        validateId(application.getId());
        validate(application);
        
        applicationDao.save(application);
    }

    public Page<Application> searchApplication(ApplicationCondition applicationCondition){ 
        org.springframework.data.domain.Page<Application> page =  this.applicationDao.findAll(new Specification<Application>() {
			
			@Override
			public Predicate toPredicate(Root<Application> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return null;
			}
		}, new PageRequest(applicationCondition.getPageNum()-1,applicationCondition.getPageSize()));
        return applicationCondition.setPage(page);
    }

    private void validate(Application  application) {
        if ( application == null) {
            throw ServiceException.create("APPLICATION.IS.NULL");
        }
    }

    private void validateId(Long id) {
        if (id == null) {
            throw ServiceException.create("APPLICATION.ID.IS.NULL");
        }
    }
    
    private Specifications<Application> buildSpecifications(Map<String,Object> map){
    	return null;
    	
    }
 
}