package com.revature.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.DataService;

public class DispatcherUtil {

	private DataService ds = new DataService();
	private ObjectMapper om = new ObjectMapper();

	public String processGet(String entity, String get, String username) {
		try {
			if (entity.equals("employees")) {
				if (get.equals("forManager")) {
					return om.writeValueAsString(ds.allEmployeesForManager(username));
				}
			}else if (entity.equals("reimbursement")) {
				if (get.equals("image")) {
					return (ds.getImageForRequest(0));
				}
			}
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "error";
	}
}
