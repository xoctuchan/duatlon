FROM quay.io/centos/centos:stream9

# Establecer el directorio de trabajo
WORKDIR /app

RUN dnf install -y java-21-openjdk cronie vim nano openssh-clients procps postgresql-client && dnf clean all

RUN mkdir -p /app/jars

COPY target/tiempos-0.0.1-SNAPSHOT.jar /app/jars/tiempos-0.0.1-SNAPSHOT.jar


RUN pg_isready -h db.wionppapgytecjiogdio.supabase.co -p 5432

CMD ["java", "-jar", "/app/jars/tiempos-0.0.1-SNAPSHOT.jar"]