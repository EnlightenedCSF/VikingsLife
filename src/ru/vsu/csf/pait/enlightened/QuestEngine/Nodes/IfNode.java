package ru.vsu.csf.pait.enlightened.QuestEngine.Nodes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Scanner;

@XmlRootElement(name = "ifNode")
@XmlType(propOrder = {"yesBranch", "noBranch"})
public class IfNode extends AbsNode {

    private AbsNode yesBranch;
    private AbsNode noBranch;


    public AbsNode getNoBranch() {
        return noBranch;
    }

    @XmlElement(name = "no", nillable = true)
    public void setNoBranch(AbsNode noBranch) {
        this.noBranch = noBranch;
    }

    public AbsNode getYesBranch() {
        return yesBranch;
    }

    @XmlElement(name = "yes", nillable = true)
    public void setYesBranch(AbsNode yesBranch) {
        this.yesBranch = yesBranch;
    }

    @Override
    public void execute() {
        super.execute();

        Scanner sc = new Scanner(System.in);
        String s = sc.next().toLowerCase();
        if (s.equals("yes") || s.equals("да")){
            this.getYesBranch().execute();
        }
        else if (s.equals("no") || s.equals("нет")) {
            this.getNoBranch().execute();
        }
        else
            throw new IllegalArgumentException("Ответ должен быть \"да/нет\" или \"yes/no\"!");
    }


    public void addYesNode(AbsNode node) {
        this.yesBranch = node;
    }

    public void addNoBranch(AbsNode node) {
        this.noBranch = node;
    }
}
