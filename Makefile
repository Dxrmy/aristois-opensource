# Convenience wrapper around the scripts. See BUILDING.md for details.

MC ?= 1.21.4
JAR ?= libs/aristois-452.jar
OUT ?= recovered/java

.PHONY: help verify recover client build install clean

help:
	@echo "targets:"
	@echo "  verify   - python syntax + installer artifact check"
	@echo "  recover  - decompile $(JAR) into $(OUT)"
	@echo "  client   - build the clean-room client jar"
	@echo "  build    - build the EMC framework with Gradle"
	@echo "  install  - install the last released version for Minecraft $(MC)"
	@echo "  clean    - remove Gradle build output"

verify:
	python3 -m py_compile scripts/*.py installer/*.py mappings/*.py
	python3 installer/install.py --mc $(MC) --verify

recover:
	python3 scripts/deobfuscate.py --jar $(JAR) --out $(OUT)

client:
	./gradlew emcClientJar

build:
	./gradlew build

install:
	python3 installer/install.py --mc $(MC)

clean:
	./gradlew clean
