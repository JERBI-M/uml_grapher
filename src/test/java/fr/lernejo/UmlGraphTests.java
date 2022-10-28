package fr.lernejo;

import fr.lernejo.umlgrapher.GraphType;
import fr.lernejo.umlgrapher.UmlGraph;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import fr.lernejo.umlgrapher.Launcher;
import java.util.ArrayList;



class UmlGraphTests {



         @Test
         void empty_interface_with_no_relation() {
            Class[] allClasses = new Class[]{Machin.class};
            UmlGraph graph = new UmlGraph(allClasses);
            String output = graph.as(GraphType.Mermaid);
             Assertions.assertThat(output).isEqualTo("""
             classDiagram
             class Machin {
                 <<interface>>
             }
             """);
         }

        @Test
        void interface_with_relation() {
        Class[] allClasses = new Class[]{
            Living.Animal.Ant.class,
            Living.Animal.Cat.class,
            Living.Plant.Tree.Alder.class
        };
        UmlGraph graph = new UmlGraph(allClasses);

        String output = graph.as(GraphType.Mermaid);

        Assertions.assertThat(output).isEqualTo("""
            classDiagram
            class Alder
            class Animal {
                <<interface>>
            }
            class Ant
            class Cat
            class Living {
                <<interface>>
            }
            class Plant {
                <<interface>>
            }
            class Tree {
                <<interface>>
            }
            Tree <|.. Alder : implements
            Living <|-- Animal : extends
            Animal <|.. Ant : implements
            Animal <|.. Cat : implements
            Living <|-- Plant : extends
            Plant <|-- Tree : extends
            """);
       }



     @Test
     void launcher_main_test() {
        new Launcher();
     }

     interface Machin {
     }


     public sealed interface Living {
        sealed interface Animal extends Living {
            final class Ant implements Animal {
            }

            final class Cat implements Animal {
            }
        }

        sealed interface Plant extends Living {
            sealed interface Tree extends Plant {
                final class Alder implements Tree {
                }
            }
        }
    }



}

