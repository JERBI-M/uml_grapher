package fr.lernejo.umlgrapher;

public class InternalGraphRepresentation {

    private final UmlType umltype;
    private final UmlRelation umlrelation;

    public InternalGraphRepresentation(Class[] allClasses) {
        this.umltype = new UmlType(allClasses);
        this.umlrelation = new UmlRelation(umltype);
    }

    public UmlType getUmlType() {
        return umltype;
    }

    public UmlRelation getUmlRelation() {
        return umlrelation;
    }
}
