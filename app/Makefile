run-dist:
	./build/install/app/bin/app
install:
	./gradlew installDist
run: install run-dist
checkStyleMain:
	./gradlew checkStyleMain
build: checkStyleMain install
