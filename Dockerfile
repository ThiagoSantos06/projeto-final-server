# Etapa de build (com Maven instalado)
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copia pom.xml e baixa dependências antes (cache)
COPY pom.xml .
RUN mvn -q dependency:go-offline

# Agora copia o resto do projeto
COPY src ./src

# Gera o jar
RUN mvn -q -DskipTests package


# Etapa final: executa o jar
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
