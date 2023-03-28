FROM ubuntu

RUN mkdir /app

WORKDIR /app

COPY . /app

RUN apt update && apt install -y maven

RUN mvn package

EXPOSE 3000:8080

CMD ["mvn", "spring-boot:run"]