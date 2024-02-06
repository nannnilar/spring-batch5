package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class Knight implements Quest {
//    @Autowired
//    @QuestType(value = QuestType.Type.Yoyeyo)

    private Quest quest;
    private MyClass myClass;

     public Knight(@QuestType(value = QuestType.Type.Dragon) Quest quest,
                   @Nullable MyClass myClass) {
        this.quest = quest;
        this.myClass = myClass;
    }
    @Autowired
    public void printQuest(Collection<Quest> quests){
        /*quests.stream()
                .map(q -> q.getClass().getSimpleName())
                .forEach(System.out::println);*/
        for (Quest quest1:quests){
            System.out.println(quest1.getClass().getSimpleName());
        }
    }

    public String goQuest() {
        return quest.goQuest();
    }

}
