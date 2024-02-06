package org.example;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component @QuestType(value = QuestType.Type.Matrimony)
public class GreatMatrimonyQuest implements Quest, Ordered {

    public String goQuest() {
        return "Knight and Belle are happily ever together.";
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
