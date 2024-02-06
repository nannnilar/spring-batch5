package org.example.demo.framework.application.view;

import org.example.demo.framework.model.Model;
import org.example.demo.framework.view.View;

public class IndexView implements View {
    @Override
    public String render(Model model) {
        return """
                <h1>Index View For My Servlet  Framework</h1>
                <ul><a href="/square?num=5">/square?num=5</a></ul>
                <ul><a href="/addnumber?num1=3&num2=6">/addnumber?num1=3&num2=6</a></ul>
  
                """;
    }
}
