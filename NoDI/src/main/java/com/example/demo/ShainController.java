package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShainController {

    @RequestMapping("/input")
    public String index(ShainForm shainform) {
        // "index.html" テンプレートを返す
        return "index.html";
    }

    @RequestMapping("/output")
      public String result(@Validated ShainForm shainForm, BindingResult bindingResult, Model model) {
    	
    	//errorがあったら"index.html"に戻す
    	if(bindingResult.hasErrors()) {
    		return "index.html";
    	}
    	
        // パラメータ「number」を取得し、「name」を設定する
        String name = "コントローラー太郎";
        model.addAttribute("number", shainForm.getNumber()); // モデルに「number」を追加
        model.addAttribute("name", name);     // モデルに「name」を追加
        // "output.html" テンプレートを返す
        return "output.html";
    }
}
