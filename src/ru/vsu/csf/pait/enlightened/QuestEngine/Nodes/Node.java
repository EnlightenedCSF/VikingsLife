package ru.vsu.csf.pait.enlightened.QuestEngine.Nodes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Scanner;


@XmlRootElement(name = "node")
public class Node extends AbsNode {

    private Integer nextNodeID;

    @XmlElement(name = "nextId")
    public Integer getNextNodeID() {
        return nextNodeID;
    }

    public void setNextNodeID(Integer nextNodeID) {
        this.nextNodeID = nextNodeID;
    }

    public Node() {
        this.setId(getNewId());
    }

    public Node(String description) {
        this.setDescription(description);
        this.setId(getNewId());
    }

    @Override
    public Integer execute() {
        super.execute();

        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        return this.getNextNodeID();
    }

    public void addNextNode(Integer id) {
        this.nextNodeID = id;
    }
}
