package ru.vsu.csf.pait.enlightened.QuestEngine.Nodes;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "endNode")
public class EndingNode extends AbsNode {

    public EndingNode() {

    }

    public EndingNode(String description) {
        this.setDescription(description);
    }

    @Override
    public void execute() {
        super.execute();

        System.out.println("Жизнь великолепного викинга закончилась.");
    }
}
