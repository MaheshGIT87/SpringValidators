/**
 * 
 */
package com.fidelity.aws.service;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @author kiran
 *
 */
@Service
public class AssignGroupServiceImpl implements AssignGroupService {

	/* (non-Javadoc)
	 * @see com.fidelity.aws.service.AssignGroup#assignGroup(java.util.Map)
	 */
	@Override
	public void assignGroup(Map<String, Object> values) {
		
		System.out.println("can write your business logic here for request value:"+values);
	}

}
