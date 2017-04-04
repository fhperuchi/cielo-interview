FROM groovy:jdk8

ENV DEBIAN_FRONTEND noninteractive
ENV JAVA_OPTS "-Xmx512M -Xms512M"
ENV PATH $PATH:$JAVA_HOME/bin
ENV TIME_ZONE America/SaoPaulo

ENV APP_HOME /executor

RUN echo "$TIME_ZONE" > /etc/timezone \
    && dpkg-reconfigure -f noninteractive tzdata\
    && mkdir $APP_HOME


WORKDIR $APP_HOME
COPY src/test/TaskExecutor.groovy $APP_HOME/TaskExecutor.groovy

ENTRYPOINT ["groovy","/executor/TaskExecutor.groovy"]