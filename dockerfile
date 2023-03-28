FROM alpine

RUN mkdir /app

WORKDIR /app

COPY . /app

RUN apk update && apk add maven

RUN mvn package

EXPOSE 3000:8080

CMD ["mvn", "spring-boot:run"]