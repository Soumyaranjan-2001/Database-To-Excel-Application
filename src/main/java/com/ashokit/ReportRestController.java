package com.ashokit;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportRestController {
	
	@Autowired
	private ReportService reportservice;
	
	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/octet-stream");
		
		String headerkey = "Content-Disposition";
		String headerValue = "attachment;filename = courses.xls";
		
		response.setHeader(headerkey, headerValue);
		
		
		reportservice.generateExcel(response);
	}

}
