package ru.vsu.csf.pait.enlightened;

import ru.vsu.csf.pait.enlightened.QuestEngine.QuestEngine;

public class Main {

    public static void main(String[] args) {

        QuestEngine engine = new QuestEngine();
        engine.init();
        engine.writeQuestToXML();

        engine.loadQuestFromXML("out.xml");
        engine.startAdventure();
    }
}
