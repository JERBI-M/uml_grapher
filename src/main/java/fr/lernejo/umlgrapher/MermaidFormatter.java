package fr.lernejo.umlgrapher;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MermaidFormatter {

  

     public String shape(InternalGraphRepresentation graphRepresentation) {
        return MermaidUmlType(graphRepresentation.getUmlType()
            .getListOfClass()) + MermaidUmlRelation(graphRepresentation.getUmlRelation()
            .getRelationsBetweenClass());
    }

      private String MermaidUmlType(Set<Class> allClasses) {
        String word = "classDiagram\n";
        for (Class classe : allClasses) {
            word += "class " + classe.getSimpleName();
            String fieldString = MermaidFieldRepresentation(classe);
            String methodString = MermaidMethodRepresentation(classe);
            boolean condition = !(fieldString + methodString).equals("") || Modifier.isInterface(classe.getModifiers());
            if (condition) syntax +=" {\n";
            if (Modifier.isInterface(classe.getModifiers())) {
                
		 word +=" <<interface>>\n;
		 condition = true;
            }
	    word += fieldString;
	    word += methodString;
	    if (condition) word +="}";
            word = word + "\n";
        }
        return word;
    }

    private String MermaidUmlRelation(List<String[]> link) {
        String word = "";

        for (String[] relation : link) {
            word = word + relation[0];
            if (relation[2].equals("implements"))
                word += " <|.. ";
            else word += " <|-- ";
            word += relation[1] + " : " + relation[2];
            word += "\n";
        }
        return word;
    }
}
