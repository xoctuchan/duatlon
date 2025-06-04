FROM quay.io/centos/centos:stream9

# Establecer el directorio de trabajo
WORKDIR /app

RUN dnf install -y java-21-openjdk cronie vim nano openssh-clients procps && dnf clean all

RUN mkdir -p /app/jars

COPY target/tiempos-0.0.1-SNAPSHOT.jar /app/jars/tiempos-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/app/jars/tiempos-0.0.1-SNAPSHOT.jar"]