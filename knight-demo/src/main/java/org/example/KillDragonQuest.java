package org.example;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component @QuestType(value = QuestType.Type.Dragon)
public class KillDragonQuest implements  Quest, Ordered {
    public String goQuest() {
        return "Knight kills the dragon.";
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
