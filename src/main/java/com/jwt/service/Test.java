package com.jwt.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.jwt.dao.EmployeeDAOImpl;
import com.jwt.model.Employee;

public class Test {

//	public static void main(String[] args) {
	public List<Employee> myMethod(String path) {
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
//			FileInputStream input = new FileInputStream(new File("C:\\Users\\Prabel_Oberoi\\Downloads\\TestExcel.xlsx"));
//			POIFSFileSystem fs = new POIFSFileSystem(input);
//			Workbook wb = WorkbookFactory.create(new File("C:\\Users\\Prabel_Oberoi\\Desktop\\TestExcel.xlsx"));
			System.out.println("PATH===>>>" + path);
			Workbook wb = WorkbookFactory.create(new File(path));
//			HSSFWorkbook wb = new HSSFWorkbook(fs);
			Sheet sheet = wb.getSheetAt(0);
			Row row;

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Employee employee = new Employee();
//				EmployeeDAOImpl employeeService = new EmployeeDAOImpl();
				row = sheet.getRow(i);

//				employee.setEmployeeName(String.valueOf(row.getCell(0).getRichStringCellValue()));
//				employee.setDesignation(String.valueOf(row.getCell(1).getRichStringCellValue()));
//				employee.setSalary((long) row.getCell(2).getNumericCellValue());
				
//				employee.setId(Integer.parseInt(String.valueOf(row.getCell(0).getNumericCellValue())));
//				employee.setId(29);
				employee.setName(String.valueOf(row.getCell(0).getRichStringCellValue()));
				employee.setEmail(String.valueOf(row.getCell(1).getRichStringCellValue()));
				employee.setAddress(String.valueOf(row.getCell(2).getRichStringCellValue()));
				employee.setTelephone(String.valueOf(Double.valueOf(row.getCell(3).getNumericCellValue()).intValue()));
				employee.setStd_id(String.valueOf(Double.valueOf(row.getCell(4).getNumericCellValue()).intValue()));
				System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getEmail() + " " + employee.getAddress() + " " + employee.getTelephone() + " " + employee.getStd_id());
//				employeeService.uploadEmployee(employee); // call to spring service layer
				employeeList.add(employee);
			}
		} catch (FileNotFoundException ec) {
			ec.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO: handle exception
		}
		return employeeList;
	}

}
