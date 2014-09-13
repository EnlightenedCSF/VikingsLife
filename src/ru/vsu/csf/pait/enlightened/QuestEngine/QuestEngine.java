package ru.vsu.csf.pait.enlightened.QuestEngine;

import ru.vsu.csf.pait.enlightened.QuestEngine.Nodes.AbsNode;
import ru.vsu.csf.pait.enlightened.QuestEngine.Nodes.EndingNode;
import ru.vsu.csf.pait.enlightened.QuestEngine.Nodes.IfNode;
import ru.vsu.csf.pait.enlightened.QuestEngine.Nodes.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;


public class QuestEngine {

    private Quest quest;

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public QuestEngine() {
        quest = new Quest();
    }

    public void startAdventure(){
        quest.start();
    }

    /*public void init() {
        Node node = new Node("Вы просыпаетесь на костях поверженных врагов.");
        quest.addNode(node);

        quest.setStartID(node.getId());

        IfNode node1 = new IfNode("Поискать секиру?");
        node.addNextNode(node1.getId());
        quest.addNode(node1);

        Node yesNode = new Node("Вы вынимаете секиру из близлежащего бездыханного тела.");
        EndingNode nopeNode = new EndingNode("Дальнейшее.");

        node1.setYesBranchID(yesNode.getId());
        node1.setNoBranchID(nopeNode.getId());
        yesNode.addNextNode(nopeNode.getId());
        quest.addNode(yesNode);
        quest.addNode(nopeNode);
    }*/


    /*public void writeQuestToXML() {
        try {
            File file = new File("out.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Quest.class); //, AbsNode.class, Node.class, IfNode.class, EndingNode.class);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(quest, file);
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }*/

    public void loadQuestFromXML(String path) {
        try {
            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Quest.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            quest = (Quest) unmarshaller.unmarshal(file);
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
