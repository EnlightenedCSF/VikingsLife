package ru.vsu.csf.pait.enlightened.QuestEngine.Nodes;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "endNode")
public class EndingNode extends AbsNode {

    public EndingNode() {
        this.setId(getNewId());
    }

    public EndingNode(String description) {
        this.setDescription(description);
        this.setId(getNewId());
    }

    @Override
    public Integer execute() {
        super.execute();

        System.out.println("Жизнь великолепного викинга закончилась.");
        return -1;
    }
}
