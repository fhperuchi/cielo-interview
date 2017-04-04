FROM openjdk:8-jre

ENV PATH /usr/local/groovy/bin:$PATH

ENV GROOVY_VERSION 2.4.7

RUN set -x \
	&& wget -O groovy.zip "https://dl.bintray.com/groovy/maven/apache-groovy-binary-${GROOVY_VERSION}.zip" \
	&& wget -O groovy.zip.asc "https://dl.bintray.com/groovy/maven/apache-groovy-binary-${GROOVY_VERSION}.zip.asc" \
	\
	&& export GNUPGHOME="$(mktemp -d)" \
	&& gpg --keyserver ha.pool.sks-keyservers.net --recv-keys '7FAA0F2206DE228F0DB01AD741321490758AAD6F' \
	&& gpg --batch --verify groovy.zip.asc groovy.zip \
	&& rm -r "$GNUPGHOME" groovy.zip.asc \
	\
	&& unzip groovy.zip \
	&& rm groovy.zip \
	&& mv "groovy-${GROOVY_VERSION}" /usr/local/groovy \
	\
	&& groovy --version

ENV tz America/Sao_Paulo
RUN cp -vf /usr/share/zoneinfo/$tz /etc/localtime
RUN echo $tz | tee /etc/timezone

ENV DEBIAN_FRONTEND noninteractive
ENV JAVA_OPTS "-Xmx512M -Xms512M"
ENV PATH $PATH:$JAVA_HOME/bin
ENV APP_HOME executor
RUN mkdir $APP_HOME
WORKDIR $APP_HOME
COPY src/test/TaskExecutor.groovy $APP_HOME/TaskExecutor.groovy
CMD ["groovy", "executor/TaskExecutor.groovy"]