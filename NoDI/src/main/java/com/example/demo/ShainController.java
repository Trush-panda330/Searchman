package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShainController {

    @RequestMapping("/input")
    public String index() {
        // "index.html" テンプレートを返す
        return "index.html";
    }

    @RequestMapping("/output")
    public String result(@RequestParam("number") String number, Model model) {
        // パラメータ「number」を取得し、「name」を設定する
        String name = "コントローラー太郎";
        model.addAttribute("number", number); // モデルに「number」を追加
        model.addAttribute("name", name);     // モデルに「name」を追加
        // "output.html" テンプレートを返す
        return "output.html";
    }
}
