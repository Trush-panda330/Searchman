package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShainController {

    @RequestMapping("/input")
    public String index() {
        // "index.html" テンプレートを返す
        return "index.html";
    }

    @RequestMapping("/output")
    public String result(ShainForm shainForm, Model model) {
        // パラメータ「number」を取得し、「name」を設定する
        String name = "コントローラー太郎";
        model.addAttribute("number", shainForm.getNumber()); // モデルに「number」を追加
        model.addAttribute("name", name);     // モデルに「name」を追加
        // "output.html" テンプレートを返す
        return "output.html";
    }
}
