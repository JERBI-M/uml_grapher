package fr.lernejo.umlgrapher;

public class UmlGraph {

	public UmlGraph (Class class_name){

	}

	public String as(GraphType graphType){

		return """
		classDiagram
		class Machin {
			<<interface>>
		}

		""";

	}
    
	

    }

