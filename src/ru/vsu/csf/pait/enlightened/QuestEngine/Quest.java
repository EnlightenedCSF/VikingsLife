package ru.vsu.csf.pait.enlightened.QuestEngine;

import ru.vsu.csf.pait.enlightened.QuestEngine.Nodes.AbsNode;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "quest")
@XmlSeeAlso({AbsNode.class})
public class Quest {


    private ArrayList<AbsNode> nodes;

    private Integer startID;


    @XmlElementWrapper(name = "nodes")
    @XmlElementRef
    public ArrayList<AbsNode> getNodes() {
        return nodes;
    }


    @XmlElement
    public Integer getStartID() {
        return startID;
    }

    public void setStartID(Integer startID) {
        this.startID = startID;
    }


    public Quest() {
        nodes = new ArrayList<AbsNode>();
    }

    public void addNode(AbsNode node) {
        nodes.add(node);
    }

    public void start() {
        Integer newId = startID;
        do {
            int index = 0;
            for (int i = 0; i < nodes.size(); i++) {
                if (nodes.get(i).getId().equals(newId))
                {
                    index = i;
                    break;
                }
            }

            newId = nodes.get(index).execute();
        }
        while (newId != -1);
    }
}
