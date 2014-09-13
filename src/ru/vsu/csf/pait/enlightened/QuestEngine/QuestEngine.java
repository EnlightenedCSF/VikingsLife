package ru.vsu.csf.pait.enlightened.QuestEngine;

import com.sun.jmx.remote.internal.Unmarshal;
import ru.vsu.csf.pait.enlightened.QuestEngine.Nodes.AbsNode;
import ru.vsu.csf.pait.enlightened.QuestEngine.Nodes.EndingNode;
import ru.vsu.csf.pait.enlightened.QuestEngine.Nodes.IfNode;
import ru.vsu.csf.pait.enlightened.QuestEngine.Nodes.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class QuestEngine {

    private AbsNode start;

    public AbsNode getStart() {
        return start;
    }

    public void setStart(AbsNode start) {
        this.start = start;
    }


    public void startAdventure(){
        this.getStart().execute();
    }


    public void init() {
        Node node = new Node("Вы просыпаетесь на костях поверженных врагов.");

        IfNode node1 = new IfNode();
        node1.setDescription("Поискать секиру?");

        Node yesNode = new Node("Вы вынимаете секиру из близлежащего бездыханного тела.");
        Node nopeNode = new Node("Дальнейшее.");
        yesNode.setNext(nopeNode);

        node1.setYesBranch(yesNode);
        node1.setNoBranch(nopeNode);

        node.setNext(node1);

        this.start = node;
    }

    public void writeQuestToXML() {
        try {
            File file = new File("out.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(AbsNode.class, Node.class, EndingNode.class, IfNode.class);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(this.start, file);
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void loadQuestFromXML(String path) {
        try {
            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(AbsNode.class, Node.class, EndingNode.class, IfNode.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            start = (AbsNode) unmarshaller.unmarshal(file);
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
