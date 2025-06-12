install:
	gradle clean
	gradle installDist

run-dist:
	./build/install/app/bin/app

build:
	./gradlew clean build

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain
	./gradlew checkstyleTest

.PHONY: build