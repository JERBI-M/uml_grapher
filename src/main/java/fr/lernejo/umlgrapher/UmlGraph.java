package fr.lernejo.umlgrapher;

public class UmlGraph {
    
	private final Class [] allClasses;
        public UmlGraph(Class[] allClasses) {
        this.allClasses = allClasses;
    }


    public String as(GraphType graphType) {
	String out ="";
	if(graphType == GraphType.Mermaid) 
	{ 
	   
           InternalGraphRepresentation graphiq = new InternalGraphRepresentation(allClasses);
           out = new MermaidFormatter().shape(graphiq);
        
              
        }
	return out;
        
        }

    }

