package ru.vsu.csf.pait.enlightened.QuestEngine.Nodes;

import javax.xml.bind.annotation.*;
import java.util.Scanner;

@XmlRootElement(name = "ifNode")
@XmlType(propOrder = {"yesBranchID", "noBranchID"})
public class IfNode extends AbsNode {

    private Integer yesBranchID;
    private Integer noBranchID;

    public Integer getYesBranchID() {
        return yesBranchID;
    }

    @XmlElement(name = "yesID")
    public void setYesBranchID(Integer yesBranchID) {
        this.yesBranchID = yesBranchID;
    }

    public Integer getNoBranchID() {
        return noBranchID;
    }

    @XmlElement(name = "noID")
    public void setNoBranchID(Integer noBranchID) {
        this.noBranchID = noBranchID;
    }



    public IfNode() {
        this.setId(getNewId());
    }

    public IfNode(String desc) {
        this.setDescription(desc);
        this.setId(getNewId());
    }


    @Override
    public Integer execute() {
        super.execute();

        Scanner sc = new Scanner(System.in);
        String s = sc.next().toLowerCase();
        if (s.equals("yes") || s.equals("да")){
            return this.getYesBranchID();
        }
        else if (s.equals("no") || s.equals("нет")) {
            return this.getNoBranchID();

        }
        else
            throw new IllegalArgumentException("Ответ должен быть \"да/нет\" или \"yes/no\"!");
    }
}
