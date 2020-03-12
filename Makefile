# Makefile for testing district-ui-router

.SUFFIXES:
.PHONY: help test test-circleci clean

help:
	@echo "Makefile for testing district-ui-router"
	@echo ""
	@echo "  test                   :: Run doo test runner"
	@echo "  test-circleci          :: Run doo test runner using local CircleCI execution"
	@echo "  --"
	@echo "  clean                  :: Clean out build artifacts"
	@echo ""

test:
	lein doo once


process.yml:
	circleci config process .circleci/config.yml > process.yml


test-circleci: process.yml
	circleci local execute -c process.yml --job test


clean:
	lein clean
	rm -f process.yml
