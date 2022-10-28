package fr.lernejo.umlgrapher;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UmlRelation {

    private final List<String[]> relations = new ArrayList<>();

    public UmlRelation(UmlType umltype) {
        this.getAllRelation(umltype);
    }

    public void getAllRelation(UmlType umltype) {
        for (Class cl : umltype.getListOfClass()) {
            Class superClass = cl.getSuperclass();
            if (superClass != null
                && !superClass.getSimpleName().equals("Object")) {
                relations.add(fillTab(superClass.getSimpleName(),
					cl.getSimpleName(),"extends"));
            }
            for (Class inter : cl.getInterfaces()) {
                relations.add(fillTab(inter.getSimpleName(),
					cl.getSimpleName(),
					!Modifier.isInterface(cl.getModifiers()) ? "implements" : "extends"));

            }
        }
    }


     private String[] fillTab(String tab0, String tab1, String tab2) {
        String[] tab = new String[3];
        tab[0] = tab0;
        tab[1] = tab1;
        tab[2] = tab2;
        return tab;
    }

    public List<String[]> getRelationsBetweenClass() {
        return relations;
    }
}
