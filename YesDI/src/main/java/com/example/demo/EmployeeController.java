package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
	//
	private final EmployeeService employeeService;
	
	//EmployeeServiceのDI
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

    @RequestMapping("/input")
    public String index(EmployeeForm employeeForm) {
        // "index.html" テンプレートを返す
        return "index.html";
    }

    @RequestMapping("/output")
      public String result(@Validated EmployeeForm employeeForm, BindingResult bindingResult, Model model) {
    	
    	//errorがあったら"index.html"に戻す
    	if(bindingResult.hasErrors()) {
    		return "index.html";
    	}
    	
       //依存性がない場合だとこのnewする部分がないとエラーになる
//        EmployeeService employeeService = new EmployeeServiceImpl();

    	
        //サービス層から社員を検索
        String name = employeeService.findByNo(employeeForm.getNumber());

        model.addAttribute("number", employeeForm.getNumber()); // モデルに「number」を追加
        model.addAttribute("name", name);     // モデルに「name」を追加
        // "output.html" テンプレートを返す
        return "output.html";
    }
}
