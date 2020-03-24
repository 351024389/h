package com.briup.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Customer;
import com.briup.demo.service.ICustomerService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 35102
 *
 */
@RestController
@Api(description = "管理用户信息的相关接口")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerservice;
	@PostMapping("/addCustomer")
	@ApiOperation("新增用户")
	public Message<Customer> addCustomer(Customer customer){
		
		try {
			
			customerservice.save(customer);
			return MessageUtil.success();
		}
		catch(CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE,"系统错误"+e.getMessage());
		}
		
	}

}