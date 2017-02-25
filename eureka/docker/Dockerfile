FROM frolvlad/alpine-oraclejdk8:slim

VOLUME /tmp

ENV APP_HOME /opt/app
RUN mkdir -p $APP_HOME

ADD frontend-*.jar $APP_HOME/app.jar

WORKDIR $APP_HOME
RUN sh -c 'touch app.jar'

ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]
