package ru.vsu.csf.pait.enlightened.QuestEngine.Nodes;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "absNode")
@XmlSeeAlso({Node.class, IfNode.class, EndingNode.class})
public abstract class AbsNode {

    protected static int newId = 0;

    public static int getNewId() {
        return newId++;
    }

    private Integer id;
    private String description;

    public String getDescription() {
        return description;
    }

    @XmlElement(name = "desc")
    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getId() {
        return id;
    }

    @XmlElement(name = "id")
    public void setId(Integer id) {
        this.id = id;
    }

    public  Integer execute(){
        System.out.println(this.getDescription());
        return -1;
    }
}
