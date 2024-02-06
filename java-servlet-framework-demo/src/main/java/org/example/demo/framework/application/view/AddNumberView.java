package org.example.demo.framework.application.view;

import org.example.demo.framework.model.Model;
import org.example.demo.framework.view.View;

public class AddNumberView implements View {
    @Override
    public String render(Model model) {
        String num1 = model.get("num1");
        String num2 = model.get("num2");
        String result = model.get("result");
        return String.format(
               " %s + %s = [%s]",
                num1,num2,result);
    }
}
