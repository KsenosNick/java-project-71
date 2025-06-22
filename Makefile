default:
	@echo "Use targets: build, test, report, lint, run"

build:
	$(MAKE) -C app build

test:
	$(MAKE) -C app test

report:
	$(MAKE) -C app report

lint:
	$(MAKE) -C app lint

run:
	$(MAKE) -C app run-dist

install:
	$(MAKE) -C app install
