package fr.lernejo.umlgrapher;

import java.util.ArrayList;

public class UmlGraph {

	private final Class[] classes ; 

    public UmlGraph(Class[] classes) {
	    this.classes = classes;

    }

    public String as(GraphType graphType) {
         return this.getMermaidSyntax();
        
    }

    private String getMermaidSyntax() {
        StringBuilder check_syntaxe = new StringBuilder("classDiagram\n");
        for (Class classe : this.classes) {
            check_syntaxe.append("class ")
                .append(classe.getSimpleName())
                .append(" {\n")
                .append("    <<").append(classe.toString()
                    .split(" ")[0])
                .append(">>\n")
                .append("}\n");
        }
	return check_syntaxe.toString();

}
}
