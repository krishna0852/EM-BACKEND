FROM ubuntu 


RUN mkdir softwares

WORKDIR /softwares

# installing JAVA-17
RUN apt-get update -y && apt-get install curl -y && apt install openjdk-17-jdk -y 

# installing MAVEN
RUN curl -O https://dlcdn.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.tar.gz\
    && tar -xvf apache-maven-3.9.5-bin.tar.gz \
    && rm -rf apache-maven-3.9.5-bin.tar.gz 


ENV  JAVA_HOME=/usr/lib/jvm/jdk-17 \
     MAVEN_HOME=/softwares/apache-maven-3.9.5 \
     PATH=$PATH:$JAVA_HOME/bin:$MAVEN_HOME/bin 

RUN java -version && mvn -version
   





