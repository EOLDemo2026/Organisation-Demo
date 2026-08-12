This is a minimal Spring Framework 5 (non-Boot) demo application targeting Java 1.8.

Build
1. Ensure Java 1.8 and Maven are installed.
2. Build: mvn clean package

Run
Option A — run from classes + dependencies (Unix/macOS):
1. mvn dependency:copy-dependencies -DoutputDirectory=target/dependency
2. java -cp target/classes:target/dependency/* com.eoldemo.MainApp

(Windows: use `;` as classpath separator)

Option B — run with Maven Exec:
1. mvn exec:java -Dexec.mainClass=com.eoldemo.MainApp

Tests
mvn test
