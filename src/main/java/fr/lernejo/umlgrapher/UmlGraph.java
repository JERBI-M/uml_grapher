package fr.lernejo.umlgrapher;
import java.lang.reflect.Modifier;

public class UmlGraph {
    
	private final Class [] allClasses;
        public UmlGraph(Class[] allClasses) {
        this.allClasses = allClasses;
    }


    public String as(GraphType graphType) {
	String out ="";
	if(graphType == GraphType.Mermaid) 
	{ 
	try{   
           InternalGraphRepresentation graphiq = new InternalGraphRepresentation(allClasses);
           out = new MermaidFormatter().shape(graphiq);
	}catch (RuntimeException e){
           System.out.println("There is an error :" +e.getClass() + "-" + e.getMessage()); 
	}

              
        }
	return out;
        
        }

    }

