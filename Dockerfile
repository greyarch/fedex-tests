FROM openjdk:20-slim

ARG CHROMEDRIVER_VERSION=107.0.5304.18

RUN apt update \
    && apt install -y chromium maven ca-certificates \
    curl unzip \
    && curl -sSLO https://chromedriver.storage.googleapis.com/${CHROMEDRIVER_VERSION}/chromedriver_linux64.zip \
    && unzip chromedriver_linux64.zip \
    && apt remove -y --purge curl unzip \
    && rm chromedriver_linux64.zip \
    && mv chromedriver /usr/bin/chromedriver \
    && chmod +x /usr/bin/chromedriver