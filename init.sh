#!/bin/bash

dti=$(date '+%d/%m/%Y %H:%M:%S')

echo '+------------------------------------------------------------------'
echo '|     PATRONES DE ARQUITECTURA UNIVERSIDAD JAVERIANA               '
echo '|     FECHA    : '$dti
echo '|     AUTORES  : EQUIPO 5                                          '
echo '|     DESCRIPC : CREACION E INICIO DE CONTENEDORES DEL BANCO ABC   '
echo '+------------------------------------------------------------------'

echo 'Deteniendo contenedores en ejecucion...'
docker stop $(docker ps -a -q --filter="name=service")
docker stop $(docker ps -a -q --filter="name=db_")

echo 'Eliminando contenedores'
docker rm $(docker ps -a -q --filter="name=service")
docker rm $(docker ps -a -q --filter="name=db_")

echo 'Eliminando Imagenes'
docker rmi $(docker images --format '{{.Repository}}:{{.Tag}}' | grep 'service')
docker rmi $(docker images --format '{{.Repository}}:{{.Tag}}' | grep 'db_')

# Eliminando redes en caso de que existan
echo 'Eliminando redes...'
docker network rm $(docker network ls | grep "backend" | awk '/ / { print $1 }')

# Creando la red comun para todos los contenedores
echo 'Creando red backend'
docker network create --driver bridge backend

# Construyendo servicio del servidor de seguridad
echo 'Compilando fuentes y generando artefactos del servidor de seguridad...'
mvn -f securityserver/pom.xml clean package -Dmaven.test.skip=true

# Construyendo servicio de cotizaciones
echo 'Compilando fuentes y generando artefactos de la aplicacion de cotizaciones...'
mvn -f cotizaciones/pom.xml clean package -Dmaven.test.skip=true

# Construyendo imagenes de aplicaciones y generando contenedores
echo 'Construyendo imagenes de aplicaciones y generando contenedores...'

docker build --no-cache=true --build-arg BUILD_DATE=$(date -u +'%Y-%m-%dT%H:%M:%SZ') --build-arg BUILD_VERSION=1.0-stable --tag=security-service:latest --rm=true securityserver/
docker-compose -f securityserver/docker-compose.yml up -d

docker build --no-cache=true --build-arg BUILD_DATE=$(date -u +'%Y-%m-%dT%H:%M:%SZ') --build-arg BUILD_VERSION=1.0-stable --tag=cotizaciones-service:latest --rm=true cotizaciones/
docker-compose -f cotizaciones/docker-compose.yml up -d

dtf=$(date '+%d/%m/%Y %H:%M:%S')

echo 'Iniciado  a : ' $dti
echo 'Terminado a : ' $dtf