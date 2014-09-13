package ru.vsu.csf.pait.enlightened.QuestEngine.Nodes;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Scanner;

@XmlRootElement(name = "node")
public class Node extends AbsNode {

    private AbsNode next;

    @XmlElementRef(name = "next")
    public AbsNode getNext() {
        return next;
    }

    public void setNext(AbsNode next) {
        this.next = next;
    }


    public Node() {

    }

    public Node(String description) {
        this.setDescription(description);
    }

    @Override
    public void execute() {
        super.execute();

        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        next.execute();
    }

    public void addNextNode(AbsNode next) {
        this.next = next;
    }
}
