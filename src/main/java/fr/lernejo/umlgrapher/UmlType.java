package fr.lernejo.umlgrapher;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class UmlType {

    private final Set<Class> types = new TreeSet<>(Comparator
        .<Class, String>comparing(Class::getSimpleName)
        .thenComparing(Class::getPackageName));

      private void getAllClass(Class[] allClasses) {
        for (Class cl : allClasses) {
            recursionSearch(cl);
        }
    }


    public UmlType(Class[] allClasses) {
        this.getAllClass(allClasses);
    }

    

    private void recursionSearch(Class cl) {
        Class superClass = cl.getSuperclass();
        if (superClass != null
            && !superClass.getSimpleName().equals("Object"))
            recursionSearch(superClass);

        for (Class inter : cl.getInterfaces()) {
            recursionSearch(inter);
        }

        types.add(cl);
    }

    public Set<Class> getListOfClass() {
        return this.types;
    }
}
