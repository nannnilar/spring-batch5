package org.example;

import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component @QuestType(value = QuestType.Type.Yoyeyo)
public class SingYoYeYoQuest implements Quest, PriorityOrdered {
    public String goQuest() {
        return "Knight sings yo ye yo happily.";
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
