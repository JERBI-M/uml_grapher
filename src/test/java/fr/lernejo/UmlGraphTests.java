package fr.lernejo;

import fr.lernejo.umlgrapher.GraphType;
import fr.lernejo.umlgrapher.Launcher;
import fr.lernejo.umlgrapher.UmlGraph;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import fr.lernejo.umlgrapher.Launcher;



class UmlGraphTests {
    @Test
    void empty_interface_with_no_relation() {

   
        Class[] classes = new Class[] {Machin.class};
	UmlGraph graph = new UmlGraph(classes);


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
        Class[] classes = new Class[]{
            Living.Animal.Ant.class,
            Living.Animal.Cat.class,
            Living.Plant.Tree.Alder.class
        };
        UmlGraph graph = new UmlGraph(classes);

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
    void class_without_relation() {
        Class[] classes = new Class[]{School.Second.Student.class};
        UmlGraph graph = new UmlGraph(classes);

        String output = graph.as(GraphType.Mermaid);

        Assertions.assertThat(output).isEqualTo("""
            classDiagram
            class Student
            """);
    }

    @Test
    void class_with_relation() {
        Class[] classes = new Class[]{Car.Ferrari.class};
        UmlGraph graph = new UmlGraph(classes);

        String output = graph.as(GraphType.Mermaid);

        Assertions.assertThat(output).isEqualTo("""
            classDiagram
            class Car
            class Ferrari
            Car <|-- Ferrari : extends
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

    public class School {
        public class Second {
            public class Student {

            }
        }
    }

    public class Car {
        public class Ferrari extends Car {
        }
    }

    
    }

