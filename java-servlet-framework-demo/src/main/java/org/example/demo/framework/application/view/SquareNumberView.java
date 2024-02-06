package org.example.demo.framework.application.view;

import org.example.demo.framework.model.Model;
import org.example.demo.framework.view.View;

public class SquareNumberView implements View {
    @Override
    public String render(Model model) {
        String num = model.get("num");
        String result = model.get("result");
        return String.format("%s square number is :: [%s]",num,result);
    }
}
