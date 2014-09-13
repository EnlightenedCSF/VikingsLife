package ru.vsu.csf.pait.enlightened.QuestEngine.Nodes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "node")
public abstract class AbsNode {

    private String description;

    public String getDescription() {
        return description;
    }

    @XmlElement(name = "desc")
    public void setDescription(String description) {
        this.description = description;
    }

    public  void execute(){
        System.out.println(this.getDescription());
    }
}
