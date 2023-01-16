package fr.lernejo.umlgrapher;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;


public class UmlGraph {

    private final Class[] classes;

    public UmlGraph(Class[] classes) {
        this.classes = classes;
    }

    public String as(GraphType graphType) {
        String result = "";
        if (graphType == GraphType.Mermaid) {
            InternalGraphRepresentation graph = new InternalGraphRepresentation(classes);
            result = new MermaidFormatter().format(graph);
        }
        return result;
    }
}

