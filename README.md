# University-CI-Project-1

```
java -jar jflex-full-1.8.2.jar scanner.jflex
java -jar java-cup-11b.jar parser.cup
javac -cp java-cup-11a.jar Main.java parser.java scanner.java sym.java
java -cp java-cup-11b.jar:. Main
```