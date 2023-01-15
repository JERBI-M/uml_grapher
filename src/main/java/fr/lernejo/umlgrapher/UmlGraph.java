package fr.lernejo.umlgrapher;

import java.util.ArrayList;

public class UmlGraph {

	ArrayList<Class> classes ; 

    public UmlGraph(ArrayList<Class> classes) {
	    this.classes = classes;

    }

    public String as(GraphType graphType) {
         return switch (graphType) {
            case Mermaid -> this.getMermaidSyntax();
        };
    }

    private String getMermaidSyntax() {
        StringBuilder check_syntaxe = new StringBuilder("classDiagram\n");

        for (Class la_classe : this.classes) {
            check_syntaxe.append("class ")
                .append(la_classe.getSimpleName())
                .append(" {\n")
                .append("    <<").append(la_classe.toString()
                    .split(" ")[0])
                .append(">>\n")
                .append("}\n");
        }
	return check_syntaxe.toString();

}
}
