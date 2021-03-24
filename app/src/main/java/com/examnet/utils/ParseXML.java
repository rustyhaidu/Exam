package com.examnet.utils;

import android.content.Context;

import com.examnet.model.Examen;
import com.examnet.model.Intrebare;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ParseXML {
    public static Examen getExamen(Context context){
        Examen examen = new Examen();
        try {
            InputStream is = context.getAssets().open("examene.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            Element element=doc.getDocumentElement();
            element.normalize();

            NodeList nList = doc.getElementsByTagName("intrebare");

            for (int i = 0; i < nList.getLength(); i++) {

                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element2 = (Element) node;

                    Intrebare intrebare = new Intrebare();
                    String enunt = getValue("enunt", element2);
                    String raspuns = getValue("raspuns", element2);

                    intrebare.setEnunt(enunt);
                    intrebare.setRaspuns(raspuns);

                    String varianta1 = getValue("varianta", element2,0);
                    String varianta2 = getValue("varianta", element2,1);
                    String varianta3 = getValue("varianta", element2,2);

                    intrebare.getVarianteRaspuns().add(varianta1);
                    intrebare.getVarianteRaspuns().add(varianta2);
                    intrebare.getVarianteRaspuns().add(varianta3);

                    examen.getIntrebari().add(intrebare);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return examen;
    }

    private static String getValue(String tag, Element element) {
        return getValue(tag, element, 0);
    }

    private static String getValue(String tag, Element element,int index) {
        NodeList nodeList = element.getElementsByTagName(tag).item(index).getChildNodes();
        Node node = nodeList.item(0);
        String nodeValue = node.getNodeValue();
        return nodeValue;
    }
}
