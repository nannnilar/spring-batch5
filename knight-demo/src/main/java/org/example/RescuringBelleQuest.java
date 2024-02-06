package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component @QuestType(value = QuestType.Type.Belle)
public class RescuringBelleQuest implements Quest, Ordered {

    public String goQuest() {
        return "Knight is going to recuse the belle.";
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
