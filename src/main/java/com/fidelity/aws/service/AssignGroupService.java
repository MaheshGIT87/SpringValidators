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
public interface AssignGroupService {
	
	public void assignGroup(Map<String, Object> values);
	
}
