package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Use to find relation between class
 */
public class UmlRelation {

    private final List<String[]> relations = new ArrayList<>();

    public UmlRelation(UmlType uType) {
        this.getAllRelation(uType);
    }

    public void getAllRelation(UmlType uType) {
        for (Class c : uType.getListOfClass()) {
            Class superClass = c.getSuperclass();
            if (superClass != null
                && !superClass.getSimpleName().equals("Object")) {
                relations.add(new String[] {superClass.getSimpleName(), c.getSimpleName(), "extends"});
            }
            for (Class inter : c.getInterfaces()) {
                String[] tab = new String[3];
                tab[0] = inter.getSimpleName();
                tab[1] = c.getSimpleName();
                if (!Modifier.isInterface(c.getModifiers()))
                    tab[2] = "implements";
                else tab[2] = "extends";
                relations.add(tab);
            }
        }
    }

    public List<String[]> getRelationsBetweenClass() {
        return relations;
    }
}
