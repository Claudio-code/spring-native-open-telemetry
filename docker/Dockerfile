FROM ghcr.io/graalvm/graalvm-community:21 AS build

USER root

RUN microdnf install findutils

WORKDIR /code

COPY settings.gradle .
COPY build.gradle .
COPY src src
COPY gradlew gradlew
COPY gradle gradle

RUN ./gradlew nativeCompile -x test

FROM debian:12-slim

COPY --from=build /code/build/native/nativeCompile/* .

EXPOSE 8080

CMD ["./Spring"]