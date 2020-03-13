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

test-circleci:
	circleci local execute --job test

clean:
	lein clean

clean-all: clean
	rm -rf node_modules
