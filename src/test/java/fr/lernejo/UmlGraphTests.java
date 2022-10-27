package fr.lernejo;

import fr.lernejo.umlgrapher.GraphType;
import fr.lernejo.umlgrapher.UmlGraph;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import fr.lernejo.umlgrapher.Launcher;




class UmlGraphTests {
       @Test
       void empty_interface_with_no_relation() {

            Class[] allClasses = new Class[]{Machin.class};
            UmlGraph umlgraph = new UmlGraph(allClasses);

            String output = umlgraph.as(GraphType.Mermaid);

           Assertions.assertThat(output).isEqualTo("""
            classDiagram
            class Machin {
                <<interface>>
            }
            """);
      }
            interface Machin {
            }

}

