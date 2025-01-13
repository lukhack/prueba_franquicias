# Utiliza una imagen base con Java 21
FROM openjdk:21-slim
# Establecemos el directorio de trabajo
WORKDIR /app

# Copiamos el archivo jar de nuestra aplicación al directorio de trabajo
COPY target/*.jar app.jar

# Exponemos el puerto de nuestra aplicación
EXPOSE 9090

# Ejecutamos la aplicación
CMD ["java", "-jar", "app.jar"]