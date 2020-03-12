# Makefile for District UI Components
# 
# Requirements:
#  - CircleCI CLI
#  - Leiningen
.PHONY: help deps test test-circleci clean clean-all

help:
	@echo "Makefile for District UI Components"
	@echo ""
	@echo "  deps                   :: Retrieve Library Dependencies (clojure, npm)"
	@echo "  test                   :: Run doo test runner"
	@echo "  test-circleci          :: Run doo test runner using local CircleCI execution"
	@echo "  --"
	@echo "  clean                  :: Clean out build artifacts"
	@echo ""

deps:
	lein deps
	lein npm install

test:
	lein doo once

process.yml: .circleci/config.yml
	circleci config process .circleci/config.yml > process.yml

test-circleci: process.yml
	circleci local execute -c process.yml --job test

clean:
	lein clean
	rm -f process.yml

clean-all: clean
	rm -rf node_modules
