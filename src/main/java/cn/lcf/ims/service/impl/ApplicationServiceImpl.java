package cn.lcf.ims.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cn.lcf.core.entity.Page;
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

    public Page<Application> searchApplication(final ApplicationCondition condition){ 
        org.springframework.data.domain.Page<Application> page 
        	=  this.applicationDao.findAll(this.buildSpecification(condition), new PageRequest(condition.getPageNum()-1,condition.getPageSize()));
        return condition.setPage(page);
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
    
    private Specification<Application> buildSpecification(final ApplicationCondition condition){
    	Specification<Application> spec = new Specification<Application>() {
			@Override
			public Predicate toPredicate(Root<Application> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(StringUtils.isNotBlank(condition.getName())){
					query.where(cb.equal(root.get("name").as(String.class),condition.getName()));
				}
				if(StringUtils.isNotBlank(condition.getBasePath())){
					query.where(cb.equal(root.get("basePath").as(String.class),condition.getName()));
				}
				if(StringUtils.isNotBlank(condition.getLikeName())){
					query.where(cb.like(root.get("name").as(String.class),"%"+ condition.getLikeName()+"%"));
				}
				if(StringUtils.isNotBlank(condition.getLikeBasePath())){
					query.where(cb.like(root.get("basePath").as(String.class), condition.getLikeBasePath()));
				}
				return null;
			}
		};
    		
    	return spec;
    	
    }

	@Override
	public Page<Application> searchApplicationExt(ApplicationCondition condition) {
		List<Application> list = this.applicationDao.searchApplication(condition);
		condition.setData(list);
		return condition;
	}
 
}