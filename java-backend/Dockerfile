FROM ubuntu 


ARG JAVA_VERSION=17

ARG MAVEN_VERSION=3.9.5

RUN mkdir softwares

WORKDIR /softwares

# installing JAVA and maven 
RUN apt-get update -y && apt-get install curl -y && apt install openjdk-${JAVA_VERSION}-jdk -y \
    && curl -O https://dlcdn.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz\
    && tar -xvf apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    && rm -rf apache-maven-${MAVEN_VERSION}-bin.tar.gz


# Cleanup unnecessary directories
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*


ENV  JAVA_HOME=/usr/lib/jvm/java-${JAVA_VERSION}-openjdk-amd64 \
     MAVEN_HOME=/softwares/apache-maven-${MAVEN_VERSION} \
     PATH=$PATH:$JAVA_HOME/bin:$MAVEN_HOME/bin 

WORKDIR /bin

#adding symbolic link mvn 
RUN ln -s /softwares/apache-maven-${MAVEN_VERSION}/bin/mvn mvn 

#copying pom.xml to opt

WORKDIR /opt/server/

COPY pom.xml .

COPY src /opt/server/

RUN mvn install \
    && mvn package


#RUN java -version && mvn -version
   





