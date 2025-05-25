install:
	make -C app install

run-dist:
	make -C app run-dist

build:
	make -C app build

report:
	make -C app report

test:
	make -C app test

lint:
	make -C app lint

.PHONY: build
